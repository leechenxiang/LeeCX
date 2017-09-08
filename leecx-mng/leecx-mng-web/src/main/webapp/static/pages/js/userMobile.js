var UserMobile = function () {

    // 手机号修改
	var handleUserMobile = function() {
		
		jQuery.validator.addMethod("correctMobile", function(value, element) {
    		var mobileReg = /^1(2|3|4|5|6|7|8|9)\d{9}$/;		
    		return mobileReg.test(value);
    	}, "手机格式不正确.");
		
		jQuery.validator.addMethod("correctAuthCode", function(value, element) {
    		
    		var mobile = $("#mobile").val();
			var authCode = value;
	    	var flag = true;
	        $.ajax({
	        	url: $("#hdnContextPath").val() + "/userInfo/correctAuthCodeReBindMobile.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"mobile": mobile, "authCode": authCode},
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
		}, "手机动态验证码不正确或者已失效...");
		
		jQuery.validator.addMethod("mobileIsExist", function(value, element) {
    		
			var mobile = value;
	    	var flag = true;
	        $.ajax({
	        	url: $("#hdnContextPath").val() + "/user/mobileIsExist.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"mobile": mobile},
	        	success: function(data) {
	                if(data.status == 200 && data.msg == "OK") {
	                	if (data.data) {
	                		flag = false;
	                	} else {
	                		flag = true;
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
		}, "该手机已被绑定,请换一个手机号再试...");
		
		// 手机号验证正确，则显示按钮
        $('#mobile').keyup(function(e) {
            var mobile = $(this).val()
            
            var mobileReg = /^1(2|3|4|5|6|7|8|9)\d{9}$/;		
    		var flag = mobileReg.test(mobile);
    		
    		var mobileExist = false;
    		$.ajax({
	        	url: $("#hdnContextPath").val() + "/user/mobileIsExist.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"mobile": mobile},
	        	success: function(data) {
	                if(data.status == 200 && data.msg == "OK") {
	                	if (data.data) {
	                		mobileExist = true;
	                	}
	                } else {
	                	console.log(JSON.stringify(data));
	                }
	        	},
                error: function (response, ajaxOptions, thrownError) {
                	Error.displayError(response, ajaxOptions, thrownError);                
                }
	        });
    		
    		// 只要手机号存在，那就肯定disable
    		if (!flag || mobileExist) {
    			$("#btnGetAuthCode").attr("disabled", true);
    		} else {
    			$("#btnGetAuthCode").attr("disabled", false);
    		}
        });
        
        // 获取验证码
        $('#btnGetAuthCode').click(function(e) {
            var mobile = $("#mobile").val()
            
    		$.ajax({
	        	url: $("#hdnContextPath").val() + "/userInfo/getReBindMobileSMS.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"mobile": mobile},
	        	success: function(data) {
	                if(data.status == 200 && data.msg == "OK") {
                		$("#totalSecond").val(91);
//                		$("#totalSecond").val(6);
                        $("#btnGetAuthCode").attr("disabled", true);
                        $("#mobile").attr("disabled", true);
                        setInterval(getOneMoreSMS, 1000);
	                } else {
	                	console.log(JSON.stringify(data));
	                	SweetAlert.error(data.msg)
	                }
	        	},
                error: function (response, ajaxOptions, thrownError) {
                	Error.displayError(response, ajaxOptions, thrownError);                
                }
	        });
    		
        });
    	
        $('#userMobileForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	mobile: {
                	required: true,
                	correctMobile: true,
                	mobileIsExist: true
                },
                authCode: {
                	required: true,
                	correctAuthCode: true
                }
            },

            messages: {
            	mobile: {
                    required: "手机不能为空."
                },
                authCode: {
                	required: "手机动态验证码不能为空."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#userMobileForm')).show();
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
            
            	var userMobileForm = $('#userMobileForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	
//            	var json = userMobileForm.serialize();
            	
            	userMobileForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/userInfo/updateUserMobile.shtml', // 需要提交的 url
                    data: {"mobile": $("#mobile").val()},
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.success("手机更换修改成功！");
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

        $('#userMobileForm input').keypress(function(e) {
            if (e.which == 13) {
                if ($('#userMobileForm').validate().form()) {
                    $('#userMobileForm').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
        
    }
	
	var getOneMoreSMS = function() {
    	var second = $("#totalSecond").val();
		if (second == 1) {
			clearInterval(getOneMoreSMS);  
			$('#btnGetAuthCode').html("获取验证码")
			$("#btnGetAuthCode").attr("disabled", false);
			$("#mobile").attr("disabled", false);
		} else if (second == 0) {
			clearInterval(getOneMoreSMS);  
		} else {
			var s = second - 1;
			$("#totalSecond").val(s);
			$('#btnGetAuthCode').html("获取验证码(" + s + "秒)")
		}
	}
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	
        	handleUserMobile();
        	
        }

    };

}();

jQuery(document).ready(function() {
	UserMobile.init();
});