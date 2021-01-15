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
		url : "/phry/party/update",
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
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}



function reLoad() {
    $('#exampleTable2').bootstrapTable('refresh');
}
$(function() {
    load();
});

function edit(id) {
	
	  fileIds=[];
	    for(var i=0;i<$(".fileIdL").length;i++){
	        var temp = $($(".fileIdL")[i]).val();
	        if(temp!=null&&temp!=""&&temp!=undefined){
	            fileIds.push(temp);
	        }
	    }
	    $("#fileId").val(fileIds.toString());
	
    $.ajax({
        cache : true,
        type : "POST",
        url : "/phry/party/get/"+id,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                var row = data.partyDTO;

                $('#partyId').val(row.partyId);
                $('#partyEnterTime').val(row.partyEnterTime);
                if(row.fileDO!=null){
                    $('#partyFileId').val(row.fileDO.partyFileId);
                    $('#showImg').attr("src",row.fileDO.url);
                }else{
                    $('#graduationFileId').val(0);
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
            url : "/phry/party/remove",
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

function load() {
    $('#exampleTable2').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/party/list", // 服务器数据的加载地址
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
                userId:$("#userId").val()
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
                field : 'partyEnterTime',
                title : '入党时间',
                formatter: function (value, row, index) {
                    if (value != null) {
                        return value.substring(0, 11);
                    }
                    return '';
                }
            },
            {
                field : 'partyFileId',
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
                field : 'createTime',
                title : '创建时间'
            },
            {
                field : 'updateTime',
                title : '修改时间'
            },
            {
                field : 'status',
                title : '状态',
                formatter : function(value, row, index){
                    if (value == '0') {
                        return '<span class="label label-danger">禁用</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">正常</span>';
                    }
                }
            },
            {
                title : '操作',
                field : 'id',
                align : 'center',
                formatter : function(value, row, index) {
                    var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                        + row.partyId
                        + '\')"><i class="fa fa-edit"></i></a> ';
                    var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                        + row.partyId
                        + '\')"><i class="fa fa-remove"></i></a> ';
                    return e + d ;
                }
            } ]
    });
}
function showFile(fileId) {
    layer.open({
        type : 2,
        title : '文件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : '/phry/user/showFile/'+fileId // iframe的url
    });
}