<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OI平台-企业版-企业信息</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/
    css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/
    css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/
    css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/
    css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>企业信息设置 <small>请确认所有选项填写无误</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_basic.html#">选项1</a>
                                </li>
                                <li><a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <!--表单正文-->
                    <div class="ibox-content">
                        <form action="${pageContext.request.contextPath }/company/message/updateMessage.html" method="post" class="form-horizontal" enctype="multipart/form-data">
                           	<!-- 企业ID -->
                           	<input type="hidden" value="${Message.m_id }" name="m_id">
                            <!--企业名称-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">企业名称</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.company_name }" name="company_name" class="form-control" placeholder="请填写企业名称">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--企业分类-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="typeSelector">企业分类</label>
                                <div class="col-sm-8">
                                    <select class="form-control" name="type_id" id="typeSelector">
                                        <option value="0">请选择分类</option>
                                    </select>
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--企业人数-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">企业人数</label>
                                <div class="col-sm-8">
                                    <input type="number" value="${Message.company_num }" name="company_num"  class="form-control" placeholder="请填写企业人数">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--所在城市-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="citySelector">所在城市</label>
                                <div class="col-sm-8">
                                    <select class="form-control" name="city" id="citySelector">
                                        <option value="0">请选择所在城市</option>
                                    </select>
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--详细地址-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">详细地址</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.addr }" name="addr" class="form-control" placeholder="请填写详细地址">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--联系人-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系人</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.contacts }" name="contacts" class="form-control" placeholder="请填写联系人">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--联系电话-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-8">
                                    <input type="number" value="${Message.phone }" name="phone" class="form-control" placeholder="请填写联系电话">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--统一社会信用代码-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">统一社会信用代码</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.license_id }" name="license_id" class="form-control" placeholder="请填写统一社会信用代码">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--营业执照图片-->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">营业执照图片</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${Message.license_img }" name="license_img"  class="form-control" placeholder="营业执照图片">
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--认真阅读同意协议-->
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-8">
                                    <label for="checkService">
                                        <input onclick="alert(this.checked);" type="checkbox" id="checkService">
                                        <strong>我已经认真阅读并同意《使用协议》</strong>
                                    </label>
                                </div>
                            </div>
                            <!--水平线-->
                            <div class="hr-line-dashed"></div>
                            <!--水平线 - 结束-->
                            <!--提交表单部分-->
                            <div class="form-group row">
                                <button class="col-md-offset-5 col-md-2 btn btn-success">确认无误,提交</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath }/statics/
    js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath }/statics/
    js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath }/statics/
    js/content.js?v=1.0.0"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath }/statics/
    js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green'
            });
        });
    </script>
</body>
</html>
