// 填充数据到弹出框显示课程信息
var fillAdminCourseModal = function(courseId) {
	
	$.ajax({
    	url: $("#hdnContextPath").val() + "/admin/courseLesson/queryAdminCourseDetail.shtml",
    	type: "POST",
    	async: false,
    	data: {"courseId": courseId},
    	success: function(data) {
            if(data.status == 200 && data.msg == "OK") {
            	var courseDetail = data.data;
            	
            	$("#acd_title").html(courseDetail.title);
            	$("#acd_oldPrice").html(Common.fenToYuan(courseDetail.oldPrice) + "元");
            	$("#acd_newPrice").html(Common.fenToYuan(courseDetail.newPrice) + "元");
            	$("#acd_cover").attr('src', courseDetail.coverImage); 
            	
            	$("#acd_categoryTags").html(Common.getCourseTagsWithStyle(courseDetail.categoryTags));
            	$("#acd_isFree").html(Common.getCourseIsFreeWithStyle(courseDetail.isFree));
            	
            	$("#acd_difficulty").html(Common.getCourseDifficultyValueWithStyle(courseDetail.difficulty));
            	$("#acd_lessonCounts").html(courseDetail.lessonCounts);
            	$("#acd_buyerCounts").html(courseDetail.buyerCounts);
            	$("#acd_isEnd").html(Common.getCourseIsEndWithStyle(courseDetail.isEnd));
            	$("#acd_isOnsale").html(Common.getCourseIsOnSaleWithStyle(courseDetail.isOnsale));
            	$("#acd_isHot").html(Common.getCourseIsHotWithStyle(courseDetail.isHot));
            	$("#acd_isExclusive").html(Common.getCourseIsExclusiveWithStyle(courseDetail.isExclusive));
            	$("#acd_introduction").html(courseDetail.introduction);
            	$("#acd_description").html(courseDetail.description);
            	
            	$('#adminCourseDetailModal').modal('toggle');
            } else {
            	console.log(JSON.stringify(data));
            }
    	},
        error: function (response, ajaxOptions, thrownError) {
        	Error.displayError(response, ajaxOptions, thrownError);                
        }
    });
};

// 展示讲师课时列表，管理员可对其进行增删改操作
var openLecturerLessonListModal = function(courseId) {
	
	restAdminLessonListForm();
	
	$("#courseId").val(courseId);
	
	$('#adminLessonListModal').modal('toggle');
	
	initLessonsOfCourseList(courseId);
	reloadLessonGrid(courseId);
	
};

// 重置form
var restAdminLessonListForm = function() {
	$('#adminLessonListForm')[0].reset();
	$("input[name=isFree][value=0]").iCheck('check');
	$("#lessonId").val("");
}

//渲染bootstrap switch
function renderSwitch() {
	$('input[name="isHotSwitch"]').bootstrapSwitch(); 
	$('input[name="isHotSwitch"]').on('switchChange.bootstrapSwitch', function(event, state) {  
//		console.log(this); // DOM element  
//		console.log(event); // jQuery event  
//		console.log(state); // true | false
		
		var thisSwitchId = this.id;
		var courseId = thisSwitchId.split("isHotSwitch_")[1];
		
		$.ajax({
	    	url: $("#hdnContextPath").val() + "/admin/courseLesson/setCourseHot.shtml",
	    	type: "POST",
	    	async: false,
	    	data: {"courseId": courseId, "isHot": state ? 1 : 0},
	    	success: function(data) {
	            if(data.status != 200) {
	            	SweetAlert.warning(data.msg);
	            	$("#" + thisSwitchId).bootstrapSwitch('state', false);
//	            	$("#" + thisSwitchId).bootstrapSwitch('toggleState');
	            }
	    	},
	        error: function (response, ajaxOptions, thrownError) {
	        	Error.displayError(response, ajaxOptions, thrownError);                
	        }
	    });
		
	}); 
	
	
	$('input[name="isExclusiveSwitch"]').bootstrapSwitch(); 
	$('input[name="isExclusiveSwitch"]').on('switchChange.bootstrapSwitch', function(event, state) {  
		
		var thisSwitchId = this.id;
		var courseId = thisSwitchId.split("isExclusiveSwitch_")[1];
		
		$.ajax({
	    	url: $("#hdnContextPath").val() + "/admin/courseLesson/setCourseExclusiveSwitch.shtml",
	    	type: "POST",
	    	async: false,
	    	data: {"courseId": courseId, "isExclusive": state ? 1 : 0},
	    	success: function(data) {
	            if(data.status != 200) {
	            	SweetAlert.warning(data.msg);
	            	$("#" + thisSwitchId).bootstrapSwitch('state', false);
//	            	$("#" + thisSwitchId).bootstrapSwitch('toggleState');
	            }
	    	},
	        error: function (response, ajaxOptions, thrownError) {
	        	Error.displayError(response, ajaxOptions, thrownError);                
	        }
	    });
		
	});
	
	$('input[name="isOnSaleSwitch"]').bootstrapSwitch(); 
	$('input[name="isOnSaleSwitch"]').on('switchChange.bootstrapSwitch', function(event, state) {
		var thisSwitchId = this.id;
		var courseId = thisSwitchId.split("isOnSaleSwitch_")[1];
		
		$.ajax({
	    	url: $("#hdnContextPath").val() + "/admin/courseLesson/setCourseOnSale.shtml",
	    	type: "POST",
	    	async: false,
	    	data: {"courseId": courseId, "isOnSale": state ? 1 : 0},
	    	success: function(data) {
	            if(data.status != 200) {
	            	SweetAlert.warning(data.msg);
	            	$("#" + thisSwitchId).bootstrapSwitch('state', false);
	            }
	    	},
	        error: function (response, ajaxOptions, thrownError) {
	        	Error.displayError(response, ajaxOptions, thrownError);                
	        }
	    });
	}); 
	
    return(true);  
}

