
var prefix = "/phry/workHistory"
$(function() {
	load();
});

function load() {
	// $('#exampleTable')
	// 		.bootstrapTable(
	// 				{
	// 					method : 'get', // 服务器数据的请求方式 get or post
	// 					url : prefix + "/list", // 服务器数据的加载地址
	// 				//	showRefresh : true,
	// 				//	showToggle : true,
	// 				//	showColumns : true,
	// 					iconSize : 'outline',
	// 					toolbar : '#exampleToolbar',
	// 					striped : true, // 设置为true会有隔行变色效果
	// 					dataType : "json", // 服务器返回的数据类型
	// 					pagination : true, // 设置为true会在底部显示分页条
	// 					// queryParamsType : "limit",
	// 					// //设置为limit则会发送符合RESTFull格式的参数
	// 					singleSelect : false, // 设置为true将禁止多选
	// 					// contentType : "application/x-www-form-urlencoded",
	// 					// //发送到服务器的数据编码类型
	// 					pageSize : 10, // 如果设置了分页，每页数据条数
	// 					pageNumber : 1, // 如果设置了分布，首页页码
	// 					//search : true, // 是否显示搜索框
	// 					showColumns : false, // 是否显示内容下拉框（选择显示的列）
	// 					sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
	// 					queryParams : function(params) {
	// 						return {
	// 							//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
	// 							limit: params.limit,
	// 							offset:params.offset,
     //                            userId:$('#userId').val()
	// 				           // name:$('#searchName').val(),
	// 				           // username:$('#searchName').val()
	// 						};
	// 					},
	// 					// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
	// 					// queryParamsType = 'limit' ,返回参数必须包含
	// 					// limit, offset, search, sort, order 否则, 需要包含:
	// 					// pageSize, pageNumber, searchText, sortName,
	// 					// sortOrder.
	// 					// 返回false将会终止请求
	// 					columns : [
	// 															{
	// 								checkbox : true
	// 							},
	// 							// 								{
	// 							// 	field : 'workId',
	// 							// 	title : '主键Id'
	// 							// },
	// 															{
	// 								field : 'userInfoDTO.username',
	// 								title : '人员姓名',
	// 							},
	// 															{
	// 								field : 'workTime',
	// 								title : '工作是否有两年',
	// 								formatter : function(value, row, index) {
	// 									if (value == '0') {
	// 										return '<span class="label label-danger">否</span>';
	// 									} else if (value == '1') {
	// 										return '<span class="label label-primary">是</span>';
	// 									}
	// 								}
	// 							},
	// 															{
	// 								field : 'workAllName',
	// 								title : '全称'
	// 							},
	// 															{
	// 								field : 'workSimpleName',
	// 								title : '简称'
	// 							},
	// 															{
	// 								field : 'workInstitution',
	// 								title : '任职机构'
	// 							},
	// 															{
	// 								field : 'workName',
	// 								title : '任职名称'
	// 							},
	// 															{
	// 								field : 'officeName',
	// 								title : '职务名称'
	// 							},
	// 															{
	// 								field : 'workCategory',
	// 								title : '成员类别'
	// 							},
	// 															{
	// 								field : 'selectMethods',
	// 								title : '选拔任用方式'
	// 							},
	// 															{
	// 								field : 'documentFileId',
	// 								title : '任职文号（图片）',
	// 								width: '10%',
	// 								align : 'center',
	// 								formatter : function(value, row, index) {
	// 									var temp = "";
	// 									$.ajax({
	// 										url : "/common/sysFile/info/"+value,
	// 										type : "post",
	// 										async:false,
	// 										success : function(r) {
	// 											if (r.code == 0 && r.sysFile!=null) {
	// 												temp = "<img src='"+r.sysFile.url+"' style='width: 50%;cursor: pointer;'>";
	// 											} else {
	// 												temp = '<img src="/img/backg01.jpg" style="width: 50%;cursor: pointer;" >';
	// 											}
	// 										}
	// 									});
	// 									return temp;
	// 								}
	// 							},
	// 															{
	// 								field : 'status',
	// 								title : '状态',
	// 								formatter : function(value, row, index) {
	// 									if (value == '0') {
	// 										return '<span class="label label-danger">禁用</span>';
	// 									} else if (value == '1') {
	// 										return '<span class="label label-primary">正常</span>';
	// 									}
	// 								}
	// 							},
	// 															{
	// 								field : 'updateTime',
	// 								title : '修改时间'
	// 							},
    //
	// 															{
	// 								title : '操作',
	// 								field : 'id',
	// 								align : 'center',
	// 								formatter : function(value, row, index) {
	// 									var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
	// 											+ row.workId
	// 											+ '\')"><i class="fa fa-edit"></i></a> ';
	// 									var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
	// 											+ row.workId
	// 											+ '\')"><i class="fa fa-remove"></i></a> ';
	// 									var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
	// 											+ row.workId
	// 											+ '\')"><i class="fa fa-key"></i></a> ';
	// 									return e + d ;
	// 								}
	// 							} ]
	// 				});

    $('#exampleTable').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/user/list", // 服务器数据的加载地址
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
        showColumns : false, // 是否显示内容下拉框（选择显示的列）
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                offset:params.offset,
                username:$('#searchName').val(),
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
                field : 'username',
                title : '姓名'
                // formatter : function(value, row, index) {
                // 	return '<a style="color: #5dd2b7;" href="/phry/user/doUserMain/'+row.userId+'">'+value+'</a>';
                // }
            },
            {
                field : 'mobile',
                title : '手机号'
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
            {
                field : 'liveAddress',
                title : '现居住地'
            },
            {
                field : 'userId',
                title : '工作经历数量',
                formatter : function(value, row, index) {
                    var total = 0;
                    $.ajax({
                        url : "/phry/workHistory/list",
                        type : "get",
                        data :{ userId: value,offset: 0,limit: 10000,status:1},
                        async:false,
                        success : function(r) {
                            total = r.total;
                        }
                    });
                    return total;
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
                    // var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    // 	+ row.userId
                    // 	+ '\')"><i class="fa fa-remove"></i></a> ';
                    var f = '<a class="btn btn-success btn-sm" href="#" title="查看"  mce_href="#" onclick="look(\''
                        + row.userId
                        + '\')"><i class="fa fa-eye"></i></a> ';
                    return e + f;
                }
            }
        ]
    });
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择人员");
        return;
    }
    if (rows.length> 1) {
        layer.msg("请选择一个人员");
        return;
    }
    var userId = rows[0]['userId'];

    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : prefix + '/add/'+userId, // iframe的url
        cancel : function() {
            reLoad()
        }
    });
}
function edit(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : prefix + '/edit/' + id, // iframe的url
        cancel : function() {
            reLoad()
        }
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
				'workId' : id
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

function look(id) {
    layer.open({
        type : 2,
        title : '查看',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : prefix + '/look/' + id // iframe的url
    });
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
			ids[i] = row['workId'];
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