var Login = function() {

    var handleLogin = function() {

        $('.login-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                },
                remember: {
                    required: false
                }
            },

            messages: {
                username: {
                    required: "Username is required."
                },
                password: {
                    required: "Password is required."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit(); // form validation success, call ajax form submit
            }
        });

        $('.login-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.login-form').validate().form()) {
                    $('.login-form').submit(); //form validation success, call ajax form submit
                }
                return false;
            }
        });
    }

    // 使用手机号重置密码
    var handleForgetPasswordUseMobile = function() {
    	
    	jQuery.validator.addMethod("correctMobile", function(value, element) {
    		var mobileReg = /^1(2|3|4|5|6|7|8|9)\d{9}$/;		
    		return mobileReg.test(value);
    	}, "手机格式不正确.");
    	
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
		}, "该手机不存在.");
    	
    	jQuery.validator.addMethod("correctAuthCode", function(value, element) {
    		
    		var mobile = $("#mobile").val();
			var authCode = value;
	    	var flag = true;
	        $.ajax({
	        	url: $("#hdnContextPath").val() + "/user/correctAuthCode.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"mobile": mobile, "authCode": authCode},
	        	success: function(data) {debugger;
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
    	
        $('.forget-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
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

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
        });

        // 使用邮箱找回密码
        jQuery('#forget-password').click(function() {
            jQuery('.login-form').hide();
            jQuery('.forget-form').show();
        });

        jQuery('#back-btn').click(function() {
            jQuery('.login-form').show();
            jQuery('.forget-form').hide();
        });
        
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
	        	url: $("#hdnContextPath").val() + "/user/getRegistSMS.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"mobile": mobile},
	        	success: function(data) {
	                if(data.status == 200 && data.msg == "OK") {
                		$("#totalSecond").val(91);
//                		$("#totalSecond").val(6);
                        $("#btnGetAuthCode").attr("disabled", true);
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

    }
    
    // 使用email重置密码
    var handleForgetPasswordUseEmail = function() {
        $('.forget-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
                email: {
                    required: true,
                    email: true
                }
            },

            messages: {
                email: {
                    required: "Email is required."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
        });

        // 使用邮箱找回密码
        jQuery('#forget-password').click(function() {
            jQuery('.login-form').hide();
            jQuery('.forget-form').show();
        });

        jQuery('#back-btn').click(function() {
            jQuery('.login-form').show();
            jQuery('.forget-form').hide();
        });

    }

    var handleRegister = function() {

        function format(state) {
            if (!state.id) { return state.text; }
            var $state = $(
             '<span><img src="../assets/global/img/flags/' + state.element.value.toLowerCase() + '.png" class="img-flag" /> ' + state.text + '</span>'
            );
            
            return $state;
        }

        if (jQuery().select2 && $('#country_list').size() > 0) {
            $("#country_list").select2({
	            placeholder: '<i class="fa fa-map-marker"></i>&nbsp;Select a Country',
	            templateResult: format,
                templateSelection: format,
                width: 'auto', 
	            escapeMarkup: function(m) {
	                return m;
	            }
	        });


	        $('#country_list').change(function() {
	            $('.register-form').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
	        });
    	}

        $('.register-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {

                fullname: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                address: {
                    required: true
                },
                city: {
                    required: true
                },
                country: {
                    required: true
                },

                username: {
                    required: true
                },
                password: {
                    required: true
                },
                rpassword: {
                    equalTo: "#register_password"
                },

                tnc: {
                    required: true
                }
            },

            messages: { // custom messages for radio buttons and checkboxes
                tnc: {
                    required: "Please accept TNC first."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   

            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
                    error.insertAfter($('#register_tnc_error'));
                } else if (element.closest('.input-icon').size() === 1) {
                    error.insertAfter(element.closest('.input-icon'));
                } else {
                    error.insertAfter(element);
                }
            },

            submitHandler: function(form) {
                form[0].submit();
            }
        });

        $('.register-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.register-form').validate().form()) {
                    $('.register-form').submit();
                }
                return false;
            }
        });

        jQuery('#register-btn').click(function() {
            jQuery('.login-form').hide();
            jQuery('.register-form').show();
        });

        jQuery('#register-back-btn').click(function() {
            jQuery('.login-form').show();
            jQuery('.register-form').hide();
        });
    }

    var getOneMoreSMS = function() {
    	var second = $("#totalSecond").val();
		if (second == 1) {
			clearInterval(getOneMoreSMS);  
			$('#btnGetAuthCode').html("获取手机动态验证码")
			$("#btnGetAuthCode").attr("disabled", false);
		} else {
			var s = second - 1;
			$("#totalSecond").val(s);
			$('#btnGetAuthCode').html("获取手机动态验证码(" + s + "秒)")
		}
	}
    
    return {
        //main function to initiate the module
        init: function() {

            handleLogin();
//            handleForgetPassword();
            handleForgetPasswordUseMobile();
            handleRegister();

        }

    };

}();

jQuery(document).ready(function() {
    Login.init();
});