// 所有课程列表对象
var AllCourseList = function () {
	
    // 我的课程列表
	var handleAllCourseList = function() {
    	
		var hdnContextPath = $("#hdnContextPath").val();
		
		var jqGrid = $("#jqGridAllCourseList");  
        jqGrid.jqGrid({  
            caption: "所有课程列表",  
            url: hdnContextPath + "/admin/courseLesson/queryAllCourseList.shtml",  
            mtype: "post",  
            styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
            datatype: "json",  
            colNames: ['ID', '标题', '讲师', '价格(元)', '难度', '课时数', '是否免费', '购买人数', '是否热销', '是否独家', '完结状态', '仓库状态', '创建日期', '操作'],  //'是否删除', 
            colModel: [  
                { name: 'id', index: 'id', width: 60, sortable: false, hidden: true },
                { name: 'title', index: 'title', width: 80, sortable: false },
                { name: 'teacher', index: 'teacher', width: 25, sortable: false },
                { name: 'newPrice', index: 'newPrice', width: 20, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
			    		return Common.fenToYuan(cellvalue)}  
                },
                { name: 'difficulty', index: 'difficulty', width: 20, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
			    		return Common.getCourseDifficultyValueWithStyle(cellvalue)}
                },
                { name: 'lessonCounts', index: 'lessonCounts', width: 20, sortable: false },
//                { name: 'categoryTags', index: 'categoryTags', width: 50, sortable: false,
//                	formatter:function(cellvalue, options, rowObject) {
//			    		return Common.getCourseTagsWithStyle(cellvalue); }  
//                },
                { name: 'isFree', index: 'isFree', width: 20, sortable: false,
                	formatter:function(cellvalue, options, rowObject) {
			    		return Common.getCourseIsFreeWithStyle(cellvalue); }  
                },
                { name: 'buyerCounts', index: 'buyerCounts', width: 20, sortable: false },
                { name: 'isHot', index: 'isHot', width: 30, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
                		
                		var check = "";
                		if (cellvalue == 1) {
                			check = "checked"; 
                		}
                		
                		var switchBtn = '<input type="checkbox" ' + check + ' " class="make-switch" id=isHotSwitch_' + rowObject.id + ' name="isHotSwitch" data-size="mini" data-on-text="&nbsp;热销&nbsp;" data-off-text="&nbsp;一般&nbsp;" data-on-color="danger" data-off-color="success">';
                		
			    		return switchBtn}
                },
                { name: 'isExclusive', index: 'isExclusive', width: 30, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
                		
                		var check = "";
                		if (cellvalue == 1) {
                			check = "checked"; 
                		}
                		
                		var switchBtn = '<input type="checkbox" ' + check + ' " class="make-switch" id=isExclusiveSwitch_' + rowObject.id + ' name="isExclusiveSwitch" data-size="mini" data-on-text="&nbsp;独家&nbsp;" data-off-text="&nbsp;非独家&nbsp;" data-on-color="danger" data-off-color="success">';
                		
			    		return switchBtn}
                },
                { name: 'isEnd', index: 'isEnd', width: 25, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
                		
                		return Common.getCourseIsEndWithStyle(cellvalue);
                	}
                },
                { name: 'isOnsale', index: 'isOnsale', width: 25, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
                		
                		var check = "";
                		if (cellvalue == 1) {
                			check = "checked"; 
                		}
                		
                		var switchBtn = '<input type="checkbox" ' + check + ' " class="make-switch" id=isOnSaleSwitch_' + rowObject.id + ' name="isOnSaleSwitch" data-size="mini" data-on-text="&nbsp;上架&nbsp;" data-off-text="&nbsp;下架&nbsp;" data-on-color="info" data-off-color="warning">';
                		
			    		return switchBtn}
                },
                /*{ name: 'isDelete', index: 'isDelete', width: 25, sortable: false,
                	formatter:function(cellvalue, options, rowObject){
                		
                		var isDeleteHtml = "";
                		if (cellvalue == 1) {
                			isDeleteHtml = '<span class="bg-grey-cascade bg-font-grey-cascade" style="padding: 5px; ">已删除</span>';
                    	} else if (cellvalue == 0) {
                    		isDeleteHtml = '<span class="bg-purple-studio bg-font-purple-studio" style="padding: 5px; ">未删除</span>';
                    	} 
                		
			    		return isDeleteHtml}
                },*/
                {
                	name:"createTime", index:"createTime", width:35, sortable: false,
			    	formatter:function(cellvalue, options, rowObject){
			    		return Common.formatTime(cellvalue,'yyyy-MM-dd HH:mm:ss')}  
                },
                {
                	width:50, sortable: false,
			    	formatter:function(cellvalue, options, rowObject) {
			    	
			    	var btnAdminCourseDetail ='<button class="btn btn-outline blue-chambray" id="" onclick=fillAdminCourseModal("' + rowObject.id + '") style="padding: 1px 3px 1px 3px;">查看详情</button>';
			    	
			    	var btnAdminLessonDetail ='<button class="btn btn-outline blue-chambray" id="" onclick=openLecturerLessonListModal("' + rowObject.id + '") style="padding: 1px 3px 1px 3px;">上传课时</button>';
			    	
			    	return btnAdminCourseDetail + "&nbsp;&nbsp;" + btnAdminLessonDetail} 
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
            pager: "#jqGridAllCourseListPager",		// 分页控件的id  
            subGrid: false,				// 是否启用子表格
            gridComplete: renderSwitch	// grid加载完毕后重新渲染switch
        }).navGrid('#jqGridAllCourseListPager', {
            edit: false,
            add: false,
            del: false,
            search: false
        });
        
  
        // 随着窗口的变化，设置jqgrid的宽度  
        $(window).bind('resize', function () {  
            var width = $('.jqGridAllCourseList_wrapper').width()*0.99;  
            jqGrid.setGridWidth(width);  
        });  
        
        // 不显示水平滚动条
        jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
    }
	
	// 保存课时
	var handleSaveLessonList = function() {
    	
		$('#adminLessonListForm').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "", // validate all fields including form hidden input
            rules: {
            	title: {
                    required: true,
                    rangelength: [6,50]
                },
                isFree: {
                    required: true
                },
                time: {
                    required: true,
                    rangelength: [3,8]
                },
                videoCloudUrl: {
                	url: true,
                    rangelength: [6,128]
                },
                baiduPanUrl: {
                    required: true,
                    url: true,
                    rangelength: [6,128]
                },
                baiduPanPwd: {
                    required: true,
                    rangelength: [4,4]
                },
                dataPanUrl: {
                    url: true,
                },
                dataPanPwd: {
                    rangelength: [4,4]
                }
            },

            messages: {
            	title: {
                    required: "标题不能为空.",
                    rangelength: "标题的长度请控制在6-50位."
                },
                isFree: {
                    required: "是否免费不能为空."
                },
                time: {
                    required: "课时时长不能为空.",
                    rangelength: "长度请控制在3-8位."
                },
                videoCloudUrl: {
                	url: "url地址不合法, 请加上 'http://' 或者 'https://'",
                    rangelength: "长度请控制在6-128位."
                },
                baiduPanUrl: {
                    required: "百度云url不能为空.",
                    url: "url地址不合法, 请加上 'http://' 或者 'https://'",
                    rangelength: "长度请控制在6-128位."
                },
                baiduPanPwd: {
                    required: "百度云密码不能为空.",
                    rangelength: "请输入4位百度云分享链接的密码"
                },
                dataPanUrl: {
                	url: "url地址不合法, 请加上 'http://' 或者 'https://'",
                },
                dataPanPwd: {
                    rangelength: "请输入4位百度云分享链接的密码"
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('#adminLessonListForm')).show();
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
            	App.blockUI();
            
            	var adminLessonListForm = $('#adminLessonListForm');
            	var hdnContextPath = $("#hdnContextPath").val();
            	adminLessonListForm.ajaxSubmit({
            		dataType: "json",
                    type: "post", // 提交方式 get/post
                    url: hdnContextPath + '/admin/courseLesson/saveLesson.shtml', // 需要提交的 url
                    data: adminLessonListForm.serialize(),
                    success: function(data) {
                        // 登录成功或者失败的提示信息
                        if (data.status == 200 && data.msg == "OK") {
                        	SweetAlert.success("视频信息提交成功！");
                        	
                        	restAdminLessonListForm();
                        	
                        	var courseId = $("#courseId").val();
                        	reloadLessonGrid(courseId);
                        	App.unblockUI();
                        } else {
                        	SweetAlert.error(data.msg);
                        	App.unblockUI();
                        }
                    },
	                error: function (response, ajaxOptions, thrownError) {
	                	Error.displayError(response, ajaxOptions, thrownError); 
	                	App.unblockUI();
	                }
                });
            	
//                form.submit(); // form validation success, call ajax form submit
            }
        });
		
		// 按钮重置from
		$("#btnResetAdminLessonList").click(function(){
			restAdminLessonListForm();
    	})
    }
	
    return {
        // 初始化各个函数及对象
        init: function () {

        	handleAllCourseList();
        	handleSaveLessonList();
//        	handleLessonsOfCourseList();
        	
        }

    };

}();

