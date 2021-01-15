
var prefix = "/phry/onlyParty";
	var deptId = '';
$(function() {
    getTreeData();
    
    load(deptId);
});

function load(deptId) {
	$('#exampleTable')
			.bootstrapTable(
					{
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
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
					           name:$('#name').val(),
					           deptId : deptId
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
									/*							{
									field : 'partyId', 
									title : '主键Id' 
								},
									*/			
								{
									field : 'phoneId',
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
									field : 'name', 
									title : '姓名' 
								},
								{
									field : 'shouji', 
									title : '手机号' 
								},
								{
									field : 'card', 
									title : '身份证' 
								},
									
																{
									field : 'partyEnterTime', 
									title : '入党时间' ,
									formatter : function(value, row, index) {
										if(value!=null && value!=""){
											return value.substring(0,11);
										}
										return "";
									}
								},
								/*								{
									field : 'partyFileId', 
									title : '文件' 
								},*/
								 {
					                field : 'partyFileId',
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
								/*								{
									field : 'createTime', 
									title : '创建时间' 
								},
																{
									field : 'updateTime', 
									title : '修改时间' 
								},*/
								
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.partyId
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.partyId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.partyId
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '80%', '80%' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '80%', '80%' ],
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
				'partyId' : id
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
			ids[i] = row['partyId'];
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


function getTreeData() {
    $.ajax({
        type : "GET",
        url : "/phry/sysDeptDang/tree",
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
