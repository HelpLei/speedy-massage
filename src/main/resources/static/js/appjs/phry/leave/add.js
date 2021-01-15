$().ready(function() {
	validateRule();
});
var prefix = "/phry/leave"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list2", // 服务器数据的加载地址
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
								offset:params.offset
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
								},/*
																{
									field : 'id', 
									title : '合同ID',
									hidden:true
								},
																{
									field : 'dateSigning', 
									title : '签订时间' ,
									hidden:true
								},
																{
									field : 'expirationTime', 
									title : '到期时间' ,
									hidden:true
								},
																{
									field : 'personnelId', 
									title : '人员表ID' ,
									hidden:true
								},
																{
									field : 'probationPeriod', 
									title : '试用期时间' ,
									hidden:true
								},*/
																{
									field : 'name', 
									title : '姓名' 
								},
																{
									field : 'dateBirth', 
									title : '出生日期' 
								},
																{
									field : 'department', 
									title : '部门' 
								},
																{
									field : 'post', 
									title : '职位' 
								},
										/*						{
									field : 'workingState', 
									title : '在职状态(1为在职,2为提前离职，3已续签合同，4正常离职)' 
								},*/
											/*					{
									field : 'expirationDate', 
									title : '合同到期具体时间' ,
									hidden:true
								},*/
								/*								{
									field : 'probationDate', 
									title : '试用期到期具体时间' ,
									hidden:true
								},*/
								/*								{
									field : 'retireDate', 
									title : '退休时间' ,
									hidden:true
								},*/
																{
									field : 'sex', 
									title : '性别' ,
									formatter : function(value, row, index) {
										if (value == '0') {
											return '<span class="label label-danger">女</span>';
										} else if (value == '1') {
											return '<span class="label label-primary">男</span>';
										}
									}
								},
																{
									field : 'pactRemark', 
									title : '备注' 
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
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
    $("#name").val(rows[0].name)
    $("#pactId").val(rows[0].id)
    $("#department").val(rows[0].department)
    $("#post").val(rows[0].post)

    var show1=document.getElementById("show1");
    show1.style.display="";
    var show2=document.getElementById("show2");
    show2.style.display="none";

	/*top.layer.open({
	 type : 2,
	 title : '详情',
	 area : [ '50%', '60%' ],
	 shadeClose : false,
	 content :  prefix + '/edit2/' + id,

	 });
	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	 parent.layer.close(index);*/
}

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	
	$('#signupForm').serialize()
	
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/phry/leave/save",
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
			leaveTime : {
				required : true
			},
			endTime : {
				required : true
			},
		},
		messages : {
			name : {
				required : icon + "请选择姓名"
			},
			leaveTime : {
				required : icon + "请输入开始请假时间"
			},
			endTime : {
				required : icon + "请输入请假结束时间"
			},
		}
	})
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

