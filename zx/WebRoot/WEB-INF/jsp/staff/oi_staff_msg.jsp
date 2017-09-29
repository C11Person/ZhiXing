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
    <title>消息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>

  </head>
  
  <body>
   	<div class="stuff_container">
        <!--标题-->
        <div class="weui-tab">
            <div class="weui-navbar">
                <!--企业公告-->
                <a class="weui-navbar__item weui-bar__item--on" href="#oi_enter_pub">
                    企业公告
                </a>
                <!--待办任务-->
                <a class="weui-navbar__item" href="#oi_task_wait">
                    待办任务
                </a>
                <!--晋级投票-->
                <a class="weui-navbar__item" href="#oi_rank_vote">
                    晋级投票
                </a>
            </div>
            <div class="weui-tab__bd">
                <!--企业公告-->
                <div id="oi_enter_pub" class="weui-tab__bd-item weui-tab__bd-item--active">
                    <!--个人信息图文组合-->
                    <div class="weui-panel__bd" id="weui-panel__bd">
                       <!--  <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div>
                        <div class="weui-media-box weui-media-box_text">
                            <h5 class="weui-media-box__title"><a href="oi_staff_msgDetail.html">公司发布重要公告：通知。。。。</a></h5>
                            <p class="weui-media-box__desc">发布时间：2011-11-11 9:30</p>
                        </div> -->
                    </div>
                    <!--个人信息图文组合 结束-->
                </div>
                <!--待办任务-->
                <div id="oi_task_wait" class="weui-tab__bd-item">
                    <div class="weui-panel weui-panel_access">
                        <div class="weui-panel__bd" id="sf_tsk_backlog">
                            <!--以下是状态分级-->
<!--                             状态三：已退回
                            <a href="oi_staff_tsk_detail.html">
                                <div task-status="3" class="weui-media-box weui-media-box_appmsg">
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 退回</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工两项评分
                                        <ul class="weui-media-box__info">
                                            <li class="weui-media-box__info__meta">
                                                <a href="javascript:;" dataTsk-type="sf_tsk_refuse">拒绝退回</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="oi_staff_transpond.html">转发</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="javascript:;">取消</a>
                                            </li>
                                        </ul>
                                        员工两项评分结束
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态三：已退回 结束
                            状态四：进行中
                            <a href="oi_staff_tsk_detail.html">
                                <div task-status="4" class="weui-media-box weui-media-box_appmsg">
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 进行</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工两项评分
                                        <ul class="weui-media-box__info">
                                            <li class="weui-media-box__info__meta">
                                                <a href="javascript:;">退回</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="oi_staff_edit.html">编辑</a>
                                            </li>
                                        </ul>
                                        员工两项评分结束
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态四：进行中 结束
                            状态五：待接收
                            <a href="oi_staff_tsk_detail.html">
                                <div task-status="5" class="weui-media-box weui-media-box_appmsg">
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 待接收</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工两项评分
                                        <ul class="weui-media-box__info">
                                            <li class="weui-media-box__info__meta">
                                                <a href="javascript:;">退回</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="oi_staff_edit.html">接收</a>
                                            </li>
                                        </ul>
                                        员工两项评分结束
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态五：待接收 结束 -->
                        </div>
                    </div>
                </div>
                <!--晋级投票-->
                <div id="oi_rank_vote" class="weui-tab__bd-item" data-vote="3">
                    <div class="weui-panel weui-panel_access" id="sf_tsk_backlog_3">
                        <!--晋级投票员工列表-->
                        <a href="#">
                            <div class="weui-panel__bd">
                                <div  class="weui-media-box weui-media-box_appmsg">
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    <div class="weui-media-box__bd">
                                        <h4 class="weui-media-box__title">
                                            <span>员工甲</span>
                                            <small>技术部-主管</small>
                                        </h4>
                                        <!--投票数值-->
                                        <div class="weui-slider-box">
                                            <div class="weui-slider">
                                                <div class="weui-slider__inner">
                                                    <div style="width: 75%;" class="weui-slider__track"></div>
                                                </div>
                                            </div>
                                            <div class="weui-slider-box__value">75</div>
                                        </div>
                                        <!--投票数值 结束-->
                                        <!--目标职位-->
                                        <ul class="weui-media-box__info">
                                            <li class="weui-media-box__info__meta">目标：经理</li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">支持人数：592</li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="javascript:;" class="font_strong">投票</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="javascript:;" class="font_strong">反对</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </a>
                        <!--晋级投票员工列表 结束-->
                        <a href="#">
                            <div class="weui-panel__bd">
                                <div  class="weui-media-box weui-media-box_appmsg">
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    <div class="weui-media-box__bd">
                                        <h4 class="weui-media-box__title">
                                            <span>员工甲</span>
                                            <small>技术部-主管</small>
                                        </h4>
                                        <!--投票数值-->
                                        <div class="weui-slider-box">
                                            <div class="weui-slider">
                                                <div class="weui-slider__inner">
                                                    <div style="width: 75%;" class="weui-slider__track"></div>
                                                </div>
                                            </div>
                                            <div class="weui-slider-box__value">75</div>
                                        </div>
                                        <!--投票数值 结束-->
                                        <!--目标职位-->
                                        <ul class="weui-media-box__info">
                                            <li class="weui-media-box__info__meta">目标：经理</li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">支持人数：592</li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="javascript:;" class="font_strong">投票</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
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
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_msg.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>
   
  </body>
</html>
