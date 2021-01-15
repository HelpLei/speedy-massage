
var prefix = "/phry/user"
$(function() {
    var deptId = '';
  
    load(deptId);
});
$("#nation").change(function(){
	$('#exampleTable').bootstrapTable('refresh');
});
function load(deptId) {
	$('#exampleTable').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post
		url : prefix + "/listweixin", // 服务器数据的加载地址
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
				username : $('#searchName').val(),
				deptName : $('#nation').val(),
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
			/*{
				checkbox : true
			},*/
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
								temp = "<img onclick='showFile("+r.sysFile.id+")' src='"+r.sysFile.url+"' style='width: 20%;cursor: pointer;'>";
							} else {
								temp = '<img onclick="showFile(0)" src="/img/backg01.jpg" style="width: 20%;cursor: pointer;" >';
							}
						}
					});
					return temp;
				}
			},
											{
				field : 'username',
				title : '姓名',
				formatter : function(value, row, index) {
					return '<a style="color: #5dd2b7;" href="/phry/user/showUserInfo/'+row.userId+'">'+value+'</a>';
				}
			},
											{
				field : 'mobile',
				title : '手机号'
			},
			{
				field : 'idCard',
				title : '身份证'
			},
			/*{
				field : 'liveAddress',
				title : '现居住地'
			},*/
											{
			 	field : 'deptDO.name',
			 	title : '所属部门',
			},	
		]
	});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}









function resetPwd(id) {
}
