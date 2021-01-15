$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/phry/family/save",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                layer.msg("操作成功");
                // parent.reLoad();
                // var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                // parent.layer.close(index);
                reLoad();

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
            familyAppellation : {
                required : true
            },
            familyName : {
                required : true
            },
            birthTime : {
                required : true
            },
            // politicsFace : {
            //     required : true
            // },
            // workUnits : {
            //     required : true
            // }
        },
        messages : {
            familyAppellation : {
                required : icon + "请输入称谓"
            },
            familyName : {
                required : icon + "请输入姓名"
            },
            birthTime : {
                required : icon + "请输入出生日期"
            },
            // politicsFace : {
            //     required : icon + "请输入政治面貌"
            // },
            // workUnits : {
            //     required : icon + "请输入工作单位以及职务"
            // }
        }
	})
}


function reLoad() {
    $('#exampleTable2').bootstrapTable('refresh');
    $('#familyAppellation').val('');
    $('#familyName').val('');
    $('#birthTime').val('');
    $('#politicsFace').val('');
    $('#workUnits').val('');
}
$(function() {
    load();

});
function load() {

    $('#exampleTable2').bootstrapTable({
        method: 'get', // 服务器数据的请求方式 get or post
        url: "/phry/family/list", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize: 'outline',
        toolbar: '#exampleToolbar',
        striped: true, // 设置为true会有隔行变色效果
        dataType: "json", // 服务器返回的数据类型
        pagination: true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect: false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        pageSize: 10, // 如果设置了分页，每页数据条数
        pageNumber: 1, // 如果设置了分布，首页页码
        //search : true, // 是否显示搜索框
        showColumns: false, // 是否显示内容下拉框（选择显示的列）
        sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams: function (params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                offset: params.offset,
                userId: $("#userId").val()
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
        columns: [
            {
                field: 'familyAppellation',
                title: '称谓'
            },
            {
                field: 'familyName',
                title: '姓名'
            },
            {
                field: 'birthTime',
                title: '出生日期',
                formatter: function (value, row, index) {
                    if (value != null) {
                        return value.substring(0, 11);
                    }
                    return '';
                }
            },
            {
                field: 'politicsFace',
                title: '政治面貌'
            },
            {
                field: 'workUnits',
                title: '工作单位以及职务'
            },
            {
                field: 'updateTime',
                title: '修改时间'
            },
            {
                field: 'status',
                title: '状态',
                formatter: function (value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">禁用</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">正常</span>';
                    }
                }
            }
           ]
    });
}


