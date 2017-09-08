var AfterRegist = function() {
	
    var handleRegist = function() {
    	
    }
    
    var redirect = function() {
    	var second = $("#totalSecond").html();
		if (second == 0) {
			location.href = 'https://www.baidu.com';
		} else {
			var s = second - 1;
			$("#totalSecond").html(s);
		}
	}
	
    return {
        //main function to initiate the module
        init: function() {
        	
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
        },
        
        // 3秒自动跳转
        autoOpenIndex: function () {
        	var second = $("#totalSecond").html();
        	if (second == undefined) {
        		return;
        	}

        	setInterval(redirect, 1000);
    	}

    };

}();

jQuery(document).ready(function() {
	AfterRegist.init();
	AfterRegist.autoOpenIndex();
});