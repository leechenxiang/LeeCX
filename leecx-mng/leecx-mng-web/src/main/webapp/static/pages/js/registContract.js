// 注册协议
var RegistContract = function () {
	
	// 初始化summernote
	var handleRegistContract = function() {
		
		$("#content").summernote({
			lang : "zh-CN",
			height: 500,
			callbacks: {  
	            onImageUpload: function(files, editor, $editable) {  
	                sendFile(files);  
	            }  
	        }  
		})
		
		$('#registContractForm').validate({
	    	errorElement: 'span', //default input error message container
	        errorClass: 'help-block', // default input error message class
	        focusInvalid: false, // do not focus the last invalid input
	        ignore: "", // validate all fields including form hidden input
	        rules: {
	        	content: {
	                required: true
	            }
	        },
	        messages: {
	        	content: {
	                required: "请填写协议内容."
	            }
	        },
	        invalidHandler: function(event, validator) { //display error alert on form submit   
	            $('.alert-danger', $('#registContractForm')).show();
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
	        	
	        	$('#registContractForm').ajaxSubmit({
	     			url : $("#hdnContextPath").val() + '/admin/contract/updateRegistContract.shtml',
	     			type : 'POST',
	     			success : function(data) {
	     				// 登录成功或者失败的提示信息
	                    if (data.status == 200 && data.msg == "OK") {
	                    	SweetAlert.success("用户注册协议内容更新成功...");
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
	}
	
	// 上传文件
	function sendFile(files, editor, $editable) { 
		
		var size = files[0].size;
		if((size / 1024 / 1024) > 2) {
			alert("图片大小不能超过2M...");
			return false;
		}
		
        var data = new FormData();  
        data.append("ajaxTaskFile", files[0]);  
        
        var hdnContextPath = $("#hdnContextPath").val();
        
        $.ajax({  
            data : data,  
            type : "POST",  
            url : hdnContextPath + "/file/upload.shtml",	// 图片上传出来的url，返回的是图片上传后的路径，http格式  
            cache : false,  
            contentType : false,  
            processData : false,  
            dataType : "json",  
            success: function(data) {//data是返回的hash,key之类的值，key是定义的文件名  
            
            	$.each(data.data, function (index, file) {
                    $('#content').summernote('insertImage', file.url);  
                }); 
            	
            },  
            error:function(){  
                alert("上传失败");  
            }  
        });  
    }
	
	// 封面上传
    $('#coverUpload').fileupload({
        dataType: 'json',
        done: function (e, data) {
        	console.log(data);  
        	
        	if (data.result.status != "200") {
        		SweetAlert.error(data.result.msg);
        	} else {
                $.each(data.result.data, function (index, file) {
                  $("#coverContent").html("<a href='" + file.url + "' target='_blank'><img src='" + file.url + "' width='500' height='250'></img></a>");
                  $("#cover").attr("value", file.urlDB);
              }); 
        	}
        },
	
		change: function (e, data) {
        	var size = data.files[0].size;
        
    		if((size / 1024 / 1024) > 2) {
				alert("图片大小不能超过2M...");
				return false;
			}
   		}
    });
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleRegistContract();
        	
        }

    };

}();


jQuery(document).ready(function() {
	RegistContract.init();
});