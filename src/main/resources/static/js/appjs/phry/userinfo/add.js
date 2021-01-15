$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
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
		url : "/phry/user/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				// var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				// parent.layer.close(index);
                parent.reLoad();
                window.location.href="/phry/user/doUserMain/"+data.userId;
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
            mobile : {
                required : true,
                minlength : 11,
                isMobile : true
            },
          /*  birth:{
                required : true
            },*/
            idCard:{
                isIdCard : true
            },
            nation:{
                required : true
            },
            natives:{
                required : true
            },
            birthPlace:{
                required : true
            },
            // health:{
            //     required : true
            // },
            // contact:{
            //     required : true
            // },
            // liveAddress:{
            //     required : true
            // },
            deptName:{
                required : true
            },

		},
		messages : {
            username : {
				required : icon + "请输入姓名"
            },
            mobile : {
                required : icon + "请输入手机号",
                minlength : "不能小于11个字符",
                isMobile : "请正确填写手机号码"
            },
         /*   birth:{
                required: icon + "请选择出生日期"
            },*/
            idCard:{
                 required: icon + "请输入身份证号码",
                isIdCard : "请正确填写身份证格式"
            },
            nation:{
                required :  icon + "请选择民族",
            },
            natives:{
                required :  icon + "请输入籍贯",
            },
            birthPlace:{
                required :  icon + "请输入出生地",
            },
            // health:{
            //     required :  icon + "请输入健康状况",
            // },
            // contact:{
            //     required :  icon + "请输入联系方式",
            // },
            // liveAddress:{
            //     required :  icon + "请输入现居住地",
            // },
            deptName:{
                required :  icon + "请选择所属部门",
            },
		}
	})
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


