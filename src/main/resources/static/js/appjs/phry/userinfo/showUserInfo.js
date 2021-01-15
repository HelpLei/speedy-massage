$(function() {
    load0();
    load1();
    load2();
    load3();
    load4();
    load5();
    load6();
    load7();
});
function load0() {
    $('#exampleTable0').bootstrapTable({
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
        paginationDetailHAlign:"right",
        //search : true, // 是否显示搜索框
        showColumns : false, // 是否显示内容下拉框（选择显示的列）
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: 10000,
                offset:0,
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
           /* {
                field : 'eduCategory',
                title : '教育类别'
            },
            {
                field : 'eduCode',
                title : '学历代码'
            },*/
            {
                field : 'eduName',
                title : '学历名称'
            },
            {
                field : 'eduYear',
                title : '学历年限（年）'
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
                field : 'degreeCode',
                title : '学位代码'
            },
            {
                field : 'degreeName',
                title : '学位名称'
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
                                temp = "<img src='"+r.sysFile.url+"' onclick='showFile("+r.sysFile.id+")' style='width: 40%;cursor: pointer;'>";
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
                                temp = "<img src='"+r.sysFile.url+"' onclick='showFile("+r.sysFile.id+")' style='width: 40%;cursor: pointer;'>";
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

function load1() {

    $('#exampleTable1').bootstrapTable({
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
        paginationDetailHAlign:"right",
        //search : true, // 是否显示搜索框
        showColumns: false, // 是否显示内容下拉框（选择显示的列）
        sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams: function (params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: 10000,
                offset: 0,
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

function load2() {
    $('#exampleTable2').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/party/list", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize : 'outline',
        toolbar : '#exampleToolbar2',
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect : false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        paginationDetailHAlign:"right",
        //search : true, // 是否显示搜索框
        showColumns : false, // 是否显示内容下拉框（选择显示的列）
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: 10000,
                offset: 0,
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
                field : 'partyEnterTime',
                title : '入党时间',
                formatter: function (value, row, index) {
                    if (value != null) {
                        return value.substring(0, 11);
                    }
                    return '';
                }
            },
            {
                field : 'partyFileId',
                title : '文件数',
                width: '10%',
                formatter : function(value, row, index) {
                	if(value==null||value==""||value==undefined){
                		return 0;
					}
                	var fileIdList = value.split(",");
                    return '<span style="color: #5dd2b7;cursor: pointer;" onclick="showFiles(\''+fileIdList+'\')">'+fileIdList.length+'</span>';
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
                field : 'createTime',
                title : '创建时间'
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
            }
        ]
    });
}

function load3() {

    $('#exampleTable3').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/workHistory/list", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize : 'outline',
        toolbar : '#exampleToolbar3',
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect : false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        paginationDetailHAlign:"right",
        //search : true, // 是否显示搜索框
        showColumns : false, // 是否显示内容下拉框（选择显示的列）
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: 10000,
                offset: 0,
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
        /*    {
                field : 'workTime',
                title : '工作是否有两年',
                formatter : function(value, row, index) {
                    if (value == '0') {
                        return '<span class="label label-danger">否</span>';
                    } else if (value == '1') {
                        return '<span class="label label-primary">是</span>';
                    }
                }
            },*/
        	
        	   {
                   field : 'workingTime',
                   title : '任职时间',
                   formatter : function(value, row, index) {
                       if (value != null) {
                           return value.substring(0,11);
                       }
                       return '';
                   }
               },
               {
                   field : 'leavingTime',
                   title : '离职时间',
                   formatter : function(value, row, index) {
                       if (value != null) {
                           return value.substring(0,11);
                       }
                       return '';
                   }
               },
               
          /*  {
                field : 'workAllName',
                title : '全称'
            },*/
           /* {
                field : 'workSimpleName',
                title : '简称'
            },*/
            {
                field : 'workInstitution',
                title : '任职机构'
            },
         /*   {
                field : 'workName',
                title : '任职名称'
            },*/
            {
                field : 'officeName',
                title : '职务名称'
            },
          /*  {
                field : 'workCategory',
                title : '成员类别'
            },*/
            {
                field : 'selectMethods',
                title : '选拔任用方式'
            },
         
           
            {
                field : 'documentFileId',
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
                                temp = "<img src='"+r.sysFile.url+"' onclick='showFile("+r.sysFile.id+")' style='width: 50%;cursor: pointer;'>";
                            } else {
                                temp = '<img src="/img/backg01.jpg" style="width: 50%;cursor: pointer;" >';
                            }
                        }
                    });
                    return temp;
                }
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
            {
                field : 'updateTime',
                title : '修改时间'
            }
        ]
    });
}
function load4() {
    $('#exampleTable4').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/check/list", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize : 'outline',
        toolbar : '#exampleToolbar4',
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect : false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        paginationDetailHAlign:"right",
        //search : true, // 是否显示搜索框
        showColumns : false, // 是否显示内容下拉框（选择显示的列）
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: 10000,
                offset: 0,
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
                 field : 'checkTime',
                 title : '考核时间',
                 formatter: function (value, row, index) {
                     if (value != null) {
                         return value.substring(0, 11);
                     }
                     return '';
                 }
             },
             {
	                field : 'checkFileId',
	                title : '文件数',
	                width: '10%',
	                formatter : function(value, row, index) {
	                	if(value==null||value==""||value==undefined){
	                		return 0;
						}
	                	var fileIdList = value.split(",");
	                    return '<span style="color: #5dd2b7;cursor: pointer;" onclick="showFiles(\''+fileIdList+'\')">'+fileIdList.length+'</span>';
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
                 field : 'checkYear',
                 title : '考核年度'
             },
             {
                 field : 'checkGlass',
                 title : '考核等级'
             },
             
             
             
             {
                 field : 'checkWord',
                 title : '考核详情以及备注'
             },
         ]
     });
 }

