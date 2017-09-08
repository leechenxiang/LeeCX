var DataDict = function () {

    // 数据字典Form
    var formDataDictValidation = function() {
        // for more info visit the official plugin documentation: 
        // http://docs.jquery.com/Plugins/Validation

            var formDataDict = $('#form_data_dict');
            var errorDataDict = $('.alert-danger', formDataDict);
            var successDataDict = $('.alert-success', formDataDict);

            //IMPORTANT: update CKEDITOR textarea with actual content before submit
//            formDataDict.on('submit', function() {
//                for(var instanceName in CKEDITOR.instances) {
//                    CKEDITOR.instances[instanceName].updateElement();
//                }
//            })

            // 自定义验证，文本框中的数据字典类型是否已经存在，如果存在则提示下拉框中的即可
            jQuery.validator.addMethod("isTypeNameExist", function(value, element) {    
            	var typeName = $("#typeName").val();
            	var flag = true;
                $.ajax({
                	url: $("#hdnContextPath").val() + "/dataDict/isTypeNameExist.shtml",
                	type: "POST",
                	async: false,
                	data: {"typeName": typeName},
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
            	
            	return flag;
            }, "类型名称已存在，请选择下拉框中的数据字典类型"); 
            
            // 添加自定义验证，下拉框和文本框中只要有一个即可，如果都存在，则以下拉框为主
            jQuery.validator.addMethod("typeNameRequired", function(value, element) {    
            	var typeNameList = $("#typeNameList").val();
            	var typeName = $("#typeName").val();
            	
            	return ( typeNameList != "" || typeName != "");
            }, "请确保数据字典类型下拉框或者文本框必须有一个不为空"); 
            
            
            // 自定义验证 typeCode 在下拉框有值的时候可以为空，在下拉框无值得时候必填
            jQuery.validator.addMethod("typeCodeRequired", function(value, element) {
            	var typeNameList = $("#typeNameList").val();
            	var typeCode = $("#typeCode").val();
            	
            	return ( typeNameList != "" || typeCode != "");
            }, "数据字典类型列表下拉框为空时，类型代码必填"); 
            
            // 自定义验证，文本框中的数据字典code是否已经存在，如果存在则提示下拉框中的即可
            jQuery.validator.addMethod("isTypeCodeExist", function(value, element) {    
            	var typeCode = $("#typeCode").val();
            	var flag = true;
                $.ajax({
                	url: $("#hdnContextPath").val() + "/dataDict/isTypeCodeExist.shtml",
                	type: "POST",
                	async: false,
                	data: {"typeCode": typeCode},
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
            	
            	return flag;
            }, "类型代码已存在，请选择下拉框中的数据字典类型即可"); 
            
            
            // 表单验证
            formDataDict.validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block help-block-error', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "", // validate all fields including form hidden input
                rules: {
                	typeName: {
                		rangelength: [2,20],
                		typeNameRequired: true,
                		isTypeNameExist: true
                    },
                    typeNameList: {
                    	typeNameRequired: true
                    },
                    typeCode: {
                    	rangelength: [2,20],
                    	typeCodeRequired: true,
                    	isTypeCodeExist: true
                    }
                },
                messages: {
                	typeName: {
                		rangelength: "数据字典类型名称长度必须介于 2 和 20 之间"
                    },
                    typeCode: {
                    	rangelength: "数据字典类型代码长度必须介于 2 和 20 之间"
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit   
                    successDataDict.hide();
                    errorDataDict.show();
                    App.scrollTo(errorDataDict, -200);
                },

                highlight: function (element) { // hightlight error inputs
                   $(element)
                        .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                unhighlight: function (element) { // revert the change done by hightlight
                    $(element)
                        .closest('.form-group').removeClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label
                        .closest('.form-group').removeClass('has-error'); // set success class to the control group
                },

                submitHandler: function (form) {
                    successDataDict.show();
                    errorDataDict.hide();
//                    form[0].submit(); // submit the form
                }

            });
            
    }
    
    // 初始化下拉框中的数据字典分类
    var initDataDictTypes = function(oldDDTypeName) {
    	
    	App.blockUI();

    	var hdnContextPath = $("#hdnContextPath").val();
//    	var formDataDict = $('#form_data_dict');
    	
    	$.ajax({
			url : hdnContextPath + "/dataDict/queryDataDictTypeNames.shtml",
			dataType : 'json',
			type : "POST",
			cache : false,
			success : function(data) {
			
				if (data.status == 200 && data.msg == "OK") {
					var typeNames = data.data;
					var options = "<option value=''>==请选择==</option>";
					for (var i = 0 ; i < typeNames.length ; i ++) {
						options += "<option value='" + typeNames[i].typeName + "'>" + typeNames[i].typeName + "</option>";
					}
					$('#typeNameList').html(options);
					
					if (oldDDTypeName != '' && oldDDTypeName != null ) {
						$("#typeNameList").val(oldDDTypeName);
//						$("#typeName").val("");
					}
					
					App.unblockUI();
				} else {
					console.log(JSON.stringify(data));
					App.unblockUI();
				}
			
			},
            error: function (response, ajaxOptions, thrownError) {
            	Error.displayError(response, ajaxOptions, thrownError);                
            	App.unblockUI();
            }
		});
    	
    }
    
    // 根据数据字典名称下拉框中的值，来动态显示table中的内容
    var initDataDictListInTable = function() {
    	
    	$("#typeNameList").change(function(){
    		refreshByDataDictName();
    	})
    	
    }
    
    // 动态展示数据字典到tablelist中
    var refreshByDataDictName = function() {
    	App.blockUI();
    	
    	var typeName = $("#typeNameList").val();
    	if(typeName == "" || typeName == null) {
    		$("#dataDictTbl tbody").html("");
    		setDDNameAndCode(null);
    		App.unblockUI();
    		return;
    	} 
		
    	$.ajax({
			url : $("#hdnContextPath").val() + "/dataDict/queryDataDictByTypeName.shtml?",
			dataType : 'json',
			type : "POST",
			cache : false,
			data: {"typeName": typeName},
			success : function(data) {
			
				if (data.status == 200 && data.msg == "OK") {
					$("#dataDictTbl tbody").html("");
					var dataDictList = data.data;
					
					// 如果dataDictList没有数据，则重新刷新下拉框
					if (dataDictList.length > 0) {
						for (var i = 0 ; i < dataDictList.length ; i ++ ) {
							renderTableList(i, dataDictList[i].id, dataDictList[i].ddkey, dataDictList[i].ddvalue);
						}
						setDDNameAndCode(dataDictList[0]);
					} else {
						initDataDictTypes(null);
						setDDNameAndCode(null);
					}
					
					App.unblockUI();
					
					// 验证无错后，移除错误class
					var formDataDict = $('#form_data_dict');
					if (formDataDict.valid()) {
						goodBoyNoError(formDataDict);
					}
				} else {
					console.log(JSON.stringify(data));
					App.unblockUI();
				}
			
			},
            error: function (response, ajaxOptions, thrownError) {
            	Error.displayError(response, ajaxOptions, thrownError);
            	App.unblockUI();
            }
		});
    }
    
    
    // 设置typeName和typeCode的值
    var setDDNameAndCode = function(data) {
    	if (data != null) {
    		$("#typeName").val(data.typeName);
        	$("#typeCode").val(data.typeCode);
        	
        	$("#typeName").attr("disabled","disabled");
        	$("#typeCode").attr("disabled","disabled");
    	} else {
    		$("#typeName").val("");
        	$("#typeCode").val("");
        	
        	$("#typeName").removeAttr("disabled");
        	$("#typeCode").removeAttr("disabled");
    	}
    }
    
    // 获得数据字典名称，以下拉框为主，如果下拉框和文本框都不为空，那么选择下拉框的值
    var getDataTypeName = function() {
    	var typeName = $("#typeName").val();
    	var typeNameList = $("#typeNameList").val();
    	
    	if (typeNameList != '' && typeNameList != null ) {
    		return typeNameList;
    	}
    	
    	return typeName;
    }
    
    // 数据字典下拉框，以及typeName，typeCode，验证正确后，移除错误的class
    var goodBoyNoError = function(formDataDict) {
    	// 验证成功则显示正确信息
		var errorDataDict = $('.alert-danger', formDataDict);
        var successDataDict = $('.alert-success', formDataDict);
        // 移除错误的class
        successDataDict.show();
        errorDataDict.hide();
        $("#typeName").closest('.form-group').removeClass('has-error');
        $("#typeCode").closest('.form-group').removeClass('has-error');
    }
    
    // 展示数据字典内容到table中
    var renderTableList = function(rowNumber, dataDictId, key, value) {
    		var keyIdOrName = "data_dict_key_" + rowNumber;
    		var valueIdOrName = "data_dict_value_" + rowNumber;
    		var submitId = "data_dict_submit_" + rowNumber;
    		var deleteId = "data_dict_delete_" + rowNumber;
    		var hdnDataDictIdOrName = "dataDictId_" + rowNumber;
    		var formRowIdOrName = "dataDictForm" + rowNumber; 
    		var tb_rowIdOrName = "tb_row_data_dict_" + rowNumber;
    		
    		var userHasPerms_appuser_check = $("#userHasPerms_appuser_check").val();
    		
    		var row = 	"<tr id='" + tb_rowIdOrName + "'>" +
    						"<form id='" + formRowIdOrName + "' action=''>" +
    							"<input type='hidden' id='" + hdnDataDictIdOrName + "' name='" + hdnDataDictIdOrName + "' value='" + dataDictId + "'/>" +
    							
					            "<td> <input type='text' id='" + keyIdOrName + "' name='" + keyIdOrName + "' class='form-control input-small' value='" + key + "'> </td>" +
					            "<td> <input type='text' id='" + valueIdOrName + "' name='" + valueIdOrName + "' class='form-control input-small' value='" + value + "'> </td>" +
					            
					            
					            
					            "<td>";

    		if (userHasPerms_appuser_check == 1) {
    			row +=				"<button type='button' id='" + submitId + "' class='btn blue btn-sm' > 提 交 </button>&nbsp;&nbsp;&nbsp;&nbsp;";
    		} else {
    			row += "&nbsp;";
    		}
    		
    		if (userHasPerms_appuser_check == 1) {
    			row +=				"<button type='button' id='" + deleteId + "' class='btn red btn-sm'> 删 除 </button>&nbsp;&nbsp;&nbsp;&nbsp;";
    		} else {
    			row += "&nbsp;";
    		}
    			row +=			"</td>" +
					        "</form>" +
				        "</tr>";
    			
//    		'" + keyIdOrName + "','" + valueIdOrName + "','" + tb_rowIdOrName + "','" + hdnDataDictIdOrName + "'
    		$("#dataDictTbl tbody").append(row);
    		
    		// 动态绑定事件， 提交每行数据前先提交数据字典类型名称form，即：验证
//    		$("#dataDictTbl").on("click", "#" + submitId, function(){
    		$("#" + submitId).bind('click',function(){
    			
    			var formDataDict = $('#form_data_dict');
    			
    			// 如果form验证通过，则提交单行
    			if (formDataDict.valid()) {
    				// 验证无错后，移除错误class
    				goodBoyNoError(formDataDict);
    	            
                    var rowKey = $("#" + keyIdOrName).val();
                    var rowValue = $("#" + valueIdOrName).val();
                    
                    // 判断单行form中数据是否存在，存在提示错误
                    if (rowKey != null && rowKey != "" && rowValue != null && rowValue != "") {
                    	if (rowKey.length > 10 || rowKey.length < 1) {
                        	SweetAlert.error("数据字典Key长度应在1到10之间.");
                        	$("#" + tb_rowIdOrName).attr("bgcolor", "#fbe1e3");
                        	return;
                        }
                        
                        if (rowValue.length > 10 || rowValue.length < 1) {
                        	SweetAlert.error("数据字典Value长度应在1到10之间.");
                        	$("#" + tb_rowIdOrName).attr("bgcolor", "#fbe1e3");
                        	return;
                        }
                        
                        $("#" + tb_rowIdOrName).attr("bgcolor", "");
                        
                        var dataTypeName = getDataTypeName();
                        var dataDictTypeCode = $("#typeCode").val();
                        var dataDictId = $("#" + hdnDataDictIdOrName).val();
                        
                        App.blockUI();
                    	// 验证单行数据是否存在
                    	$.ajax({
                        	url: $("#hdnContextPath").val() + "/dataDict/saveOrUpdateDataDict.shtml",
                        	type: "POST",
                        	async: false,
                        	data: {
                        			"dataDictId": dataDictId,
                        			"dataDictTypeName": dataTypeName,
                        			"dataDictTypeCode": dataDictTypeCode,
                        			"dataDictKey": rowKey,
                        			"dataDictValue": rowValue
                        		  },
                        	success: function(data) {
        	                    if(data.status == 200 && data.msg == "OK") {
        	                    	// 验证成功，提交
        	                    	SweetAlert.success("保存成功");
        	                    	
        	                    	// 复制给隐藏框，这样再次提交就是修改
        	                    	$("#" + hdnDataDictIdOrName).val(data.data.id);
        	                    	
        	                    	// 提交新增数据字典类型后，则要刷新下拉框中的数据，并且默认选中
        	                    	initDataDictTypes(dataTypeName);
        	                    	
        	                    	// 是否disable文本框
        	                    	setDDNameAndCode(data.data);
        	                    	
        	                    	$("#" + tb_rowIdOrName).attr("bgcolor", "");
        	                    	App.unblockUI();
        	                    } else {
        	                    	SweetAlert.error(data.data);
        	                    	$("#" + tb_rowIdOrName).attr("bgcolor", "#fbe1e3");
        	                    	console.log(JSON.stringify(data));
        	                    	App.unblockUI();
        	                    }
                        	},
                            error: function (response, ajaxOptions, thrownError) {
                            	Error.displayError(response, ajaxOptions, thrownError);
                            	App.unblockUI();
                            }
                        });
                    } else {
                    	SweetAlert.error("数据字典Key或者Value不能为空.");
                    	$("#" + tb_rowIdOrName).attr("bgcolor", "#fbe1e3");
                    }
                    
    			}
    		});
    		
    		// 动态绑定删除事件
    		$("#" + deleteId).bind('click',function(){
    			var dataDictId = $("#" + hdnDataDictIdOrName).val();
    			App.blockUI();
    			$.ajax({
                	url: $("#hdnContextPath").val() + "/dataDict/deleteDataDict.shtml?dataDictId=" + dataDictId,
                	type: "POST",
                	async: false,
                	success: function(data) {
	                    if(data.status == 200 && data.msg == "OK") {
	                    	// 验证成功，提交
	                    	SweetAlert.success("删除成功");
	                    	
	                    	// 刷新table
	                    	refreshByDataDictName();
	                    	
	                    	App.unblockUI();
	                    } else {
	                    	SweetAlert.error("删除失败：" + data.data);
	                    	console.log(JSON.stringify(data));
	                    	App.unblockUI();
	                    }
                	},
                    error: function (response, ajaxOptions, thrownError) {
                    	Error.displayError(response, ajaxOptions, thrownError);
                    	App.unblockUI();
                    }
                });
    			
    		});
    		
    }
    
    // 刷新数据字典缓存
    var refreshCache = function() {
    	App.blockUI();
		$.ajax({
        	url: $("#hdnContextPath").val() + "/dataDict/refreshDataDictInRedis.shtml",
        	type: "POST",
        	async: false,
        	success: function(data) {
                if(data.status == 200 && data.msg == "OK") {
                	// 验证成功，提交
                	SweetAlert.success("刷新缓存成功");
                	App.unblockUI();
                } else {
                	SweetAlert.error("刷新缓存失败：" + data.data);
                	console.log(JSON.stringify(data));
                	App.unblockUI();
                }
        	},
            error: function (response, ajaxOptions, thrownError) {
            	Error.displayError(response, ajaxOptions, thrownError);
            	App.unblockUI();
            }
        });
    }
    
    
    // 初始化数据字典列表对象
    var initDataDictTable = function() {
    	
    	// 按钮点击新增一行
    	$("#addRowDataDict").click(function(){
    		// table总行数
    		var rowCounts = $("#dataDictTbl tr").length;
    		// 当前行累计+1
    		var rowNumber = rowCounts - 1;
    		renderTableList(rowNumber, "", "", "");
    		return;
    	});
    	
    	// 按钮点击新增一行
    	$("#addRowDataDict2").click(function(){
    		// table总行数
    		var rowCounts = $("#dataDictTbl tr").length;
    		// 当前行累计+1
    		var rowNumber = rowCounts - 1;
    		renderTableList(rowNumber, "", "", "");
    		return;
    		
    	});
    	
    	// 刷新列表
    	$("#refreshRowDataDict").click(function(){
    		refreshByDataDictName();
    		return;
    	});
    	
    	// 刷新列表
    	$("#refreshRowDataDict2").click(function(){
    		refreshByDataDictName();
    		return;
    	});
    	
    	// 刷新缓存
    	$("#refreshCache").click(function(){
    		refreshCache();
    		return;
    	});
    	
    	// 刷新缓存
    	$("#refreshCache2").click(function(){
    		refreshCache();
    		return;
    	});
    	
    }
    
    return {
        // 初始化各个函数及对象
        init: function () {

            formDataDictValidation();
            initDataDictTypes(null);
            initDataDictTable();
            initDataDictListInTable();
        }

    };

}();

jQuery(document).ready(function() {
	DataDict.init();
});