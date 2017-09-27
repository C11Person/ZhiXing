<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
       <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <title>个人信息 - 通讯录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/weui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/jquery-weui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/tsk_mobile.css"/>
    <script src="${pageContext.request.contextPath }/statics/js/echarts.min.js"></script>
  <style>
    .charts_container{
      width:90%;
      height:250px;
      transform:translateX(5.4%);
      margin:20px 0;
      background-color:#fff;
      box-shadow:0 2px 5px rgba(0,0,0,0.4);
      border-radius:5px;
      overflow:hidden;
    }
    #sf_data_container_echarts_1:before{
      content:"当前状态图(个人)";
    }
    #sf_data_container_echarts_2:before{
      content:"当月统计表(个人)";
    }
    .text_formate:before{
      display:block;
      width:100%;
      background-color:#666;
      color:#fff;
      text-align:center;
    }
  </style>
  </head>
  
  <body>
  	<!--员工个人表-->
    <div class="text_formate charts_container" id="sf_data_container_echarts_1"></div>
    <!--员工个人表结束-->
    <!--当月统计表-->
    <div class="text_formate charts_container" id="sf_data_container_echarts_2"></div>
    <!--当月统计表结束-->
    <!--页面底部导航-->
    <div class="staff_bottom_fixed">
        <div class="weui-tab">
            <div class="weui-tabbar">
                <a href="${pageContext.request.contextPath }/staff/oi_staff_msg.html" class="weui-tabbar__item weui-bar__item--on">
                    <span class="weui-badge" style="position: absolute;top: -.4em;right: 1em;">8</span>
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
                <a href="${pageContext.request.contextPath }/staff/oi_staff_task_center.html" class="weui-tabbar__item">
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
    <script>
      $(function(){
        var echart_1=echarts.init(document.getElementById("sf_data_container_echarts_1"));
        var option_chart_1 = {
          series: [
            {
              name:'访问来源',
              type:'pie',
              selectedMode: 'single',
              radius: [0, '30%'],
              label: {
                normal: {
                  position: 'inner'
                }
              },
              labelLine: {
                normal: {
                  show: false
                }
              },
              data:[  //中心数据
                {value:335, name:'接收', selected:true},
                {value:679, name:'进行'},
                {value:1548, name:'完成'}
              ]
            },
            {
              name:'访问来源',
              type:'pie',
              radius: ['40%', '55%'],
              data:[  //外部数据
                {value:335, name:'接收', selected:true},
                {value:679, name:'进行'},
                {value:1548, name:'完成'}
              ]
            }
          ]
        };
        var echart_2=echarts.init(document.getElementById("sf_data_container_echarts_2"));
        var option_chart_2 = {
          tooltip: {
            trigger: 'axis'
          },
          legend: {
            data:['进行','完成','总数']
          },
          xAxis:  {
            type: 'category',
            boundaryGap: false,
            data: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]
          },
          yAxis: {
            type: 'value'
          },
          series: [
            {
              name:'进行',
              type:'line',
              data:[11, 11, 15, 13, 12, 13, 10]
            },
            {
              name:'完成',
              type:'line',
              data:[1, -2, 2, 5, 3, 2, 0]
            },
            {
              name:'总数',
              type:'line',
              data:[10, 20, 5, 13, 11, 55, 0]
            }
          ]
        };
        echart_1.setOption(option_chart_1);
        echart_2.setOption(option_chart_2);
      })
    </script>
  </body>
</html>
