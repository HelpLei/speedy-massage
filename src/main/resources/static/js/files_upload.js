function uploader(dem){
    $("#"+dem).click();
}
function delfile(e) {
    var id=$(e).parent().data('id');
    $(e).parent().remove();
    $.ajax({
        url: "/common/sysFile/remove",
        type: "post",
        data: {
            'id': id
        },
        success: function (r) {

        }
    });
}
function upload(dem){
    if($("#"+dem)[0].files[0]) {
        var dataForm = new FormData();
        dataForm.append("file", $("#" + dem)[0].files[0]);
        $.ajax({
            cache: true,
            type: "POST",
            url: "/common/sysFile/uploadFile",
            data:dataForm ,
            async: false,
            processData: false,
            contentType: false,
            error: function (request) {
                parent.layer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    var list = $("#" + dem).next();
                    list.append(" <div class='childfile' style='margin-top: 5px;' data-id='" + data.id + "'>\n" +
                        "               <input name='url'  class='contract_url layui-input '  style='width: calc(100% - 50px);display: initial;' readonly value='" + data.name + "'>\n" +
                        "               <img src='/img/sc.png'  style='width: 30px;'  title='删除附件' onclick='delfile(this)' />\n" +
                        "          </div>");
                } else {
                    layer.msg(data.msg);
                }

            }
        });
        $("#"+dem).val();
    }
}
