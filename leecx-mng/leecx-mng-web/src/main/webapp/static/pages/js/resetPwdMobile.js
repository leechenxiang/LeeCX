var ResetPwd = function() {
	
    var handleResetPwd = function() {
    	
    	jQuery.validator.addMethod("correctPassword", function(value, element) {
    		var passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;		
    		return passwordReg.test(value);
    	}, "密码必须由6-20位数字加字母组成.");
    	
        $('#resetPwdForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
                password: {
                    required: true,
                    correctPassword: true
                    
                },
                confirmPassword: {
                    required: true,
                    equalTo: "#password"
                }
            },

            messages: {
                password: {
                    required: "密码不能为空."
                },
                confirmPassword: {
                    required: "确认密码不能为空.",
                    equalTo: "两次密码输入不一致."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#resetPwdForm')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
            	var resetPwdForm = $('#resetPwdForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	resetPwdForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/user/userResetPwdDisplay.shtml', 			// 需要提交的 url (用户名注册)
                    data: resetPwdForm.serialize(),
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.userResetPwdSuccess();
                        } else {
                        	SweetAlert.error(data.msg);
                        }
                    },
	                error: function (response, ajaxOptions, thrownError) {
	                	Error.displayError(response, ajaxOptions, thrownError);                
	                }
                });
            }
        });

        $('#resetPwdForm input').keypress(function(e) {
            if (e.which == 13) {
                if ($('#resetPwdForm').validate().form()) {
                    $('#resetPwdForm').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
        
    }
    
    return {
        //main function to initiate the module
        init: function() {

            handleResetPwd();
            
            // init background slide images
            $('.login-bg').backstretch([
                $("#hdnContextPath").val() + "/static/pages/img/login/1.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/2.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/3.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/4.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/5.jpg"
                ], {
                  fade: 1000,
                  duration: 8000
                }
            );

        }

    };

}();

jQuery(document).ready(function() {
	ResetPwd.init();
});