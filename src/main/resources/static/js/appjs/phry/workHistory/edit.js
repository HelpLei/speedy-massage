$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/phry/workHistory/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
                reLoad();

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            userId : {
                required : true
            },
            workAllName : {
                required : true
            },
            // workSimpleName : {
            //     required : true
            // },
            workInstitution : {
                required : true
            },
           /* workName : {
                required : true
            },*/
            officeName : {
                required : true
            },

            workingTime : {
                required : true
            },
            // workCategory : {
            //     required : true
            // },
            // selectMethods : {
            //     required : true
            // },
        },
        messages : {
            userId : {
                required : icon + "请选择人员姓名"
            },
            workAllName : {
                required : icon + "请输入全称"
            },
            // workSimpleName : {
            //     required : icon + "请输入简称"
            // },
            workInstitution : {
                required : icon + "请输入任职机构"
            },
         /*   workName : {
                required : icon + "请输入任职名称"
            },*/
            officeName : {
                required : icon + "请输入职务名称"
            },
            workingTime : {
                required : icon + "请选择任职时间"
            },

            // workCategory : {
            //     required : icon + "请输入成员类别"
            // },
            // selectMethods : {
            //     required : icon + "请输入选拔任用方式"
            // },
        }
    })
}





function reLoad() {
    $('#exampleTable2').bootstrapTable('refresh');
}

function edit(id) {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/phry/workHistory/get/"+id,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                var row = data.workHistoryDTO;
                $('#workId').val(row.workId);
                $("input[name='workTime'][value='"+row.workTime+"']").prop("checked",true);
                $('#workAllName').val(row.workAllName);
                $('#workSimpleName').val(row.workSimpleName);
                $('#workInstitution').val(row.workInstitution);
                $('#workName').val(row.workName);
                $('#officeName').val(row.officeName);
                $('#workCategory').val(row.workCategory);

                $('#selectMethods').val(row.selectMethods);
                $('#workingTime').val(row.workingTime);
                $('#leavingTime').val(row.leavingTime);
                $('#createTime').val(row.createTime);
                if(row.fileDO!=null) {
                    $('#documentFileId').val(row.documentFileId);
                    $('#showImg').attr("src", row.fileDO.url);
                }else{
                    $('#documentFileId').val(0);
                    $('#showImg').attr("src","/img/backg01.jpg");
                }
                $("input[name='status'][value='"+row.status+"']").prop("checked",true);
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}

function remove(id) {
    layer.confirm('确定要禁用选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : "/phry/workHistory/remove",
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

$(function() {
    load();

});
function load() {

    $('#exampleTable2').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/workHistory/list", // 服务器数据的加载地址
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
                userId:$('#userId').val()
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
                field : 'workingTime',
                title : '任职时间',
                formatter : function(value, row, index) {
                    if (value != null) {
                        return value.substring(0,11);
                    }
                    return '';
                }
            },
                                            {
                field : 'leavingTime',
                title : '离职时间',
                formatter : function(value, row, index) {
                    if (value != null) {
                        return value.substring(0,11);
                    }
                    return '';
                }
            },
        /*	{
                field : 'workTime',
                title : '工作是否有两年',
                formatter : function(value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">否</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">是</span>';
                    }
                }
            },*/
                /*                            {
                field : 'workAllName',
                title : '全称'
            },*/
              /*                              {
                field : 'workSimpleName',
                title : '简称'
            },*/
                                            {
                field : 'workInstitution',
                title : '任职机构'
            },
            /*                                {
                field : 'workName',
                title : '任职名称'
            },*/
                                            {
                field : 'officeName',
                title : '职务名称'
            },
              /*                              {
                field : 'workCategory',
                title : '成员类别'
            },*/
                                            {
                field : 'selectMethods',
                title : '选拔任用方式'
            },
             
                                            {
                field : 'documentFileId',
                title : '任职文号（图片）',
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
                                temp = "<img src='"+r.sysFile.url+"' style='width: 50%;cursor: pointer;'>";
                            } else {
                                temp = '<img src="/img/backg01.jpg" style="width: 50%;cursor: pointer;" >';
                            }
                        }
                    });
                    return temp;
                }
            },
                                            {
                field : 'status',
                title : '状态',
                formatter : function(value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">禁用</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">正常</span>';
                    }
                }
            },
                                            {
                field : 'updateTime',
                title : '修改时间'
            },

                                            {
                title : '操作',
                field : 'id',
                align : 'center',
                formatter : function(value, row, index) {
                    var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                            + row.workId
                            + '\')"><i class="fa fa-edit"></i></a> ';
                    var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                            + row.workId
                            + '\')"><i class="fa fa-remove"></i></a> ';
                    return e + d ;
                }
            }
        ]
    });
}