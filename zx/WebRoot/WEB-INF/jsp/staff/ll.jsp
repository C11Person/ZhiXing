<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   	<title>My JSP 'll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath }/statics/hplus/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/hplus/css/plugins/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/statics/hplus/css/demo/webuploader-demo.css">
<link
	href="${pageContext.request.contextPath }/statics/hplus/css/style.css?v=4.1.0"
	rel="stylesheet">
  </head>
  
  <body>
<input type="hidden" id="file" name="pic_URL">
                        <div class="page-container">
                            <div><input type="hidden" id="url" value="${pageContext.request.contextPath }/tupian/upload.do"> </div>
                            <div id="uploader" class="wu-example">
                            
                                <div class="queueList">
                                
                                    <div id="dndArea"  class="placeholder">
                                        <div id="filePicker"><img src="${propaganda.pic_URL}"></img></div>
                                        <p>或将照片拖到这里，单次最多可选300张</p>
                                    </div>
                                </div>
                                <div class="statusBar" style="display:none;">
                                    <div class="progress">
                                        <span class="text">0%</span>
                                        <span class="percentage"></span>
                                    </div>
                                    <div class="info"></div>
                                    <div class="btns">
                                        <div id="filePicker2"></div>
                                        <div class="uploadBtn">开始上传</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/bootstrap.min.js?v=3.3.6"></script>
	<!-- Web Uploader -->
	<script type="text/javascript">
		// 添加全局站点信息
		var BASE_URL = '${pageContext.request.contextPath }/statics/hplus/js/plugins/webuploader';
	</script>
	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/plugins/webuploader/webuploader.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/statics/hplus/js/demo/webuploader-demo.js"></script>

  </body>
</html>
