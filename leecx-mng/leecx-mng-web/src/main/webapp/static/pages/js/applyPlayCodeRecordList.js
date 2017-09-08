var ApplyPlayCodeRecordList = function () {
	
    // 意见反馈列表
	var handleApplyPlayCodeRecordList = function() {
    	
		var hdnContextPath = $("#hdnContextPath").val();
		
		var jqGrid = $("#applyCodeRecordJqGridList");  
        jqGrid.jqGrid({  
            caption: "已经申请的播放码记录列表",  
            url: hdnContextPath + "/playCode/userApplyPlayCodeRecordList.shtml",  
            mtype: "post",  
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
            datatype: "json",  
            colNames: ['ID', '课程', '课程名称', '机器码', '申请状态', '播放码', '备注', '创建日期'],  
            colModel: [  
                { name: 'id', index: 'id', width: 10, sortable: false, hidden: true },  
                { name: 'cover', index: 'cover', width: 35, sortable: false,
                	formatter:function(cellvalue, options, rowObject) {
                		
                		var courseCover = "<img src='" + cellvalue + "' width='130' height='80'></img>";
                		
			    		return courseCover;
                	}
                },
                { name: 'title', index: 'title', width: 60, sortable: false },
                { name: 'machineCode', index: 'machineCode', width: 60, sortable: false },
                { name: 'applyStatus', index: 'applyStatus', width: 30, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
			    		return Common.getApplyPlayCodeStatusValue(cellvalue)}
                },
                { name: 'playCode', index: 'playCode', width: 60, sortable: false },
                { name: 'remark', index: 'remark', width: 60, sortable: false },
                {
                	name:"createTime", index:"createTime", width:35, sortable: false,
			    	formatter:function(cellvalue, options, rowObject){
			    		return Common.formatTime(cellvalue,'yyyy-MM-dd HH:mm:ss')}
                }
            ],  
            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
//            multiselect: true,  		// 定义是否可以多选
            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
//            width: 900,
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: "auto",				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#applyCodeRecordJqGridPager",		// 分页控件的id  
            subGrid: false				// 是否启用子表格  
        }).navGrid('#applyCodeRecordJqGridPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.applyCodeRecordJqGrid_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleApplyPlayCodeRecordList();
        	
        }

    };

}();


jQuery(document).ready(function() {
	ApplyPlayCodeRecordList.init();
});