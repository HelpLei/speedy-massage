
var prefix = "/phry/user"
	var deptId = '';
$(function() {
    
    getTreeData();
  
    $('#jstree').on("changed.jstree", function(e, data) {
        if (data.selected == -1) {
//            var opt = {
//                query : {
//                    deptId : '',
//                }
//            }
//            $('#exampleTable').bootstrapTable('refresh', opt);
        	deptId="";
        	$('#exampleTable').bootstrapTable('refresh');
        } else {
//            var opt = {
//                query : {
//                    deptId : data.selected[0],
//                }
//            }
//            $('#exampleTable').bootstrapTable('refresh',opt);
        	deptId=data.selected[0];
        	$('#exampleTable').bootstrapTable('refresh');
        }

    });
    load();
});

function load() {
	$('#exampleTable').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : prefix + "/list", // 服务器数据的加载地址
		//	showRefresh : true,
		//	showToggle : true,
		//	showColumns : true,
		iconSize : 'outline',
		toolbar : '#exampleToolbar',
		striped : true, // 设置为true会有隔行变色效果
		dataType : "json", // 服务器返回的数据类型
		pagination : true, // 设置为true会在底部显示分页条
		// queryParamsType : "limit",
		// //设置为limit则会发送符合RESTFull格式的参数
		singleSelect : false, // 设置为true将禁止多选
		// contentType : "application/x-www-form-urlencoded",
		// //发送到服务器的数据编码类型
		pageSize : 10, // 如果设置了分页，每页数据条数
		pageNumber : 1, // 如果设置了分布，首页页码
		//search : true, // 是否显示搜索框
		showColumns : true, // 是否显示内容下拉框（选择显示的列）
		sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
		queryParams : function(params) {
			return {
				//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
				limit: params.limit,
				offset:params.offset,
				username : $('#searchName').val(),
                mobile : $('#mobile').val(),
                idCard : $('#idCard').val(),
                
				deptId : deptId,
                ageBegin : $("#ageBegin").val(),
                ageEnd : $("#ageEnd").val(),
                nation : $("#nation").val(),
                jstree : $("#jstree").val(),
                zhuanye : $("#zhuanye").val(),
                education: $("#education").val(),
                personnelCategory: $("#personnelCategory").val()
			   // name:$('#searchName').val(),
			   // username:$('#searchName').val()
			};
		},
		// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
		// queryParamsType = 'limit' ,返回参数必须包含
		// limit, offset, search, sort, order 否则, 需要包含:
		// pageSize, pageNumber, searchText, sortName,
		// sortOrder.
		// 返回false将会终止请求
		columns : [
			{
				checkbox : true
			},
			{
				field : 'allsort',
				title : '序号'
			},
											{
				field : 'picId',
				title : '头像',
				width: '10%',
				align : 'center',
				formatter : function(value, row, index) {
					var temp = "";
					$.ajax({
						url : "/common/sysFile/info/"+value,
						type : "post",
						async:false,
						success : function(r) {
							if (r.code == 0 && r.sysFile!=null) {
								temp = "<img onclick='showFile("+r.sysFile.id+")' src='"+r.sysFile.url+"' style='width: 50%;cursor: pointer;'>";
							} else {
								temp = '<img onclick="showFile(0)" src="/img/backg01.jpg" style="width: 50%;cursor: pointer;" >';
							}
						}
					});
					return temp;
				}
			},
											{
				field : 'username',
				title : '姓名',
				width: '8%',
				formatter : function(value, row, index) {
					return '<a style="color: #5dd2b7;" href="/phry/user/showUserInfo/'+row.userId+'">'+value+'</a>';
				}
			},
											{
				field : 'mobile',
				title : '手机号'
			},
			// 								{
			// 	field : 'deptId',
			// 	title : '部门Id'
			// },
			// 								{
			// 	field : 'deptDO.name',
			// 	title : '所属部门',
			// },
			// 								{
			// 	field : 'idCard',
			// 	title : '身份证号'
			// },
											{
				field : 'nation',
				title : '民族'
			},
			/*								{
				field : 'natives',
				title : '籍贯'
			},*/
			/*								{
				field : 'birthPlace',
				title : '出生地'
			},*/
											{
				field : 'health',
				title : '健康状况'
			},
											{
				field : 'sex',
				title : '性别',
				formatter : function(value, row, index) {
					if (value == '0') {
						return '<span class="label label-danger">女</span>';
					} else if (value == '1') {
						return '<span class="label label-primary">男</span>';
					}
				}
			},
			/*								{
				field : 'contact',
				title : '联系方式'
			},*/
											{
				field : 'birth',
				title : '出身日期',
				formatter : function(value, row, index) {
					if(value!=null && value!=""){
						return value.substring(0,11);
					}
					return "";
				}
			},
            {
                field : 'age',
                title : '年龄'
            },
											{
				field : 'liveAddress',
				title : '现居住地'
			},
			
			{
				field : 'education',
				title : '学历'
			},	
			
			{
				field : 'personnelCategory',
				title : '人员类别',
				formatter : function(value, row, index) {
					if (value == '0') {
						return '<span class="label label-primary">行政</span>';
					} else if (value == '1') {
						return '<span class="label label-primary">事业</span>';
					}else if (value == '2') {
						return '<span class="label label-danger">编外人员</span>';
					}else if (value == '3') {
						return '<span class="label label-danger">编外人员(退役军人安置)</span>';
					}else if (value == '4') {
						return '<span class="label label-danger">编外人员(军嫂安置)</span>';
					}else if (value == '5') {
						return '<span class="label label-danger">编外人员(大学生村官)</span>';
					}
				}
			},
			
			
			// 								{
			// 	field : 'isOwner',
			// 	title : '1：系统用户2：录入人员'
			// },
											{
				field : 'status',
				title : '状态',
				formatter : function(value, row, index) {
					if (value == '0') {
						return '<span class="label label-danger">禁用</span>';
					} else if (value == '1') {
						return '<span class="label label-primary">正常</span>';
					}else if (value == '2') {
							return '<span class="label label-danger">调出</span>';
					}else if (value == '3') {
							return '<span class="label label-danger">离职</span>';
					} else if (value == '4') {
							return '<span class="label label-danger">退休</span>';
					}else if (value == '5') {
							return '<span class="label label-danger">死亡</span>';
					}
					
				}
			},
			/*								{
				field : 'gmtModified',
				title : '修改时间'
			},*/
            {
                field : 'fileId',
                title : '文件数',
                width: '10%',
                formatter : function(value, row, index) {
                	if(value==null||value==""||value==undefined){
                		return 0;
					}
                	var fileIdList = value.split(",");
                    return '<span style="color: #5dd2b7;cursor: pointer;" onclick="showFiles(\''+fileIdList+'\')">'+fileIdList.length+'</span>';
                }
            },
											{
				title : '操作',
				field : 'id',
				align : 'center',
				formatter : function(value, row, index) {
					var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
							+ row.userId
							+ '\')"><i class="fa fa-edit"></i></a> ';
					var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
							+ row.userId
							+ '\')"><i class="fa fa-remove"></i></a> ';
					var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
							+ row.userId
							+ '\')"><i class="fa fa-key"></i></a> ';
					return e + d ;
				}
			}
		]
	});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function showFile(fileId) {
    layer.open({
        type : 2,
        title : '文件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : prefix + '/showFile/'+fileId // iframe的url
    });
}


