var UserFace = function () {

    // 意见反馈
	var handleUserFace = function() {
		var hdnContextPath = $("#hdnContextPath").val();
		
		var options = {
			thumbBox: '.thumbBox',
			spinner: '.spinner',
			imgSrc: hdnContextPath + '/static/global/plugins/image-cropbox/img/green-arrow.png'
		}
		var cropper = $('.imageBox').cropbox(options);
		$('#upload-file').on('change', function() {
			
			var filepath = $(this).val();
			if(filepath==""){
				return false;
			}
			var extStart = filepath.lastIndexOf(".");
			var ext = filepath.substring(extStart, filepath.length).toUpperCase();
			if(ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
				SweetAlert.error("图片限于png,gif,jpeg,jpg格式...");
				return false;
			} 
			
			if(($("#upload-file").get(0).files[0].size / 1024 / 1024) > 2) {
				SweetAlert.error("图片大小不能超过2M...");
				return false;
			}
			
			var reader = new FileReader();
			reader.onload = function(e) {
				options.imgSrc = e.target.result;
				cropper = $('.imageBox').cropbox(options);
			}
			reader.readAsDataURL(this.files[0]);
//			this.files = [];
		})
		
		$('#btnCrop').on('click', function() {
			var img = cropper.getDataURL();
			$('.cropped').html('');
			$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
			$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
			$('.cropped').append('<img id="faceBig" src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
			$("#userFaceImgStr").val(img);
		})
		$('#btnZoomIn').on('click', function() {
			cropper.zoomIn();
		})
		$('#btnZoomOut').on('click', function() {
			cropper.zoomOut();
		})
		
		$('#uploadDisplay').on('click', function() {
			
			var userFaceImgStr = $("#userFaceImgStr").val();
			var userId = $("#userId").val();
			
			if (userFaceImgStr == "" || userFaceImgStr == null) {
				SweetAlert.error("图片不能为空，请选择图片并且剪裁后上传...");
				return false;
			}
			
			$.ajax({
		    	url: $("#hdnContextPath").val() + "/userInfo/uploadUserFaceImage.shtml",
		    	type: "POST",
		    	async: false,
		    	data: {"userFaceImgStr": userFaceImgStr, "userId": userId},
		    	success: function(data) {
		            if(data.status == 200 && data.msg == "OK") {
		            	SweetAlert.userFaceImageUploadSuccess();
		            } else {
		            	console.log(JSON.stringify(data));
		            }
		    	},
		        error: function (response, ajaxOptions, thrownError) {
		        	Error.displayError(response, ajaxOptions, thrownError);                
		        }
		    });
		})
        
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {
        	
        	handleUserFace();
        }

    };

}();

jQuery(document).ready(function() {
	UserFace.init();
});