// 保存申请播放码记录
var applyPlayCode = function (purchasedCourseId, title) {
	
	$('#purchasedCourseId').val(purchasedCourseId);
	$('#apc_courseTitle').html(unescape(title));
	
	$('#machineCode').val("");
	$('#remark').val("");
	
	$('#applyPlayCodeModal').modal('toggle');
	
}

var ApplyPlayCode = function () {
	
    // 申请播放码
	var handleApplyPlayCode = function() {
    	
		var hdnContextPath = $("#hdnContextPath").val();
		
		var jqGrid = $("#purchasedCoursesJqGridList");  
        jqGrid.jqGrid({
            caption: "已购买课程列表",  
            url: hdnContextPath + "/playCode/queryPurchasedCourses.shtml",  
            mtype: "post",  
            styleUI: 'Bootstrap',
            datatype: "json",  
            colNames: ['ID', '课程名', '讲师', '课时数', '申请次数', '购买日期', '操作'],  
            colModel: [
                { name: 'id', index: 'id', width: 60, sortable: false, hidden: true },  
                { name: 'title', index: 'title', width: 60, sortable: false },
                { name: 'teacher', index: 'teacher', width: 60, sortable: false },
                { name: 'lessonCounts', index: 'lessonCounts', width: 60, sortable: false },
                { name: 'applyPlaCodeCounts', index: 'applyPlaCodeCounts', width: 60, sortable: false },
                {
                	name:"createTime", index:"createTime", width:35, sortable: false,
			    	formatter:function(cellvalue, options, rowObject){
			    		return Common.formatTime(cellvalue,'yyyy-MM-dd HH:mm:ss')}  
                },
                {
                	width:30, sortable: false,
			    	formatter:function(cellvalue, options, rowObject) {
			    		
			    		var title = escape(rowObject.title);
			    		return '<button class="btn btn-outline blue-chambray" id="" onclick=applyPlayCode("' + rowObject.id + '","' + title + '") style="padding: 1px 3px 1px 3px;">申请播放码</button>';
			    	}
                }
            ],  
            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
//            multiselect: true,  		// 定义是否可以多选
            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
//            width: 900,
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: 450,				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#purchasedCoursesJqGridPager",		// 分页控件的id  
            subGrid: false				// 是否启用子表格  
        }).navGrid('#purchasedCoursesJqGridPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.purchasedCoursesJqGrid_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        
        
        // 用户申请播放码
        $('#applyPlayCodeForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	machineCode: {
                    required: true,
                    rangelength: [8,56]	// 机器码的长度需要控制
                },
                remark: {
                    rangelength: [6,50]
                }
            },

            messages: {
            	machineCode: {
                    required: "机器码不能为空.",
                    rangelength: "输入的机器码过长."
                },
                remark: {
                    rangelength: "备注留言的长度请控制在6-50之间..."
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#applyPlayCodeForm')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-error'));
            },

            submitHandler: function(form) {
            	
            	App.blockUI({
            		target: '#applyPlayCodeModal',
            		overlayColor: 'none',
            		animate: true
            	});
            		
            	var applyPlayCodeForm = $('#applyPlayCodeForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	applyPlayCodeForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/playCode/applyPlayCodeDisplay.shtml',
                    data: applyPlayCodeForm.serialize(),
                    success: function(data) {
                        // 回复意见反馈成功
                        if (data.status == 200 && data.msg == "OK") {
                        	App.unblockUI('#applyPlayCodeModal');
                        	
                        	// 成功后关闭窗口
                        	$('#applyPlayCodeModal').modal('toggle');
                        	
                        	SweetAlert.success("申请播放码成功...");
                        	
                        	jqGrid.trigger("reloadGrid");
                        } else {
                        	App.unblockUI('#applyPlayCodeModal');
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
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleApplyPlayCode();
        	
        }

    };

}();


jQuery(document).ready(function() {
	ApplyPlayCode.init();
});