function showFiles(fileIdList) {
    layer.open({
        type : 2,
        title : '文件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : prefix + '/showFiles/'+fileIdList // iframe的url
    });
}



function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '100%', '100%' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '100%', '100%' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'userId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['userId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}

function changeSort() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要修改的序号");
		return;
	}
	if (rows.length > 1) {
		layer.msg("请选择单个序号进行修改");
		return;
	}
	var ids = new Array();
	// 遍历所有选择的行数据，取每条数据对应的ID
	$.each(rows, function(i, row) {
		ids[i] = row['userId'];
	});
	layer.open({
		type : 2,
		title : '修改序号',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '30%', '30%' ],
		content : prefix + '/changeXuhao/' + ids[0] // iframe的url
	});
}








function getTreeData() {
    $.ajax({
        type : "GET",
        url : "/system/sysDept/tree",
        success : function(tree) {
            loadTree(tree);
        }
    });
}
function loadTree(tree) {
    $('#jstree').jstree({
        'core' : {
            'data' : tree
        },
        "plugins" : [ "search" ],
        'state': {
            "opened":false,
       },
    });
    $('#jstree').jstree().close_all();
}
$('#jstree').on("changed.jstree", function(e, data) {
    if (data.selected == -1) {
        var opt = {
            query : {
                deptId : '',
            }
        }
        $('#exampleTable').bootstrapTable('refresh', opt);
    } else {
        var opt = {
            query : {
                deptId : data.selected[0],
            }
        }
        $('#exampleTable').bootstrapTable('refresh',opt);
    }

});

function localDaoChu() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	layer.open({
	    type : 2,
	    title : '选择需要导出的列',
	    maxmin : true,
	    shadeClose : false, // 点击遮罩关闭层
	    area : [ 0.8*(document.documentElement.clientWidth)+'px', 0.3*(document.documentElement.clientHeight)+'px' ],
	    content : prefix + '/local/'  // iframe的url
	});


	}

