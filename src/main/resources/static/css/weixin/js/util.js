/**
 * Created by wangj on 2018/9/21.
 */

function reloadleavelist(){
    console.log(1)
    $.ajax({
        url:"cyt/dmleaveinfo/list",
        data:{
            page : 1,
            limit : 10
        },
        success:function(r){
            var data = eval("("+r+")");
            if(data.code == 0){
                var infos = data.page.list;

                var haveData = '';
                if(data.if_have_data == 0){
                    haveData = '<div class="js-load-more" id="loadMore" onclick="loadMore()">点击加载更多</div>';
                }else if(data.if_have_data == 1){
                    haveData = '<div class="js-load-nomore" id="haveLoadMore">数据已完全加载</div>';
                }

                if(infos == null || infos == ''){
                    haveData = '<div class="js-load-more">暂无数据</div>';
                    $("#dataDiv").after(
                        haveData
                    )
                }else{
                    for(var i=0;i<infos.length;i++){
                        var info = infos[i];
                        if(info.sysDeptName == null){
                            info.sysDeptName = '';
                        }
                        var infostatus = '';
                        if(info.leaveStatus == 0){
                            infostatus = '<span class="yellow">开立</span>';
                        }else if(info.leaveStatus == 1){
                            infostatus = '<span class="blue">审核中</span>';
                        }else if(info.leaveStatus == 2){
                            infostatus = '<span class="red">审核不通过</span>';
                        }else if(info.leaveStatus == 3){
                            infostatus = '<span class="green">审核通过</span>';
                        }
                        $("#dataUrl").append(
                            '<li>' +
                            '<div class="list_box" onclick="detail('+info.leaveId+')" >' +
                            '<div class="info_list_f">' +
                            '<div class="info_list_f_l">'+info.sysUserName+'</div>' +
                            '<div class="info_list_f_m">部门：'+info.sysDeptName+'</div>' +
                            '<div class="info_list_f_r">创建时间 ：'+info.createTime+'</div>' +
                            '</div>' +
                            '<div class="info_list_s">' +
                            '<div class="info_list_s_l">请假时间：'+info.leaveStartTime+'&nbsp;至&nbsp;'+info.leaveEndTime+'</div>' +
                            '<div class="info_list_s_r">'+infostatus+'</div>' +
                            '</div>' +
                            '</div>' +
                            '</li>'
                        )
                    }
                    $("#dataDiv").after(
                        haveData+
                        '<input type="hidden" id="currPage" value="'+data.page.currPage+'" >'
                    )
                }
            }
        }
    })
}