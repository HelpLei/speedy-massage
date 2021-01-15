$().ready(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/phry/education/save",
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
            eduCategory : {
				required : true
			},
            // eduCode : {
            //     required : true
            // },
            educationCodeId : {
                required : true
            },
            // eduYear : {
            //     required : true
            // },
            // degreeCode : {
            //     required : true
            // },
            // degreeName : {
            //     required : true
            // },
            schoolName : {
                required : true
            },
            // subjectCategory : {
            //     required : true
            // },
            // subjectName : {
            //     required : true
            // },
            entranceTime : {
                required : true
            },
            graduationTime : {
                required : true
            },
            // awardTime : {
            //     required : true
            // }
		},
		messages : {
            eduCategory : {
				required : icon + "请输入教育类别"
			},
            // eduCode : {
            //     required : icon + "请输入学历代码"
            // },
            educationCodeId : {
                required : icon + "请输入学历代码"
            },
            // eduYear : {
            //     required : icon + "请输入学历年限"
            // },
            // degreeCode : {
            //     required : icon + "请输入学位代码"
            // },
            // degreeName : {
            //     required : icon + "请输入学位名称"
            // },
            schoolName : {
                required : icon + "请输入学校名称"
            },
            // subjectCategory : {
            //     required : icon + "请输入专业类别"
            // },
            // subjectName : {
            //     required : icon + "请输入专业名称"
            // },
            entranceTime : {
                required : icon + "请输入入学时间"
            },
            graduationTime : {
                required : icon + "请输入毕业时间"
            },
            // awardTime : {
            //     required : icon + "请输入学位授予时间"
            // }

		}
	})
}


function reLoad() {
    $('#exampleTable2').bootstrapTable('refresh');

    $('#eduCategory').val('');
    $('#eduCode').val('');
    $('#eduName').val('');
    $('#eduYear').val('');
    $('#degreeCode').val('');

    $('#degreeName').val('');
    $('#schoolName').val('');
    $('#subjectCategory').val('');
    $('#subjectName').val('');
    $('#entranceTime').val('');
    $('#graduationTime').val('');
    $('#awardTime').val('');
    $('#graduationFileId').val(0);
    $('#showImg').attr("src","/img/backg01.jpg");

    $('#awardFileId').val(0);
    $('#showImg1').attr("src","/img/backg01.jpg");


}
$(function() {
    load();

});

function load() {
	$('#exampleTable2').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : "/phry/education/list", // 服务器数据的加载地址
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
				userId: $("#userId").val()
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
				field : 'eduCategory',
				title : '教育类别',
				formatter : function(value, row, index) {
					if (value == '0') {
						return '<span class="label label-danger">非全日制</span>';
					} else if (value == '1') {
						return '<span class="label label-primary">全日制</span>';
					}
				}
			},
											{
				field : 'eduCode',
				title : '学历代码'
			},
											{
				field : 'eduName',
				title : '学历名称'
			},
											{
				field : 'eduYear',
				title : '学历年限（年）'
			},
											{
				field : 'degreeCode',
				title : '学位代码'
			},
											{
				field : 'degreeName',
				title : '学位名称'
			},
											{
				field : 'schoolName',
				title : '学校名称'
			},
											{
				field : 'subjectCategory',
				title : '专业类别'
			},
											{
				field : 'subjectName',
				title : '专业名称'
			},
											{
				field : 'entranceTime',
				title : '入学时间',
				formatter : function(value, row, index) {
					if (value != null) {
						return value.substring(0,11);
					}
					return '';
				}
			},
											{
				field : 'graduationTime',
				title : '毕业时间',
				formatter : function(value, row, index) {
					if (value != null) {
						return value.substring(0,11);
					}
					return '';
				}
			},
											{
				field : 'awardTime',
				title : '学位授予时间',
				formatter : function(value, row, index) {
					if (value != null) {
						return value.substring(0,11);
					}
					return '';
				}
			},
											{
				field : 'graduationFileId',
				title : '毕业证书',
			   align : 'center',
				formatter : function(value, row, index) {
					var temp = "";
					$.ajax({
						url : "/common/sysFile/info/"+value,
						type : "post",
						async:false,
						success : function(r) {
							if (r.code == 0 && r.sysFile!=null) {
								temp = "<img src='"+r.sysFile.url+"' style='width: 40%;cursor: pointer;'>";
							} else {
								temp = '<img src="/img/backg01.jpg" style="width: 40%;cursor: pointer;" >';
							}
						}
					});
					return temp;
				}
			},
											{
				field : 'awardFileId',
				title : '学位证书',
			   align : 'center',
				formatter : function(value, row, index) {
					var temp = "";
					$.ajax({
						url : "/common/sysFile/info/"+value,
						type : "post",
						async:false,
						success : function(r) {
							if (r.code == 0 && r.sysFile!=null) {
								temp = "<img src='"+r.sysFile.url+"' style='width: 40%;cursor: pointer;'>";
							} else {
								temp = '<img src="/img/backg01.jpg" style="width: 40%;cursor: pointer;" >';
							}
						}
					});
					return temp;
				}
			},
											{
				field : 'updateTime',
				title : '修改时间'
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
                field : 'heightEdu',
                title : '最高学历',
                formatter : function(value, row, index) {
                    if(value==1){
                        return '<a onclick="setHeightEdu('+row.educationId+')">是</a>';
                    }
                    return '<a onclick="setHeightEdu('+row.educationId+')">否</a>';
                }
            },
            {
                title : '设置最高学历',
                field : 'id',
                align : 'center',
                formatter : function(value, row, index) {

                    var f = '<a class="btn btn-success btn-sm" href="#" title="设置最高学历"  mce_href="#" onclick="setHeightEdu(\''
                        + row.educationId
                        + '\')"><i class="fa fa-wrench"></i></a> ';

                    return f;
                }
            }
		]
    });
}

function setHeightEdu(educationId){
    $.ajax({
        cache : true,
        type : "POST",
        url : "/phry/education/setHeightEdu/"+educationId,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("设置成功");
                reLoad();
            }
        }
    });
}


var openDept = function(){
    layer.open({
        type:2,
        title:"选择学历",
        area : [ '300px', '450px' ],
        content:"/phry/educationCode/treeView"
    })
}

function loadCode(educationCodeId){
    $.ajax({
        cache : true,
        type : "POST",
        url : "/phry/educationCode/get/"+educationCodeId,
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
        	var educationCodeDTO = data.educationCodeDTO;
            if (data.code == 0) {
                $("#educationCodeId").val(educationCodeDTO.educationCodeId);
                $("#eduCode").val(educationCodeDTO.educationCode);
                $("#eduName").val(educationCodeDTO.educationCodeName);
                $("#eduYear").val(educationCodeDTO.educationYear);
            }
        }
    });
}



