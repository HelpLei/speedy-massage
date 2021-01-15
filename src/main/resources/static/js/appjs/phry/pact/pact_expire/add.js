$().ready(function() {
	validateRule();

});

var prefix = "/phry/leave"
	$(function() {
		load();
	});

function load(deptId) {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list3", // 服务器数据的加载地址
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
                                name : $('#searchName').val(),
                                deptId : deptId
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
									/*							{
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
                                                    temp = "<img src='"+r.sysFile.url+"' style='width: 50%;cursor: pointer;'>";
                                                } else {
                                                    temp = '<img src="/img/backg01.jpg" style="width: 50%;cursor: pointer;" >';
                                                }
                                            }
                                        });
                                        return temp;
									}
								},*/
																{
									field : 'username', 
									title : '姓名'
								},
																{
									field : 'mobile', 
									title : '手机号' 
								},
								
																{
									field : 'deptDO.name',
									title : '所属部门',
								},
																{
									field : 'idCard', 
									title : '身份证号' 
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
									field : 'contact', 
									title : '联系方式' 
								},
																{
									field : 'birth', 
									title : '出身日期' 
								},
																{
									field : 'liveAddress', 
									title : '现居住地' 
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
								} ]
					});
}
	function reLoad() {
		$('#exampleTable').bootstrapTable('refresh');
	}

	function getHeList() {
		
		
		parent.layer.msg("操作成功");
		
	/*	parent.reLoad();*/
		/*var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		parent.layer.close(index);*/
		  var show1=document.getElementById("show1");
		  show1.style.display="none";
		  var show2=document.getElementById("show2");
		  show2.style.display="";

}
	
	function updateTrue() {

		var rows = $('#exampleTable').bootstrapTable('getSelections');
		
		if (rows.length == 0) {
			layer.msg("请选择人员");
			return;
		}
		if (rows.length> 1) {
			layer.msg("请选择一个人员");
			return;
		}

		var id=rows[0].id
		$("#name").val(rows[0].username)
		$("#personnelId").val(rows[0].id)
		$("#department").val(rows[0].deptDO.name)
		$("#post").val(rows[0].post)
		$("#dateBirth").val(rows[0].birth)
		var show1=document.getElementById("show1");
		  show1.style.display="";
		  var show2=document.getElementById("show2");
		  show2.style.display="none";
		
	}


$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/phry/pact/saveE",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

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
			},
			dateSigning : {
				required : true
			},
			probationPeriod : {
				required : true
			},
			expirationTime : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请选择姓名"
			},
			dateSigning : {
				required : icon + "请选择签订日期"
			},
			probationPeriod : {
				required : icon + "请选择试用期日期"
			},
			expirationTime : {
				required : icon + "请选择合同到期日期"
			}
		}
	})
}