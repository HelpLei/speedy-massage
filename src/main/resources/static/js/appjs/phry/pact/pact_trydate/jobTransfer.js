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
		url : "/phry/pact/updateTransfer",
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

var openDept = function(){
    layer.open({
        type:2,
        title:"选择部门",
        area : [ '300px', '450px' ],
        content:"/system/sysDept/treeView"
    })
}
function loadDept( deptId,deptName){
    $("#deptId").val(deptId);
    $("#deptName").val(deptName);
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