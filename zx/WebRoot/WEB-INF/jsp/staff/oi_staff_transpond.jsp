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
    <title>任务转发</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>

  </head>
  
  <body>
   	<div class="stuff_container">
        <form id="task_release_container2">
            <!--任务级别单选部分：是否紧急-->
            <div class="weui-cells__title">任务标题</div>
            <div class="weui-cells weui-cells_form">
                <!--标题填写-->
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <input class="weui-input" type="number"  placeholder="测试任务" disabled>
                    </div>
                </div>
                <!--标题填写结束-->
            </div>
            <!--截止时间选择-->
            <div class="weui-cells__title">截止时间</div>
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <input class="weui-input" id="datetime-picker" type="text" value="2012-12-12 12:13" readonly="">
                    </div>
                </div>
            </div>
            <!--截止时间结束-->
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
            <!--任务留言-->
            <div class="weui-cells__title">任务留言</div>
            <div class="weui-cells weui-cells_form">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea class="weui-textarea" name="" placeholder="此处留下任务留言" rows="3"></textarea>
                        <div class="weui-textarea-counter"><span>0</span>/200</div>
                    </div>
                </div>
            </div>
            <!--任务留言结束-->
            <!--提交按钮-->
            <div class="form_submit_button">
                <a href="javascript:;" class="weui-btn weui-btn_primary">确认无误，提交</a>
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
    <script src="${pageContext.request.contextPath }/statics/js/oi_sf_quest_change.js"></script>
  </body>
</html>