// 更新lesson，填充fileds
var fillModifyFormFileds = function (lessonId, title, isFree, time, videoCloudUrl, baiduPanUrl, baiduPanPwd, dataPanUrl, dataPanPwd) {
	$("#lessonId").val(lessonId);
	$("#title").val(unescape(title));
	$("input[name=isFree][value=" + isFree + "]").iCheck('check');
	$("#time").val(time);
	$("#videoCloudUrl").val(videoCloudUrl);
	$("#baiduPanUrl").val(baiduPanUrl);
	$("#baiduPanPwd").val(baiduPanPwd);
	$("#dataPanUrl").val(dataPanUrl);
	$("#dataPanPwd").val(dataPanPwd);
}

// 删除课时
var deleteLesson = function (lessonId, courseId) {
	
	swal({
		  title: "提醒",
		  text: "确认删除本课时吗?",
		  type: "warning",
		  confirmButtonText: "确认删除!",
		  confirmButtonClass: "btn-warning",
		  showCancelButton: true,
		  cancelButtonText: "噢!等等...",
		  confirmButtonColor: "#DD6B55",  
		  closeOnConfirm: false
  	}, function(isConfirm) {
			if (isConfirm) {
				App.blockUI();
				
				$.ajax({
			    	url: $("#hdnContextPath").val() + "/admin/courseLesson/deleteLessonById.shtml?lessonId=" + lessonId,
			    	type: "POST",
			    	async: false,
			    	success: function(data) {
			            if(data.status == 200 && data.msg == "OK") {
			            	App.unblockUI();
			            	SweetAlert.success("删除成功");
			            	reloadLessonGrid(courseId);
			            } else {
			            	App.unblockUI();
			            	SweetAlert.success(data.msg);
			            	console.log(JSON.stringify(data));
			            }
			    	},
			        error: function (response, ajaxOptions, thrownError) {
			        	App.unblockUI();
			        	Error.displayError(response, ajaxOptions, thrownError);                
			        }
			    });
			}
		});
}

