var UserInfo = function () {

    // 意见反馈
	var handleUserPwd = function() {
		
		jQuery.validator.addMethod("eqOldPwd", function(value, element) {
    		
			var oldPassword = $("#oldPassword").val();
			var userId = $("#id").val();
			
    		var username = value;
        	var flag = true;
            $.ajax({
            	url: $("#hdnContextPath").val() + "/userInfo/checkUserOldPwd.shtml",
            	type: "POST",
            	async: false,
            	data: {"oldPassword": oldPassword, "userId": userId},
            	success: function(data) {
                    if(data.status == 200 && data.msg == "OK") {
                    	if (data.data) {
                    		flag = true;
                    	} else {
                    		flag = false;
                    	}
                    } else {
                    	console.log(JSON.stringify(data));
                    }
            	},
                error: function (response, ajaxOptions, thrownError) {
                	Error.displayError(response, ajaxOptions, thrownError);                
                }
            });
        	
        	return flag;
    	}, "原密码不一致，请重新输入...");
		
		jQuery.validator.addMethod("correctPassword", function(value, element) {
    		var passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;		
    		return passwordReg.test(value);
    	}, "密码必须由6-20位数字加字母组成.");
    	
        $('#userPwdForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	oldPassword: {
                    required: true,
                    eqOldPwd: true
                },
                newPassword: {
                	required: true,
                	correctPassword: true
                },
                confirmPassword: {
                	required: true,
                	equalTo: "#newPassword"
                }
            },

            messages: {
            	oldPassword: {
            		required: "旧密码不能为空.",
                },
                newPassword: {
                	required: "新密码不能为空.",
                },
                confirmPassword: {
                	required: "确认密码不能为空.",
                    equalTo: "两次密码输入不一致."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#userPwdForm')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('#input-error'));
            },

            submitHandler: function(form) {
            	
            	App.blockUI();
            
            	var userPwdForm = $('#userPwdForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	userPwdForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/userInfo/updatePwd.shtml', // 需要提交的 url
                    data: userPwdForm.serialize(),
                    success: function(data) {
                        // 密码修改成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.success("密码修改成功！");
                        	userPwdForm[0].reset();
                        	App.unblockUI();
                        } else {
                        	SweetAlert.error(data.msg);
                        	App.unblockUI();
                        }
                    },
	                error: function (response, ajaxOptions, thrownError) {
	                	Error.displayError(response, ajaxOptions, thrownError); 
	                	App.unblockUI();
	                }
                });
            	
            }
        });

        $('#userPwdForm input').keypress(function(e) {
            if (e.which == 13) {
                if ($('#userPwdForm').validate().form()) {
                    $('#userPwdForm').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
        
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	
        	handleUserPwd();
        	
        }

    };

}();

jQuery(document).ready(function() {
	UserInfo.init();
});