function load5() {
    $('#exampleTable5').bootstrapTable({
        method : 'get', // 服务器数据的请求方式 get or post
        url : "/phry/rewards/list", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize : 'outline',
        toolbar : '#exampleToolbar5',
        striped : true, // 设置为true会有隔行变色效果
        dataType : "json", // 服务器返回的数据类型
        pagination : true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect : false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        paginationDetailHAlign:"right",
        //search : true, // 是否显示搜索框
        showColumns : false, // 是否显示内容下拉框（选择显示的列）
        sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        queryParams : function(params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: 10000,
                offset: 0,
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
                 field : 'rewardsPunishmentTime',
                 title : '奖惩时间',
                 formatter: function (value, row, index) {
                     if (value != null) {
                         return value.substring(0, 11);
                     }
                     return '';
                 }
             },
             {
                 field : 'rewardsFileId',
                 title : '文件数',
                 width: '10%',
                 formatter : function(value, row, index) {
                 	if(value==null||value==""||value==undefined){
                 		return 0;
 					}
                 	var fileIdList = value.split(",");
                     return '<span style="color: #5dd2b7;cursor: pointer;" onclick="showFiles(\''+fileIdList+'\')">'+fileIdList.length+'</span>';
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
function showFiles(fileIdList) {
    layer.open({
        type : 2,
        title : '文件',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : '/phry/party'+'/showFiles/'+fileIdList // iframe的url
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

function addRewards() {
	
	//1.通过抄id属性定位袭
      var userId = document.getElementById('userId').value;
      layer.open({
  		type : 2,
  		title : '增加',
  		maxmin : true,
  		shadeClose : false, // 点击遮罩关闭层
  		area : [ '100%', '100%' ],
  		content : '/phry/personFile/addOther/'+userId // iframe的url
  	});
  }
function addRewards2() {
	
	//1.通过抄id属性定位袭
      var userId = document.getElementById('userId').value;
      layer.open({
  		type : 2,
  		title : '增加',
  		maxmin : true,
  		shadeClose : false, // 点击遮罩关闭层
  		area : [ '100%', '100%' ],
  		content : '/phry/personFile/add/'+userId // iframe的url
  	});
  }
function load7() {
    $('#exampleTable7').bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : "/phry/personFile/list", // 服务器数据的加载地址
			//	showRefresh : true,
			//	showToggle : true,
			//	showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar7',
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
						 userId:$('#userId').val(),
						 style:1
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
								
							/*							{
							field : 'username', 
							title : '姓名' 
						},
														{
							field : 'idCard', 
							title : '身份证' 
						},*/
									
														{
							field : 'baogaoTime', 
							title : '报表时间' 
						},
														{
							field : 'year', 
							title : '年度时间' 
						},
						{
							field : 'fileName', 
							title : '文件名称' 
						},
						/*							{
							field : 'fileId', 
							title : '文件Id' 
						},*/	
						
									
						 {
			                 field : 'fileId',
			                 title : '文件数',
			                 width: '10%',
			                 formatter : function(value, row, index) {
			                 	if(value==null||value==""||value==undefined){
			                 		return 0;
			 					}
			                 	var fileIdList = value.split(",");
			                     return '<span style="color: #5dd2b7;cursor: pointer;" onclick="showFiles(\''+fileIdList+'\')">'+fileIdList.length+'</span>';
			                 }
			             }, ]
	});
}

function load6() {
    $('#exampleTable6').bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : "/phry/personFile/list", // 服务器数据的加载地址
			//	showRefresh : true,
			//	showToggle : true,
			//	showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar6',
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
						 userId:$('#userId').val(),
						 style:0
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
								
							/*							{
							field : 'username', 
							title : '姓名' 
						},
														{
							field : 'idCard', 
							title : '身份证' 
						},*/
									
						/*								{
							field : 'baogaoTime', 
							title : '报表时间' 
						},
														{
							field : 'year', 
							title : '年度时间' 
						},*/
						{
							field : 'fileName', 
							title : '文件名称' 
						},
						/*							{
							field : 'fileId', 
							title : '文件Id' 
						},*/				
						 {
			                 field : 'fileId',
			                 title : '文件数',
			                 width: '10%',
			                 formatter : function(value, row, index) {
			                 	if(value==null||value==""||value==undefined){
			                 		return 0;
			 					}
			                 	var fileIdList = value.split(",");
			                     return '<span style="color: #5dd2b7;cursor: pointer;" onclick="showFiles(\''+fileIdList+'\')">'+fileIdList.length+'</span>';
			                 }
			             }, ]
	});
}












