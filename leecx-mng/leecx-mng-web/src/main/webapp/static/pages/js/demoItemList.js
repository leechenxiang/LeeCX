// 商品对象
var DemoItemList = function () {
	
    // 商品列表
	var handleDemoItemList = function() {
    	
		var hdnContextPath = $("#hdnContextPath").val();
		
		var jqGrid = $("#jqGridDemoItemList");  
        jqGrid.jqGrid({  
            caption: "商品信息列表",  
            url: hdnContextPath + "/demoItem/getItemInfoList.action",  
            mtype: "post",  
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
            datatype: "json",  
            colNames: ['ID', '商品名', '金额'],  
            colModel: [  
                { name: 'id', index: 'id', width: 60, sortable: false, hidden: true },  
                { name: 'name', index: 'name', width: 30, sortable: false },
                { name: 'amount', index: 'amount', width: 30, sortable: false }
            ],  
            viewrecords: true,  		// 定义是否要显示总记录数
            rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
//            multiselect: true,  		// 定义是否可以多选
            rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
//            width: 900,
            autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
            height: "auto",				// 表格高度，可以是数字，像素值或者百分比
            rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
            pager: "#jqGridDemoItemPager",		// 分页控件的id  
            subGrid: false				// 是否启用子表格
        }).navGrid('#jqGridDemoItemPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.jqGridDemoItemList_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleDemoItemList();
        	
        }

    };

}();


jQuery(document).ready(function() {
	DemoItemList.init();
});