/**
 * Created by kemplaw on 2017/9/22.
 */
$(function(){
    /*按钮点击事件处理*/
    $("#sf_tsk_backlog,#sf_tsk_backlog_2,#sf_tsk_backlog_3").on("click",".weui-media-box__info__meta a",function(){
        var _self=$(this);
        var task_status=_self.attr("name");
        var task_id=_self.attr("task_id");
        var btnId=_self.text();
        /*拒绝退回*/
        switch(btnId){
            case "拒绝退回":
                console.log(_self);
                $.prompt({
                    title: '拒绝理由',
                    input:"请输入拒绝理由",
                    empty:false,
                    onOK: function (input) {
                        window.location.href="staff/oi_staff_return.html?task_id="+task_id+"&task_status="+task_status+"&task_reback_reasion="+input;
                    }
                });
            break;
            case "退回":
                console.log(_self);
                $.prompt({
                    title: '退回理由',
                    input:"请输入退回理由",
                    empty:false,
                    onOK: function (input) {
                        window.location.href="staff/oi_staff_return.html?task_id="+task_id+"&task_status="+task_status+"&task_reasion="+input;
                    }
                });
                break;
            case "取消":
                console.log(_self);
                $.confirm("确认取消？", function() {
                    //点击确认后的回调函数
                    $.ajax({
                        type:"post",
                        url:"",
                        data:"",
                        success:function(){
                            _self.parent().parent().parent().parent().remove();
                        }
                    })
                }, function() {
                    //点击取消后的回调函数
                });
                break;
            case "催办":
                console.log(_self);
                $.ajax({
                    type:"post",
                    url:"",
                    data:"",
                    success:function(msg){
                        if(msg==1){
                            $.alert("催办成功");
                        }else{
                            $.alert("催办失败");
                        }
                    }
                });
                break;
            case "提醒":
                console.log(_self);
                $.ajax({
                    type:"post",
                    url:"",
                    data:"",
                    success:function(msg){
                        if(msg==1){
                            $.alert("提醒成功");
                        }else{
                            $.alert("提醒失败");
                        }
                    }
                });
                break;
            case "投票":
                console.log(_self);
                $.ajax({
                    type:"post",
                    url:"",
                    data:"",
                    success:function(msg){
                        if(msg==1){
                            $.alert("投票成功");
                        }else{
                            $.alert("投票失败");
                        }
                    }
                });
                break;
        }
    })
    /*按钮点击事件处理 结束*/
});