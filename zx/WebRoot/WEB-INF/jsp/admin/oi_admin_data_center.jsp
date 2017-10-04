<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="<%=basePath%>">
<title>OI平台-数据中心</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/style.css?v=4.1.0"
	rel="stylesheet">
<style>
.echarts-box {
	min-height: 300px;
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<!--公司任务汇总图-->
					<div class="ibox-content">
						<div class="row">
							<!--企业入驻-->
							<div class="col-sm-6 echarts-box" id="enter_total_task"></div>
							<!--员工完成任务TOP10-->
							<div class="col-sm-6 echarts-box" id="enter_total_task_1"></div>
							<!--漏斗图-->
							<div class="col-sm-6 echarts-box" id="enter_total_task_2"></div>
							<!--公司整体任务完成情况-->
							<div class="col-sm-6 echarts-box" id="enter_total_task_3"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/echarts/echarts.js"></script>
	<script src="${pageContext.request.contextPath}/statics/js/china.js"></script>
	<script>
		var myChart = echarts.init(document.getElementById('enter_total_task')); //公司任务
		var myChart_2 = echarts.init(document.getElementById('enter_total_task_1')); //top10排名
		var myChart_3 = echarts.init(document.getElementById('enter_total_task_2')); //漏斗图
		var myChart_4 = echarts.init(document.getElementById('enter_total_task_3')); //漏斗图
		var option_1 = {
			title : {
				text : "入驻企业分类"
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			series : [
				{
					name : "任务状态占比",
					type : 'pie',
					radius : '55%',
					roseType : 'angle',
					data : [
						{
							value : 235,
							name : '信息咨询服务业'
						},
						{
							value : 274,
							name : '企业2'
						},
						{
							value : 310,
							name : '企业3'
						},
						{
							value : 335,
							name : '企业4'
						},
						{
							value : 400,
							name : '企业25'
						},
						{
							value : 400,
							name : '企业26'
						},
						{
							value : 400,
							name : '企业27'
						}
					],
					itemStyle : {
						normal : {
							shadowBlur : 200,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
			]
		};
		var option_2 = {
			title : {
				text : "企业分类"
			},
			tooltip : {
				trigger : 'axis'
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data : [ '信息咨询服务业', '企业2', '企业3', '企业4', '企业5', '企业6', '企业7', '企业8', '企业9' ]
			},
			yAxis : {
				type : 'value'
			},
			series : [ {
				type : 'line',
				smooth : true,
				data : [ 10, 12, 21, 54, 260, 830, 13, 14, 14 ] //数组的每个下标的值对应员工完成任务的总数
			} ]
		};
		var option_3 = {
			title : {
				text : '全国入驻企业数量',
				left : 'center'
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '入驻数' ]
			},
			visualMap : {
				min : 0,
				max : 2500,
				left : 'left',
				top : 'bottom',
				text : [ '高', '低' ], // 文本，默认为数值文本
				calculable : true
			},
			series : [
				{
					name : '入驻数',
					type : 'map',
					mapType : 'china',
					roam : false,
					label : {
						normal : {
							show : false
						},
						emphasis : {
							show : true
						}
					},
					data : [
						{
							name : '北京',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '天津',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '上海',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '河北',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '河南',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '云南',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '辽宁',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '黑龙江',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '湖南',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '山东',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '江苏',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '江西',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '湖北',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '广西',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '甘肃',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '山西',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '陕西',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '福建',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '贵州',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '广东',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '青海',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '四川',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '海南',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '香港',
							value : Math.round(Math.random() * 1000)
						},
						{
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						}
					]
				}
			]
		};
	
		var option_4 = {
			title : {
				text : '各公司实时任务统计'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : [ "完成", "进行" ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'value',
				boundaryGap : [ 0, 0.01 ]
			},
			yAxis : {
				type : 'category',
				data : [ "公司1", "公司1", "公司1", "公司1", "公司1", "公司1" ]
			},
			series : [
				{
					name : '完成',
					type : 'bar',
					data : [ 112, 162, 142, 112, 192, 122 ]
				},
				{
					name : '进行',
					type : 'bar',
					data : [ 11, 22, 33, 44, 55, 66 ]
				},
			]
		}
		myChart.setOption(option_1);
		myChart_2.setOption(option_2);
		myChart_3.setOption(option_3);
		myChart_4.setOption(option_4);
	</script>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/statics/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js?v=3.3.6"></script>
</body>
</html>
