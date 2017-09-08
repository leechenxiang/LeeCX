var Login = function() {

	// 构建登录对象
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
                    required: "用户名不能为空."
                },
                password: {
                    required: "密码不能为空."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('.login-form')).show();
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
            	
            	var loginForm = $('#loginForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	loginForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/login.shtml', // 需要提交的 url
                    data: loginForm.serialize(),
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	var url = window.location.href;
                        	var urlarr = url.split("redirectUrl=");
                        	if (urlarr.length == 2) {
                        		var url = urlarr[1];
                        		window.location.href = hdnContextPath + url;
                        	} else {
                        		window.location.href = hdnContextPath + "/";
                        	}
                        	
                        } else {
                        	SweetAlert.error(data.msg);
//                        	alert(data.msg);
                        }
                    },
	                error: function (response, ajaxOptions, thrownError) {
	                	Error.displayError(response, ajaxOptions, thrownError);                
	                }
                });
            	
//                form.submit(); // form validation success, call ajax form submit
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

        $('#forget-password').click(function(){
            $('.login-form').hide();
            $('.forget-form').show();
        });

        $('#back-btn').click(function(){
            $('.login-form').show();
            $('.forget-form').hide();
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
	        	url: $("#hdnContextPath").val() + "/user/correctAuthCodeResetPwd.shtml",
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
//                alert(111);
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
	                	if (!data.data) {
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
	        	url: $("#hdnContextPath").val() + "/user/getResetPwdSMS.shtml",
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

    // 构建忘记密码对象
    var handleForgetPasswordUseEmail = function() {
    	
    	jQuery.validator.addMethod("emailIsExist", function(value, element) {
    		
			var email = value;
	    	var flag = true;
	        $.ajax({
	        	url: $("#hdnContextPath").val() + "/user/emailIsExist.shtml",
	        	type: "POST",
	        	async: false,
	        	data: {"email": email},
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
	    	
	    	return !flag;
		}, "该邮箱地址不存在.");
    	
    	jQuery.validator.addMethod("correctEmail", function(value, element) {
    		var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w{2,})*\.\w{2,}([-.]\w{2,})*$/;		
    		return emailReg.test(value);
    	}, "邮箱格式不正确.");

        $('.forget-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                email: {
                    required: true,
                    correctEmail: true,
                    emailIsExist: true
                }
            },

            messages: {
            	email: {
                    required: "邮箱地址不能为空."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('.forget-form')).show();
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
            	
            	var forgetPwdForm = $('.forget-form');
            	var hdnContextPath = $("#hdnContextPath").val();
            	var email = $("#email").val();
            	forgetPwdForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/user/sendForgetPwdMail.shtml', // 需要提交的 url
                    data: forgetPwdForm.serialize(),
                    success: function(data) {
                        // 发送email成功
                        if (data.status == 200 && data.msg == "OK") {
                        	afterSubmit();
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
        
        var afterSubmit = function() {
        	$('.forget-form').hide();
            $('#afterSendEmail').show();
            $("#yourEmail").html($("#email").val());
        };
        
     // 跳转到指定的邮箱登录页面
        $('#goEmail').click(function() {
        	var uurl = $("#yourEmail").html();
        	uurl = gotoEmail(uurl);
            if (uurl != "") {
                window.open("http://" + uurl);
            } else {
            	SweetAlert.warning("十分抱歉!我们没有找到对应的邮箱登录地址，请自行登录邮箱查看验证邮件！");
            }
        });
        
        // 根据用户注册Email跳转到相应的电子邮箱首页
        var gotoEmail = function(mail) {
            mailTail = mail.split('@')[1];
            mailTail = mailTail.toLowerCase();
            if (mailTail == '163.com') {
                return 'mail.163.com';
            } else if (mailTail == 'vip.163.com') {
                return 'vip.163.com';
            } else if (mailTail == '126.com') {
                return 'mail.126.com';
            } else if (mailTail == 'qq.com' || mailTail == 'vip.qq.com' || mailTail == 'foxmail.com') {
                return 'mail.qq.com';
            } else if (mailTail == 'gmail.com') {
                return 'mail.google.com';
            } else if (mailTail == 'sohu.com') {
                return 'mail.sohu.com';
            } else if (mailTail == 'tom.com') {
                return 'mail.tom.com';
            } else if (mailTail == 'vip.sina.com') {
                return 'vip.sina.com';
            } else if (mailTail == 'sina.com.cn' || mailTail == 'sina.com') {
                return 'mail.sina.com.cn';
            } else if (mailTail == 'tom.com') {
                return 'mail.tom.com';
            } else if (mailTail == 'yahoo.com.cn' || mailTail == 'yahoo.cn') {
                return 'mail.cn.yahoo.com';
            } else if (mailTail == 'tom.com') {
                return 'mail.tom.com';
            } else if (mailTail == 'yeah.net') {
                return 'www.yeah.net';
            } else if (mailTail == '21cn.com') {
                return 'mail.21cn.com';
            } else if (mailTail == 'hotmail.com') {
                return 'www.hotmail.com';
            } else if (mailTail == 'sogou.com') {
                return 'mail.sogou.com';
            } else if (mailTail == '188.com') {
                return 'www.188.com';
            } else if (mailTail == '139.com') {
                return 'mail.10086.cn';
            } else if (mailTail == '189.cn') {
                return 'webmail15.189.cn/webmail';
            } else if (mailTail == 'wo.com.cn') {
                return 'mail.wo.com.cn/smsmail';
            } else if (mailTail == 'itcast.cn') {
                return 'mm.263.com';
            } else {
                return '';
            }
        }

        $('.forget-form input').keypress(function(e) {
            if (e.which == 13) {
                if ($('.forget-form').validate().form()) {
                    $('.forget-form').submit();
                }
                return false;
            }
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
//            handleForgetPwd();
            handleForgetPasswordUseMobile();

            // init background slide images
            $('.login-bg').backstretch([
                $("#hdnContextPath").val() + "/static/pages/img/login/1.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/2.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/3.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/4.jpg",
                $("#hdnContextPath").val() + "/static/pages/img/login/5.jpg"
                ], {
                  fade: 1000,
                  duration: 3000
                }
            );

            $('.forget-form').hide();

        }

    };

}();

jQuery(document).ready(function() {
    Login.init();
});