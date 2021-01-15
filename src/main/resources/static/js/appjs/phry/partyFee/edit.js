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
		url : "/phry/partyFee/update",
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
			username : {
				required : true
			},
			sex : {
				required : true
			},
			idCard : {
				required : true
			},
			money : {
				required : true
			},
			payTime : {
				required : true
			},
		},
		messages : {
			username : {
				required : icon + "请输入姓名"
			},
			sex : {
				required : icon + "请选择性别"
			},
			idCard : {
				required : icon + "请输入身份证号"
			},
			money : {
				required : icon + "请输入党费金额"
			},
			payTime : {
				required : icon + "请选择缴纳党费时间"
			},
		}
	})
}
