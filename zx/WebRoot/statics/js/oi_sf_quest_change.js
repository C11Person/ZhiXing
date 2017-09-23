jQuery(function(){
    /*时间选择*/
    $("#datetime-picker").datetimePicker();
    /*任务进度条*/
    $('#oi_sf_tsk_progress').slider(function (percent) {
        console.log(percent)
    });
    /*任务进度条结束*/
    questTo();
});
//部门成员加载
function questTo(){
    var html="";
    $.ajax({
        url:"data/oi_sf_branch.json",
        success:function(obj){
            console.log(obj);
            for(var i=0;i<obj.length;i++){
                var objL=obj[i];
                html+=`<option value="${objL.val}">${objL.name}</option>`;
            }
            $("#st_publicTo").find("#select1").html(html);
        }
    });
    $("#st_publicTo").on("change","#select1",function(){
        var html1="";
        var _self=$(this);
        var selData=_self.val();
        $.ajax({
            type:'post',
            url:"",
            data:{data:selData},
            success:function(msg){
                $.each(msg,function(index,value){
                    html1+=`<option value="${value.val}">${value.name}</option>`
                });
                $("#st_publicTo").find("#select2").html(html1);
            }
        })
    })
}