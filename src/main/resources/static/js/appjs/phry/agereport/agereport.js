
var prefix = "/phry/user"
$(function() {
    var deptId = '';

    load(deptId);
});

function load(deptId) {
    var myChart2 = echarts.init(document.getElementById('main2'));
    myChart2.showLoading();
    $.ajax({
        cache : true,
        type: "POST",
        url: "../phry/agereport/getreport",
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success: function(data){
             option  = {
                title : {
                    text: '年龄段数据分析',

                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    bottom: 10,
                    left: 'center',
                    data: ['0-20','21-30','31-40','41-50','51-60','61-70']
                },
                series : [
                    {
                        name: '年龄段',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:data.a1, name:'0-20',itemStyle: {color: '#5B9CD6'}},
                            {value:data.a2, name:'21-30',itemStyle: {color: '#ED7D31'}},
                            {value:data.a3, name:'31-40',itemStyle: {color: '#EE0000'}},
                            {value:data.a4, name:'41-50',itemStyle: {color: '#ADFF2F'}},
                            {value:data.a5, name:'51-60',itemStyle: {color: '#5E5E5E'}},
                            {value:data.a6, name:'61-70',itemStyle: {color: '#6E8B3D'}}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    },
                ]
            };
            myChart2.setOption(option);
            myChart2.hideLoading();
        }
    });
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}


function resetPwd(id) {
}



function loadTree(tree) {
    $('#jstree').jstree({
        'core' : {
            'data' : tree
        },
        "plugins" : [ "search" ]
    });
    $('#jstree').jstree().open_all();
}
$('#jstree').on("changed.jstree", function(e, data) {
    if (data.selected == -1) {
        var opt = {
            query : {
                deptId : '',
            }
        }
        $('#exampleTable').bootstrapTable('refresh', opt);
    } else {
        var opt = {
            query : {
                deptId : data.selected[0],
            }
        }
        $('#exampleTable').bootstrapTable('refresh',opt);
    }

});






















       
       

       
       
       
       
       
 