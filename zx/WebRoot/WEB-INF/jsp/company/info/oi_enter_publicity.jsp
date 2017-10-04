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
    <title>OI平台 - 企业版 - 企业宣传</title>
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
            <h5>企业宣传</h5>
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
                                <button data-target="oi_enter_publicity" type="button" class="table_tool_add btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                </button>
                                <button data-target="oi_enter_publicity" type="button" class="table_tool_delete btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                </button>
                            </div>
                            <table id="oi_enter_publicity" data-height="400" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="oi_type"></th>
                                    <th data-field="oi_type_id"></th>
                                    <th data-field="state" data-checkbox="true"></th>
                                    <th data-field="pub_Title">标题</th>
                                    <th data-field="pub_pic">图片地址</th>
                                    <th data-width="20%" data-field="startDate">开始日期</th>
                                    <th data-width="20%" data-field="endDate">结束日期</th>
                                    <th data-align="center" data-width="10%" data-field="pubStatus">状态</th>
                                    <th data-width="10%" data-field="pubSort">排序</th>
                                    <th data-width="10%" data-align="center" data-field="button">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="propaGanda" items="${listPropa }">
                                		<tr>
                                			<td data-field="oi_type">oi_enter_publicity</td>
                                    		<td data-field="oi_type_id">${propaGanda.p_id }</td>
                                			<td data-field="state" data-checkbox="true"></td>
		                                    <td data-field="pub_Title">${propaGanda.p_title }</td>
		                                    <td data-field="pub_pic">图片地址</td>
		                                    <td data-width="20%" id="create_time" data-field="startDate">${propaGanda.create_time }</td>
		                                    <td data-width="20%" id="end_time" data-field="endDate">${propaGanda.end_time }</td>
		                                    <td data-align="center" data-width="10%" data-field="pubStatus">
		                                    	${propaGanda.status}
		                                    	<%-- <c:if test="${propaGanda.status ==1}">已启用</c:if>
		                                    	<c:if test="${propaGanda.status !=1}">未启用</c:if> --%>
		                                    </td>
		                                    <td data-width="10%" data-field="pubSort">${propaGanda.o }</th>
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
<script type="text/javascript">
	$(function(){
		var create_time=$("#create_time");
		var create_data=Todate(create_time.html());
		create_time.html(create_data);
		
		var end_time=$("#end_time");
		var end_data=Todate(end_time.html());
		end_time.html(end_data);
	})
	function Todate(num)
	{
		//Fri Oct 31 18:00:00 UTC+0800 2008  
		num=num+"";
		var date="";
		var month=new Array();
		 month["Jan"]=1;month["Feb"]=2;month["Mar"]=3;month["Apr"]=4;month["May"]=5;month["Jan"]=6;
		month["Jul"]=7;month["Aug"]=8;month["Sep"]=9;month["Oct"]=10;month["Nov"]=11;month["Dec"]=12;
		var week=new Array();
		week["Mon"]="一";week["Tue"]="二";week["Wed"]="三";week["Thu"]="四";week["Fri"]="五";week["Sat"]="六";week["Sun"]="日";
		str=num.split(" ");
		date=str[5]+"-";
		date=date+month[str[1]]+"-"+str[2]+" "+str[3];
		//date=date+" 周"+week[str[0]];
		 return date;
}

var format = function(time, format)
{
	var t = new Date(time);
	var tf = function(i){return (i < 10 ? '0' : '') + i};
	return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
	switch(a){
	case 'yyyy':
	return tf(t.getFullYear());
	break;
	case 'MM':
	return tf(t.getMonth() + 1);
	break;
	case 'mm':
	return tf(t.getMinutes());
	break;
	case 'dd':
	return tf(t.getDate());
	break;
	case 'HH':
	return tf(t.getHours());
	break;
	case 'ss':
	return tf(t.getSeconds());
	break;
	}
	})
}
</script>
</body>
</html>
