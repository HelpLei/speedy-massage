
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
        url: "../phry/workreport/getreport",
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success: function(data){
            option = {
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ['0-3年','4-5年', '6-9年','10年以上'],
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'人数',
                        type:'bar',
                        barWidth: '30%',
                        data:[data.a1, data.a2, data.a3, data.a4]
                    }
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






















       
       

       
       
       
       
       
 