$(function() {
    load();

});
function load() {

    $('#exampleTable2').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/rewards/list", // 服务器数据的加载地址
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
                userId:$('#userId').val()
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
                field : 'rewardsPunishmentTime',
                title : '奖惩时间',
                formatter: function (value, row, index) {
                    if (value != null) {
                        return value.substring(0, 11);
                    }
                    return '';
                }
            },
            
          /*  {
                field : 'partyFileId',
                title : '任职文号（图片）',
                width: '10%',
                align : 'center',
                formatter : function(value, row, index) {
                    var temp = "";
                    $.ajax({
                        url : "/common/sysFile/info/"+value,
                        type : "post",
                        async:false,
                        success : function(r) {
                            if (r.code == 0 && r.sysFile!=null) {
                                temp = "<img onclick='showFile("+r.sysFile.id+")' src='"+r.sysFile.url+"' style='width: 50%;cursor: pointer;'>";
                            } else {
                                temp = '<img onclick="showFile(0)" src="/img/backg01.jpg" style="width: 50%;cursor: pointer;" >';
                            }
                        }
                    });
                    return temp;
                }
            },*/
            {
                field : 'honorName',
                title : '奖惩名称'
            },
            {
                field : 'honorUnit',
                title : '奖惩单位'
            },
            {
                field : 'fileNumber',
                title : '文件号'
            },
            {
                field : 'rewardsWord',
                title : '奖惩说明'
            },
          /*  {
                field : 'updateTime',
                title : '修改时间'
            },*/
           /* {
                field : 'status',
                title : '状态',
                formatter : function(value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">禁用</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">正常</span>';
                    }
                }
            }*/
        ]
    });
}

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