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
  <title>任务小评</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>

  </head>
  
  <body>
<div class="stuff_container evaluate">
  <form action="staff/evaluateTask.do" method="post">
  <input type="hidden" id="task_id" name="task_id" value="${companyTask.task_id}">
    <div class="weui-panel weui-panel_access">
      <div class="weui-panel__hd"><strong>${companyTask.task_title}</strong>的评价</div>
      <div class="weui-panel__bd">
        <a href="javascript:void(0);" class="weui-media-box weui-media-box_appmsg">
          <div class="weui-media-box__hd">
          </div>
          <div class="weui-media-box__bd">
            <h4 class="weui-media-box__title">${companyStaffer1.realname} ${companyStaffer1.dept_name} [${companyStaffer1.level_name}]</h4>
            <p class="weui-media-box__desc">你与${companyStaffer1.company_name}共同奋斗了${longtime}天</p>
            <ul class="weui-media-box__info">
              <li class="weui-media-box__info__meta">质量：${companyStaffer1.qualityavg}分</li>
              <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">效率：${companyStaffer1.efficiencyavg}分</li>
            </ul>
          </div>
        </a>
      </div>
    </div>
    <!--质量评价-->
    <div class="star_evaluate" id="quality_check">
      <ul>
        <li class="star"></li>
        <li class="star"></li>
        <li class="star"></li>
        <li class="star"></li>
        <li class="star"></li>
      </ul>
    </div>
    <!--效率评价-->
    <div class="star_evaluate" id="eta_check">
      <ul>
        <li class="star"></li>
        <li class="star"></li>
        <li class="star"></li>
        <li class="star"></li>
        <li class="star"></li>
      </ul>
    </div>
    <!--质量-->
    <input type="hidden" name="task_quality" id="star_evaluate_quality"/>
    <!--效率-->
    <input type="hidden" name="task_efficiency" id="star_evaluate_eta"/>
    <div class="weui-cells__title">留下你的简评</div>
    <div class="weui-cells weui-cells_form">
      <div class="weui-cell">
        <div class="weui-cell__bd">
          <textarea class="weui-textarea" name="task_evaluate" placeholder="请输入文本" rows="3"></textarea>
          <div class="weui-textarea-counter"><span>0</span>/200</div>
        </div>
      </div>
    </div>
    <div class="weui-cell">
      <button type="submit" class="weui-btn weui-btn_plain-default">评价</button>
    </div>
  </form>
</div>
<!--页面底部导航-->
    <div class="staff_bottom_fixed">
        <div class="weui-tab">
            <div class="weui-tabbar">
                <a href="${pageContext.request.contextPath }/staff/oi_staff_msg.html" class="weui-tabbar__item weui-bar__item--on">
                    <span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;" id="newsCount"></span>
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_dialog.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">消息</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_task_center.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_datetime.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">任务</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_publish.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_button.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">发布</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html" class="weui-tabbar__item">
                    <div class="weui-tabbar__icon">
                        <img src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_article.png" alt="">
                    </div>
                    <p class="weui-tabbar__label">统计</p>
                </a>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_info.html" class="weui-tabbar__item">
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
<script src="${pageContext.request.contextPath }/statics/js/oi_sf_msg.js"></script>
  </body>
</html>
