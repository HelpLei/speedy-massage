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
		url : "/phry/leave/update2",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
			  	//parent.reLoad();
			      var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			      
			      parent.layer.close(index);
			      window.reload()
			/*	parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);*/
				/* parent.location.reload();*/
				/*window.parent.location.reload(); *///刷新父页面
//				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//				parent.layer.close(index);
			/*parent.location.reload(); */
//				var index2 =index-1 ; // 获取窗口索引
//				parent.layer.close(index2);
		/* parent.location.href ='../index.html#leave/leave.html';*/
				
//				parent.parent.parent.reLoad();
//			var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
//			parent.layer.close(index);	
			
				
				
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
			}
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