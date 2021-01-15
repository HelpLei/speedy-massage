$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	partyFileId=[];
    for(var i=0;i<$(".fileIdL").length;i++){
        var temp = $($(".fileIdL")[i]).val();
        if(temp!=null&&temp!=""&&temp!=undefined){
        	partyFileId.push(temp);
        }
    }
    $("#partyFileId").val(partyFileId.toString());

	$.ajax({
		cache : true,
		type : "POST",
		url : "/phry/onlyParty/save",
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
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}
function reLoad() {
    $('#exampleTable2').bootstrapTable('refresh');

    $('#partyEnterTime').val('');
    $('#partyFileId').val(0);
    $('#showImg').attr("src","/img/backg01.jpg");
}
$(function() {
    load();

});
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

var openDept = function(){
	layer.open({
		type:2,
		title:"选择部门",
		area : [ '300px', '450px' ],
		content:"/phry/sysDeptDang/treeView"
	})
}
function loadDept( deptId,deptName){
	$("#deptId").val(deptId);
	$("#deptName").val(deptName);
}
