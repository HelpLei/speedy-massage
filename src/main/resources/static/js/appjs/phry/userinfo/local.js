$().ready(function() {
	validateRule();
});
var prefix = "/phry/user";

$.validator.setDefaults({
	submitHandler : function() {
		shutDown();
	}
});
function shutDown() {
	
	$("#roleIds").val(getCheckedRoles());
	
	var name=$("#roleIds").val();
	    //导出模板
	    window.location.href = prefix + '/exportLocal?names='+name;
	    
	

}
function getCheckedRoles() {
	var adIds = "";
	$("input:checkbox[name=role]:checked").each(function(i) {
		if (0 == i) {
			adIds = $(this).val();
		} else {
			adIds += ("," + $(this).val());
		}
	});
	return adIds;
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