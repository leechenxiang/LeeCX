var Login = function () {

    // 登录Form
    var formLoginValidation = function() {

            var loginForm = $('#loginForm');

            // 表单验证
            loginForm.validate({
                rules: {
                	username: {
                		required: true
                    },
                    password: {
                    	required: true
                    }
                },
                messages: {
                	username: {
                		required: "登录用户名不能为空"
                    },
                    password: {
                		required: "登录密码不能为空"
                    }
                },

                submitHandler: function (form) {
                	
                	var hdnContextPath = $("#hdnContextPath").val();
                	loginForm.ajaxSubmit({
                		dataType: "json",
                        type: "post", // 提交方式 get/post
                        url: hdnContextPath + '/login.shtml', // 需要提交的 url
                        data: loginForm.serialize(),
                        success: function(data) {
                            // 登录成功或者失败的提示信息
	                        if (data.status == 200 && data.msg == "OK") {
	                        	window.location.href = hdnContextPath + "/center.shtml";
	                        } else {
	                        	alert(data.msg);
	                        }
                        }
                    });
//                	return false;
                }
                
            });
            
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	formLoginValidation();
            
        }

    };

}();

jQuery(document).ready(function() {
	Login.init();
});