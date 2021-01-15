$(function() {
    load();

});
function load() {

    $('#exampleTable2').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/education/list", // 服务器数据的加载地址
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
        columns : [
            {
                checkbox : true
            },
            {
                field : 'eduCategory',
                title : '教育类别',
                formatter : function(value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">非全日制</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">全日制</span>';
                    }
                }
            },
            {
                field : 'eduCode',
                title : '学历代码'
            },
            {
                field : 'eduName',
                title : '学历名称'
            },
            {
                field : 'eduYear',
                title : '学历年限（年）'
            },
            {
                field : 'degreeCode',
                title : '学位代码'
            },
            {
                field : 'degreeName',
                title : '学位名称'
            },
            {
                field : 'schoolName',
                title : '学校名称'
            },
            {
                field : 'subjectCategory',
                title : '专业类别'
            },
            {
                field : 'subjectName',
                title : '专业名称'
            },
            {
                field : 'entranceTime',
                title : '入学时间',
                formatter : function(value, row, index) {
                    if (value != null) {
                        return value.substring(0,11);
                    }
                    return '';
                }
            },
            {
                field : 'graduationTime',
                title : '毕业时间',
                formatter : function(value, row, index) {
                    if (value != null) {
                        return value.substring(0,11);
                    }
                    return '';
                }
            },
            {
                field : 'awardTime',
                title : '学位授予时间',
                formatter : function(value, row, index) {
                    if (value != null) {
                        return value.substring(0,11);
                    }
                    return '';
                }
            },
            {
                field : 'graduationFileId',
                title : '毕业证书',
                align : 'center',
                formatter : function(value, row, index) {
                    var temp = "";
                    $.ajax({
                        url : "/common/sysFile/info/"+value,
                        type : "post",
                        async:false,
                        success : function(r) {
                            if (r.code == 0 && r.sysFile!=null) {
                                temp = "<img src='"+r.sysFile.url+"' style='width: 40%;cursor: pointer;'>";
                            } else {
                                temp = '<img src="/img/backg01.jpg" style="width: 40%;cursor: pointer;" >';
                            }
                        }
                    });
                    return temp;
                }
            },
            {
                field : 'awardFileId',
                title : '学位证书',
                align : 'center',
                formatter : function(value, row, index) {
                    var temp = "";
                    $.ajax({
                        url : "/common/sysFile/info/"+value,
                        type : "post",
                        async:false,
                        success : function(r) {
                            if (r.code == 0 && r.sysFile!=null) {
                                temp = "<img src='"+r.sysFile.url+"' style='width: 40%;cursor: pointer;'>";
                            } else {
                                temp = '<img src="/img/backg01.jpg" style="width: 40%;cursor: pointer;" >';
                            }
                        }
                    });
                    return temp;
                }
            },
            {
                field : 'updateTime',
                title : '修改时间'
            },
            {
                field : 'status',
                title : '状态',
                formatter : function(value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">禁用</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">正常</span>';
                    }
                }
            },
        ]
    });
}


