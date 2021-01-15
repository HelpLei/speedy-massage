$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
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
function save() {
	$("#roleIds").val(getCheckedRoles());
	$.ajax({
		cache : true,
		type : "POST",
		url : "/sys/user/save",
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
				required : true,
				minlength : 2,
			},
			password : {
				required : true,
				minlength : 6
			},
			// confirm_password : {
			// 	required : true,
			// 	minlength : 6,
			// 	equalTo : "#password"
			// },
            mobile : {
                required : true,
                minlength : 11,
                isMobile : true,
                remote : {
                    url : "/sys/user/exit", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        username : function() {
                            return $("#username").val();
                        }
                    }
                }
            },
            deptName:{
                required : true
            }
		},
		messages : {
			username : {
				required : icon + "请输入您的用户名",
				minlength : icon + "用户名必须两个字符以上",
				remote : icon + "用户名已经存在"
			},
			password : {
				required : icon + "请输入您的密码",
				minlength : icon + "密码必须6个字符以上"
			},
			// confirm_password : {
			// 	required : icon + "请再次输入密码",
			// 	minlength : icon + "密码必须6个字符以上",
			// 	equalTo : icon + "两次输入的密码不一致"
			// },
            mobile : {
                required : icon + "请输入手机号",
                minlength : "不能小于11个字符",
                isMobile : "请正确填写手机号码",
                remote : icon + "手机号码已经存在"
            },
            deptName:{
                required :  icon + "请选择所属机构",
            }
		}
	})
}

var openDept = function(){
	layer.open({
		type:2,
		title:"选择机构",
		area : [ '300px', '450px' ],
		content:"/system/deptInstitution/treeView"
	})
}
function loadDept( deptId,deptName){
	$("#deptId").val(deptId);
	$("#deptName").val(deptName);
}


jQuery.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(16[0-9]{9})|(19[0-9]{9})|(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写手机号码");

jQuery.validator.addMethod("isEmail", function(value, element) {
    var length = value.length;
    var mobile = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    return this.optional(element) ||  mobile.test(value);
}, "请正确填写邮箱格式");

jQuery.validator.addMethod("isIdCard", function(value, element) {
    var length = value.length;
    var mobile = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    return this.optional(element) ||  mobile.test(value);
}, "请正确填写身份证格式");