
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
		type : "POST",
		url : "/phry/user/sexreportList",
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
		/*if (r.code == 0) {*/
	option = {
		    title : {
		        text: '性别对比',
		        subtext: '性别',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
                bottom: 10,
		        left: 'center',
		        data: ['男性','女性']
		    },
		    series : [
		        {
		            name: '性别',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:data.man, name:'男性',itemStyle: {color: '#5B9CD6'}},
		                {value:data.woman, name:'女性',itemStyle: {color: '#EE0000'}}
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
	 myChart2.setOption(option);
	 myChart2.hideLoading();
		    /*    }*/
		    }
		})
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