// 课时列表显示
var initLessonsOfCourseList = function(courseId) {
	
	var hdnContextPath = $("#hdnContextPath").val();
//	var courseId = $("#courseId").val();
	
	//********************  初始化jqgrid 开始  **********************//
	var jqGrid = $("#jqGridLessonsOfCourseList");  
    jqGrid.jqGrid({  
        caption: "所有课时列表",  
        url: hdnContextPath + "/admin/courseLesson/queryLessonsOfCourseList.shtml?courseId=" + courseId,  
        mtype: "post",  
        styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式  
        datatype: "local",  
        colNames: ['ID', '课时名称', '密码', '是否免费', '课时时长', '创建日期', '操作'],  
        colModel: [  
            { name: 'id', index: 'id', width: 60, sortable: false, hidden: true },  
            { 
            	name: 'title', index: 'title', width: 80, sortable: false,
		    	formatter:function(cellvalue, options, rowObject){
            		return '<a href=javascript:void(0); target=_blank onclick=Common.openUrl("' + rowObject.baiduPanUrl + '")>' + cellvalue + '</a>'}
//		    		return "<a href='" + rowObject.baiduPanUrl + "' target='_blank'>" + cellvalue + "</a>"}  
            },
            {name:"baiduPanPwd", index:"baiduPanPwd", width:10, sortable: false},
            {
            	name:"isFree", index:"isFree", width:15, sortable: false,
		    	formatter:function(cellvalue, options, rowObject){
		    		return Common.getLessonIsFreeWithStyle(cellvalue)}  
            },
            {name:"time", index:"time", width:10, sortable: false},
            {
            	name:"createTime", index:"createTime", width:25, sortable: false,
		    	formatter:function(cellvalue, options, rowObject){
		    		return Common.formatTime(cellvalue,'yyyy-MM-dd HH:mm:ss')}  
            },
            {
            	width:25, sortable: false,
		    	formatter:function(cellvalue, options, rowObject) {
		    	
		    	var title = escape(rowObject.title);
		    	var btnModify ='<button class="btn btn-outline blue-chambray" id="" onclick=fillModifyFormFileds("' + rowObject.id + '","' + title + '","' + rowObject.isFree + '","' + rowObject.time + '","' + rowObject.videoCloudUrl + '","' + rowObject.baiduPanUrl + '","' + rowObject.baiduPanPwd + '","' + rowObject.dataPanUrl + '","' + rowObject.dataPanPwd + '") style="padding: 1px 3px 1px 3px;">编  辑</button>';
		    	
		    	var btnDelete ='<button class="btn btn-outline blue-chambray" id="" onclick=deleteLesson("' + rowObject.id + '","' + rowObject.courseId + '") style="padding: 1px 3px 1px 3px;">删  除</button>';
		    	
		    	return btnModify + "&nbsp;&nbsp;" + btnDelete} 
            }
        ],  
        viewrecords: true,  		// 定义是否要显示总记录数
        rowNum: 10,					// 在grid上显示记录条数，这个参数是要被传递到后台
//        multiselect: true,  		// 定义是否可以多选
        rownumbers: true,  			// 如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
//        width: 1138,
        autowidth: true,  			// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
        height: 420,				// 表格高度，可以是数字，像素值或者百分比
        rownumWidth: 36, 			// 如果rownumbers为true，则可以设置行号 的宽度
        pager: "#jqGridLessonsOfCourseListPager",		// 分页控件的id  
        subGrid: false				// 是否启用子表格  
    }).navGrid('#jqGridLessonsOfCourseListPager', {
        edit: false,
        add: false,
        del: false,
        search: false
    });
    

    var width = $('.modal.container').width()*0.975;
    jqGrid.setGridWidth(width);
    
    // 随着窗口的变化，设置jqgrid的宽度  
    $(window).bind('resize', function () {  
//        var width = $('.jqGridLessonsOfCourseList_wrapper').width()*0.99;
    	var width = $('.modal.container').width()*0.975;
        jqGrid.setGridWidth(width);  
    });  
    
    // 不显示水平滚动条
    jqGrid.closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
	//********************  初始化jqgrid 结束  **********************//
    
}

// 重新刷新grid
function reloadLessonGrid(courseId) {
	var jqGrid = $("#jqGridLessonsOfCourseList");  
	var hdnContextPath = $("#hdnContextPath").val();
	jqGrid.jqGrid('setGridParam',{datatype:'json'}).setGridParam({ 
		page: 1,
        url: hdnContextPath + "/admin/courseLesson/queryLessonsOfCourseList.shtml?courseId=" + courseId,
    }).trigger("reloadGrid");
}


jQuery(document).ready(function() {
	AllCourseList.init();
});