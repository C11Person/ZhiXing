
$(function(){
	selectAllTaskByUserId();
});


function selectAllTaskByUserId() {
	$.ajax({
		type : "post", //请求类型
		url : "staff/selectAllTaskByUserId.json", //请求的url
		dataType : "json", //ajax接口（请求url）返回的数据类型
		success : function(data) { //data：返回数据（json对象）
			$("#weui-panel__bd1").html("");
			var table = "";
			for (var i = 0; i < data.length; i++) {
				table += "<a href='oi_staff_tsk_detail.html'><div task-status='" + data[i].task_status + "' class='weui-media-box weui-media-box_appmsg'><div class='weui-media-box__hd'><img class='weui-media-box__thumb' src=''></div><div class='weui-media-box__bd'><h4 class='weui-media-box__title'>"
					+ data[i].user_id
					+ "</h4><p class='weui-media-box__desc'>"
					+ "<h6>时间：" + data[i].task_start_time + "到 " + data[i].task_end_time + "</h6>"
					+ "<h6 class='task_content_ellipse'>"+data[i].task_title+"</h6></p>"; 
				if(data[i].task_status==5){
					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;'>取消</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='javascript:;'>提醒</a></li></ul>";
				}else if(data[i].task_status==3){
					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='"+data[i].task_status+"' task_id='"+data[i].task_id+"'>拒绝退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_tsk_detail.html?task_id="+data[i].task_id+"&typeId=2'>转发</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='javascript:;'>取消</a></li></ul>";
				}else if(data[i].task_status==4){
					table+="<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;'>取消</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='javascript:;'>催办</a></li></ul>";
				}
				
				
				table+="</div><span class='oi_sf_tsk_tips'></span></div></a>";
			}
			$("#weui-panel__bd1").html(table);
		},
		error : function(data) { //当访问时候，404，500 等非200的错误状态码
			alert("加载我发布的任务失败");
		}
	});
}