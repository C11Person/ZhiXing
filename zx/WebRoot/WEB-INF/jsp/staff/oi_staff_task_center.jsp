<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath }/statics/images/apple-touch-icon.png" />
<link rel="apple-touch-startup-image"
	href="${pageContext.request.contextPath }/statics/images/apple-touch-startup-image-320x460.png" />
<title>个人信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/weui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css" />
</head>

<body>
	<div class="stuff_container">
		<!--搜索栏部分-->
		<div class="weui-search-bar" id="searchBar">
			<form class="weui-search-bar__form">
				<div class="weui-search-bar__box">
					<i class="weui-icon-search"></i> <input type="search"
						class="weui-search-bar__input" id="searchInput" placeholder="搜索"
						required=""> <a href="javascript:" class="weui-icon-clear"
						id="searchClear"></a>
				</div>
				<label class="weui-search-bar__label" id="searchText"> <i
					class="weui-icon-search"></i> <span>搜索</span>
				</label>
			</form>
			<a href="javascript:" class="weui-search-bar__cancel-btn"
				id="searchCancel">取消</a>
			<!--分类搜索-->
			<span class="classify-box weui-tabbar__icon"></span>
			<!--分类搜索 结束-->
		</div>
		<!--搜索栏部分 结束-->
		<!--搜索分类内容盒子-->
		<div class="weui-cells page__category-content"
			id="page_cateGory_container" style="display:none;">
			<a cate-type="1" search-type="0"
				class="weui-cell weui-cell_access js_item" data-id="button"
				href="此处填写对应url">
				<div class="weui-cell__bd">
					<p>全部</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a> 
			<a cate-type="1" search-type="1"
				class="weui-cell weui-cell_access js_item" data-id="button"
				href="此处填写对应url">
				<div class="weui-cell__bd">
					<p>已取消</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a> <a cate-type="1" search-type="2"
				class="weui-cell weui-cell_access js_item" data-id="button"
				href="此处填写对应url">
				<div class="weui-cell__bd">
					<p>已完成</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a> <a cate-type="1" search-type="3"
				class="weui-cell weui-cell_access js_item" data-id="input"
				href="javascript:;">
				<div class="weui-cell__bd">
					<p>已退回</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a> <a cate-type="1" search-type="4"
				class="weui-cell weui-cell_access js_item" data-id="list"
				href="javascript:;">
				<div class="weui-cell__bd">
					<p>进行中</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a> <a cate-type="1" search-type="5"
				class="weui-cell weui-cell_access js_item" data-id="slider"
				href="javascript:;">
				<div class="weui-cell__bd">
					<p>待接收</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a> <a cate-type="1" search-type="6"
				class="weui-cell weui-cell_access js_item" data-id="uploader"
				href="javascript:;">
				<div class="weui-cell__bd">
					<p>待评价</p>
				</div>
				<div class="weui-cell__ft"></div>
			</a>
		</div>
		<!--搜索分类内容盒子 结束-->
		<!--页面顶部导航部分-->
		<div class="weui-tab" id="sf_task_center_navbar">
			<div class="weui-navbar">
				<a task-type="tab1" class="weui-navbar__item weui-bar__item--on"
					href="#tab1"> 我发布的 </a> <a task-type="tab2"
					class="weui-navbar__item" href="#tab2"> 我接收的 </a>
			</div>
			<div class="weui-tab__bd">
				<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
					<div class="weui-panel weui-panel_access" id="sf_tsk_backlog">
						<div class="weui-panel__bd" id="weui-panel__bd1">
							<!--以下是状态分级-->
							<!--状态一：已取消-->
							<!-- <a href="oi_staff_tsk_detail.html">
                                <div task-status="1" class="weui-media-box weui-media-box_appmsg">
                                    任务详情链接
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 取消</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态一：已取消 - 结束
                            状态二：已完成
                            <a href="oi_staff_tsk_detail.html">
                                <div task-status="2" class="weui-media-box weui-media-box_appmsg">
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 完成</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态二：已完成 结束
                            状态三：已退回
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
                                                <a href="javascript:;">拒绝退回</a>
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
                                                <a href="javascript:;">取消</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="javascript:;">催办</a>
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
                                                <a href="javascript:;">取消</a>
                                            </li>
                                            <li class="weui-media-box__info__meta weui-media-box__info__meta_extra">
                                                <a href="javascript:;">提醒</a>
                                            </li>
                                        </ul>
                                        员工两项评分结束
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a> -->
							<!--状态五：待接收 结束-->
						</div>
					</div>
				</div>
				<div id="tab2" class="weui-tab__bd-item">
					<div class="weui-panel weui-panel_access" id="sf_tsk_backlog_2">
						<div class="weui-panel__bd" id="weui-panel__bd2">
							<!--以下是状态分级-->
							<!--状态一：已取消-->
							<!--  <a href="oi_staff_tsk_detail.html">
                                <div task-status="1" class="weui-media-box weui-media-box_appmsg">
                                    任务详情链接
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 取消</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态一：已取消 - 结束
                            状态二：已完成
                            <a href="oi_staff_tsk_detail.html">
                                <div task-status="2" class="weui-media-box weui-media-box_appmsg">
                                    员工头像
                                    <div class="weui-media-box__hd">
                                        <img class="weui-media-box__thumb" src="">
                                    </div>
                                    员工头像 结束
                                    员工信息
                                    <div class="weui-media-box__bd">
                                        员工姓名
                                        <h4 class="weui-media-box__title">员工甲 完成</h4>
                                        员工姓名结束
                                        员工信息详细
                                        <p class="weui-media-box__desc">
                                            任务时间
                                        <h6>时间：2011-11-11 9:30 到 2011-11-11 9:30</h6>
                                        任务内容
                                        <h6 class="task_content_ellipse">清理门外杂草清理门外杂草清理门外杂草</h6>
                                        </p>
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a>
                            状态二：已完成 结束
                            状态三：已退回
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
                                                <a href="oi_staff_edit.html">接受</a>
                                            </li>
                                        </ul>
                                        员工两项评分结束
                                        员工信息详细结束
                                    </div>
                                    员工信息 结束
                                    任务状态
                                    <span class="oi_sf_tsk_tips"></span>
                                </div>
                            </a> -->
							<!--状态五：待接收 结束-->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--页面顶部导航部分结束-->
	</div>
	<!--页面底部导航-->
	<div class="staff_bottom_fixed">
		<div class="weui-tab">
			<div class="weui-tabbar">
				<a
					href="${pageContext.request.contextPath }/staff/oi_staff_msg.html"
					class="weui-tabbar__item weui-bar__item--on"> <span
					class="weui-badge"
					style="position: absolute;top: -.4em;right: 1em;" id="newsCount"></span>
					<div class="weui-tabbar__icon">
						<img
							src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_dialog.png"
							alt="">
					</div>
					<p class="weui-tabbar__label">消息</p>
				</a> <a
					href="${pageContext.request.contextPath }/staff/oi_staff_task_center.html"
					class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img
							src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_datetime.png"
							alt="">
					</div>
					<p class="weui-tabbar__label">任务</p>
				</a> <a
					href="${pageContext.request.contextPath }/staff/oi_staff_publish.html"
					class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img
							src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_button.png"
							alt="">
					</div>
					<p class="weui-tabbar__label">发布</p>
				</a> <a
					href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html"
					class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img
							src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_article.png"
							alt="">
					</div>
					<p class="weui-tabbar__label">统计</p>
				</a> <a
					href="${pageContext.request.contextPath }/staff/oi_staff_info.html"
					class="weui-tabbar__item">
					<div class="weui-tabbar__icon">
						<img
							src="${pageContext.request.contextPath }/statics/images/icons/icon_nav_cell.png"
							alt="">
					</div>
					<p class="weui-tabbar__label">我</p>
				</a>
			</div>
		</div>
	</div>
	<!--页面底部导航结束-->
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/jquery-weui.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_sf_msg.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/staff_to_areceive_task.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/staff_release_task.js"></script>
	<script
		src="${pageContext.request.contextPath }/statics/js/oi_staff_allpage.js"></script>
	<script>
		$(function() {
			$("#sf_task_center_navbar").on("click", "[task-type]", function(e) {
				e.preventDefault();
				var self = $(this),
					task_type = self.attr("task-type"); //当前标签页的属性
				var cates = $("#page_cateGory_container").find("[cate-type]"); //六个分类按钮
				if (task_type === 'tab1') { //如果是我发布的
					cates.attr("cate-type", 1);
				} else if (task_type === 'tab2') { //如果是我接受的
					cates.attr("cate-type", 2);
				}
			});
			$("#page_cateGory_container").on("click", "a.js_item", function(e) {
				e.preventDefault();
				var self = $(this),
					cate_type = self.attr("cate-type"), //标签名
					search_type = self.attr("search-type"); //分类名
				alert(cate_type);
				$.ajax({
					type : "post",
					url : "staff/selectTaskByTaskStatus.json",
					data : {
						"type" : cate_type,
						"task_status" : search_type
					},
					success : function(data) {
						if (cate_type == 1) {
							$("#weui-panel__bd1").html("111");
							var table = "";
							console.log(data);
							 for (var i = 0; i < data.length; i++) {
								table += "<a href='staff/oi_staff_tsk_detailUser.html?task_id=" + data[i].task_id + "&task_status=" + data[i].task_status + "'><div task-status='" + data[i].task_status + "' class='weui-media-box weui-media-box_appmsg'><div class='weui-media-box__hd'><img class='weui-media-box__thumb' src=''></div><div class='weui-media-box__bd'><h4 class='weui-media-box__title'>"
									+ data[i].realname
									+ "</h4><p class='weui-media-box__desc'>"
									+ "<h6>时间：" + data[i].task_start_time + "到 " + data[i].task_end_time + "</h6>"
									+ "<h6 class='task_content_ellipse'>" + data[i].task_title + "</h6></p>";
								if (data[i].task_status == 5) {
									table += "<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' task_id='" + data[i].task_id + "'>取消</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='javascript:;'>提醒</a></li></ul>";
								} else if (data[i].task_status == 3) {
									table += "<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='" + data[i].task_status + "' task_id='" + data[i].task_id + "'>拒绝退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_tsk_detailUser.html?task_id=" + data[i].task_id + "&task_status=" + data[i].task_status + "'>转发</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='javascript:;'>取消</a></li></ul>";
								} else if (data[i].task_status == 4) {
									table += "<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' task_id='" + data[i].task_id + "'>取消</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='javascript:;'>催办</a></li></ul>";
								} else if (data[i].task_status == 6) {
									table += "<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='staff/oi_staff_evaluate.html?task_id=" + data[i].task_id + "&to_user=" + data[i].to_user + "'>评价</a></li></ul>";
								}
	
	
								table += "</div><span class='oi_sf_tsk_tips'></span></div></a>";
							}
							$("#weui-panel__bd1").html(table); 
						} else {
							$("#weui-panel__bd2").html("");
							var table = "";
							for (var i = 0; i < data.length; i++) {
								table += "<a href='staff/oi_staff_tsk_detailToUser.html?task_id=" + data[i].task_id + "&task_status=" + data[i].task_status + "'><div task-status='" + data[i].task_status + "' class='weui-media-box weui-media-box_appmsg'><div class='weui-media-box__hd'><img class='weui-media-box__thumb' src=''></div><div class='weui-media-box__bd'><h4 class='weui-media-box__title'>"
									+ data[i].realname
									+ "</h4><p class='weui-media-box__desc'>"
									+ "<h6>时间：" + data[i].task_start_time + "到 " + data[i].task_end_time + "</h6>"
									+ "<h6 class='task_content_ellipse'>" + data[i].task_title + "</h6></p>";
	
								if (data[i].task_status == 5) {
									table += "<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='" + data[i].task_status + "' task_id='" + data[i].task_id + "'>退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_edit.html?task_id=" + data[i].task_id + "&task_status=" + data[i].task_status + "'>接受</a></li></ul>";
								} else if (data[i].task_status == 4) {
									table += "<ul class='weui-media-box__info'><li class='weui-media-box__info__meta'><a href='javascript:;' name='" + data[i].task_status + "' task_id='" + data[i].task_id + "'>退回</a></li><li class='weui-media-box__info__meta weui-media-box__info__meta_extra'><a href='staff/oi_staff_tsk_detailToUser.html?task_id=" + data[i].task_id + "&task_status=" + data[i].task_status + "'>编辑</a></li></ul>";
								}
	
	
								table += "</div><span class='oi_sf_tsk_tips'></span></div></a>";
							}
							$("#weui-panel__bd2").html(table);
						}
					},
					error : function(msg) {
						$.alert("失败！");
					}
				})
			})
		})
	</script>
</body>
</html>
