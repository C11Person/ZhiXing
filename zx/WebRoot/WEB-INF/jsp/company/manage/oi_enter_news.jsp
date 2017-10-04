<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI平台 - 企业版 - 企业新闻</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico">
     <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>企业新闻</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#">选项1</a>
                    </li>
                    <li><a href="#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <div class="example-wrap">
                        <div class="example">
                            <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                <button data-target="oi_enter_news_01" type="button" class="table_tool_add btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                </button>
                                <button data-target="oi_enter_news_01" type="button" class="table_tool_delete btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                </button>
                            </div>
                            <table id="oi_enter_news_01" data-height="400" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-align="center" data-field="oi_type"></th>
                                    <th data-align="center" data-field="oi_type_id"></th>
                                    <th data-align="center" data-field="state" data-checkbox="true"></th>
                                    <th data-align="center" data-field="news_title">标题</th>
                                    <th data-align="center" data-field="news_post">发布人</th>
                                    <th data-align="center" data-field="news_content">内容</th>
                                    <th data-align="center" data-field="news_status">状态</th>
                                    <th data-align="center" data-field="news_time">时间</th>
                                    <th data-width="10%" data-align="center" data-field="button">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="news" items="${listNews }">
	                                	 <tr>
		                                    <td data-align="center" data-field="oi_type">oi_enter_news_01</td>
		                                    <td data-align="center" data-field="oi_type_id">${news.new_id }</td>
		                                    <td data-align="center" data-field="state" data-checkbox="true"></td>
		                                    <td data-align="center" data-field="news_title">${news.title }</td>
		                                    <td data-align="center" data-field="news_post">${news.content }</td>
		                                    <td data-align="center" data-field="news_content">${news.author }</td>
		                                    <td data-align="center" data-field="news_status">${news.status }</td>
		                                    <td data-align="center" data-field="news_time">${news.create_time }</td>
		                                    <td data-width="10%" data-align="center" data-field="button"></td>
		                                </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- End Example Events -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath }/statics/js/content.js?v=1.0.0"></script>
<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath }/statics/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- Peity -->
<script src="${pageContext.request.contextPath }/statics/js/plugins/layer/layer.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/demo/oi_admin_table.js"></script>
</body>
</html>
