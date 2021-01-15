$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
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
		url : "/phry/pact/update",
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