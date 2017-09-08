// 填充数据到弹出框显示公告详情
var fillData = function(bulletinId) {
	
	$.ajax({
    	url: $("#hdnContextPath").val() + "/bulletin/queryBulletinById.shtml",	//?feedbackId=" + feedbackId + "&userId=" + userId
    	type: "POST",
    	async: false,
    	data: {"bulletinId": bulletinId},
    	success: function(data) {
            if(data.status == 200 && data.msg == "OK") {
            	var bulletinDetail = data.data; 
            	var title = bulletinDetail.title;
            	var content = bulletinDetail.content;
            	
            	$("#blt_title").html(title);
            	$("#blt_content").html(content);
            	
            	$('#userBulletinDetailModal').modal('toggle');
            } else {
            	console.log(JSON.stringify(data));
            }
    	},
        error: function (response, ajaxOptions, thrownError) {
        	Error.displayError(response, ajaxOptions, thrownError);                
        }
    });
	
};

var UserBulletinList = function () {
	
    // 公告列表
	var handleUserBulletinList = function() {
    	
		var hdnContextPath = $("#hdnContextPath").val();
		
		var jqGrid = $("#jqGridUserBulletinList");  
        jqGrid.jqGrid({  
        	caption: "<b>系统公告</b>", 
            url: hdnContextPath + "/bulletin/queryUserBulletinListList.shtml",  
            mtype: "post",  
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
            datatype: "json",  
            colNames: ['ID', '标题', '创建日期'],  
            colModel: [  
                { name: 'id', index: 'id', width: 60, sortable: false, hidden: true },  
                { name: 'title', index: 'title', width: 60, sortable: false,
                	formatter:function(cellvalue, options, rowObject) {
			    		
			    		var btnDetail = '<a href="javascript:void(0)" onclick=fillData("' + rowObject.id + '")>' + rowObject.title + '</button>';
			    		
			    		return btnDetail}
                },
                {
                	name:"createTime", index:"createTime", width:30, sortable: false, align: "right",
			    	formatter:function(cellvalue, options, rowObject){
			    		return Common.formatTime(cellvalue,'yyyy-MM-dd HH:mm:ss') + "&nbsp;&nbsp;&nbsp;&nbsp;"}  
                }
//                ,
//                {
//                	width:25, sortable: false,
//			    	formatter:function(cellvalue, options, rowObject) {
//			    		
//			    		var btnDetail = '<button class="btn btn-outline blue-chambray" id="" onclick=fillData("' + rowObject.id + '") style="padding: 1px 3px 1px 3px;">查看</button>';
//			    		
//			    		return btnDetail}
//                }
            ],  
//            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
//            multiselect: true,  		// 定义是否可以多选
//            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
//            width: 900,
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: 400,				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#jqGridUserBulletinPager",		// 分页控件的id  
            subGrid: false,				// 是否启用子表格  
            gridComplete: function () {
            	$(this).closest('.ui-jqgrid-view').find('div.ui-jqgrid-hdiv').remove()
            }
        }).navGrid('#jqGridUserBulletinPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.jqGridUserBulletin_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleUserBulletinList();
        	
        }

    };

}();

jQuery(document).ready(function() {
	UserBulletinList.init();
});