<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>任务发布</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>

  </head>
<body>
	<div class="stuff_container">
        <form id="task_release_container">
            <!--任务级别单选部分：是否紧急-->
            <div class="weui-cells__title">任务标题</div>
            <div class="weui-cells weui-cells_form">
                <!--标题填写-->
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number"  placeholder="请输入任务标题">
                    </div>
                </div>
                <!--标题填写结束-->
            </div>
            <!--发布对象选择-->
            <div class="weui-cells__title">发布对象</div>
            <div class="weui-cells" id="st_publicTo">
                <div class="weui-cell weui-cell_select">
                    <div class="weui-cell__bd weui-flex">
                        <select class="weui-select weui-flex__item" name="select1" id="select1">
                            <option selected value="0">请选择发布对象</option>
                        </select>
                        <select class="weui-select weui-flex__item" name="select2" id="select2">
                            <option selected value="0">请选择发布对象</option>
                        </select>
                    </div>
                </div>
            </div>
            <!--发布对象结束-->
            <!--任务截止时间-->
            <div class="weui-cells__title">任务截止时间</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__hd"><label for="task_time" class="weui-label">时间</label></div>
                    <div class="weui-cell__bd">
                        <input class="weui-input" id="task_time" type="datetime-local" value="" placeholder="请输入任务截止时间">
                    </div>
                </div>
            </div>
            <!--任务时间结束-->
            <!--任务级别单选部分：是否紧急-->
            <div class="weui-cells__title">任务紧急</div>
            <div class="weui-cells weui-cells_radio">
                <!--任务级别：一般-->
                <label class="weui-cell weui-check__label" for="x11">
                    <div class="weui-cell__bd">
                        <p>一般</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="radio1" id="x11">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <!--任务级别：一般 结束-->
                <!--任务级别：紧急-->
                <label class="weui-cell weui-check__label" for="x12">

                    <div class="weui-cell__bd">
                        <p>紧急</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" name="radio1" class="weui-check" id="x12" checked="checked">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <!--任务级别：紧急 结束-->
            </div>
            <!--任务级别单选部分 结束-->
            <!--任务级别单选部分：是否重要-->
            <div class="weui-cells__title">任务重要</div>
            <div class="weui-cells weui-cells_radio">
                <!--任务级别：一般-->
                <label class="weui-cell weui-check__label" for="x13">
                    <div class="weui-cell__bd">
                        <p>一般</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="radio2" id="x13">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <!--任务级别：一般 结束-->
                <!--任务级别：紧急-->
                <label class="weui-cell weui-check__label" for="x14">
                    <div class="weui-cell__bd">
                        <p>重要</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" name="radio2" class="weui-check" id="x14" checked="checked">
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <!--任务级别：紧急 结束-->
            </div>
            <!--任务级别单选部分 结束-->
            <!--任务描述部分-->
            <div class="weui-cells__title">任务描述</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" placeholder="请输入描述" rows="3"></textarea>
                        <div class="weui-textarea-counter"><span>0</span>/200</div>
                    </div>
                </div>
            </div>
            <!--任务描述部分结束-->
            <!--上传任务图片部分-->
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <div class="weui-uploader">
                            <div class="weui-uploader__hd">
                                <p class="weui-uploader__title">图片上传</p>
                                <div class="weui-uploader__info">0/2</div>
                            </div>
                            <div class="weui-uploader__bd">
                                <ul class="weui-uploader__files" id="uploaderFiles">
                                </ul>
                                <div class="weui-uploader__input-box">
                                    <input id="uploaderInput" class="weui-uploader__input" type="file" accept="image/*" multiple="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--上传人物图片部分结束-->
            <!--提交按钮-->
            <div class="form_submit_button">
                <a href="javascript:;" id="oi_quest_submit_btn" class="weui-btn weui-btn_primary">确认无误，发布</a>
            </div>
            <!--提交按钮结束-->
        </form>
    </div>
    <!--页面底部导航-->
    <div class="staff_bottom_fixed">
        <div class="weui-tab">
            <div class="weui-tabbar">
                <a href="oi_staff_msg.html" class="weui-tabbar__item weui-bar__item--on">
                    <span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;">8</span>
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_dialog.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">消息</p>
                </a>
                <a href="oi_staff_task_center.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_datetime.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">任务</p>
                </a>
                <a href="oi_staff_publish.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_button.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">发布</p>
                </a>
                <a href="oi_staff_data_center.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_article.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">统计</p>
                </a>
                <a href="oi_staff_info.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_cell.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">我</p>
                </a>
            </div>
        </div>
    </div>
    <!--页面底部导航结束-->
    <script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/jquery-weui.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/oi_sf_quest_pub.js"></script>
    <script>
        jQuery(function(){
            /*doSomethings*/
//            发布任务ajax表单提交
            $("#oi_quest_submit_btn").click(function(){
                var formData=$("#task_release_container").serialize();
                alert(formData);
                $.ajax({
                    type:'post',
                    url:"发送任务发布数据到后台",
                    data:formData,
                    success:function(msg){
                        /*发送成功之后要做的事情*/
                    }
                })
            })
        })
    </script>
</body>
</html>
