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
    <title>OI平台-管理设置</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico">
     <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
    
    
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/plugins/webuploader/webuploader.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/statics/css/demo/webuploader-demo.css">
    <style>
        .pic-uploader-box{
            position:relative;
        }
        .pic-uploader{
            position:absolute;
            top:0;
            left:0;
            width:100%;
            height:100%;
            opacity:0;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>职级管理 <small>请确认所有选项填写无误</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <!--表单正文-->
                <div class="ibox-content">
                    <form action="<%=basePath %>/company/staffer/edit.html" class="form-horizontal" id="oi_en_pub_edit">
                        <input type="hidden" name="user_id" value="${staffer.user_id }">
                        <!--姓名-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名：</label>
                            <div class="col-sm-8">
                                <input type="text" name="realname" value="${staffer.realname }" class="form-control" placeholder="姓名">
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--手机-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">手机：</label>
                            <div class="col-sm-8">
                                <input type="text"  name="account" value="${staffer.account }"  class="form-control" placeholder="手机">
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--邮箱-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">邮箱：</label>
                            <div class="col-sm-8">
                                <input type="text" name="email" value="${staffer.email }" class="form-control" placeholder="邮箱">
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--入职时间-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">入职时间：</label>
                            <div class="col-sm-8">
                                <input type="date" name="reg_time" value="${staffer.reg_time }"  class="form-control">
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--部门-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">部门：</label>
                            <div class="col-sm-8">
                                <select name="depart"  class="form-control">
                                    <option value="0">请选择部门</option>
                                    <option value="2">部门</option>
                                    <option value="3">部门</option>
                                    <option value="4">部门</option>
                                </select>
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--职系-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">职系：</label>
                            <div class="col-sm-8">
                                <select name="post"  class="form-control">
                                    <option value="0">请选择职系</option>
                                    <option value="2">职系</option>
                                    <option value="3">职系</option>
                                    <option value="4">职系</option>
                                </select>
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--职级-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label">职级：</label>
                            <div class="col-sm-8">
                                <select name="postlevel"  class="form-control">
                                    <option value="0">请选择职级</option>
                                    <option value="2">职级</option>
                                    <option value="3">职级</option>
                                    <option value="4">职级</option>
                                </select>
                            </div>
                        </div>
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                        <!--头像-->
                        <!--图片上传-->
                        <input type="hidden" id="file" name="face">
                        <div class="page-container">
                            <div><input type="hidden" id="url" value="${pageContext.request.contextPath }/file/upload.do"> </div>
                            <div id="uploader" class="wu-example">
                            
                                <div class="queueList">
                                
                                    <div id="dndArea"  class="placeholder">
                                        <div id="filePicker"><img src="${propaganda.pic_URL }"></img></div>
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
                        <!--水平线-->
                        <div class="hr-line-dashed"></div>
                        <!--水平线 - 结束-->
                      <div class="form-group">
                        <label class="col-sm-2 control-label">审核状态：</label>
                        <div class="col-sm-2">
                          <label>
                            <input type="radio" name="audit"/>&nbsp;&nbsp;
                            待实名
                          </label>
                        </div>
                        <div class="col-sm-2">
                          <label>
                            <input type="radio" name="audit"/>&nbsp;&nbsp;
                            待审核
                          </label>
                        </div>
                        <div class="col-sm-2">
                          <label>
                            <input type="radio" name="audit"/>&nbsp;&nbsp;
                            已审核
                          </label>
                        </div>
                        <div class="col-sm-2">
                          <label>
                            <input type="radio" name="audit"/>&nbsp;&nbsp;
                            已拒绝
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
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath }/statics/js/content.js?v=1.0.0"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath }/statics/js/plugins/iCheck/icheck.min.js"></script>

<script type="text/javascript">
        // 添加全局站点信息
        var BASE_URL = '${pageContext.request.contextPath }/statics/js/plugins/webuploader';
    </script>
    <script src="${pageContext.request.contextPath }/statics/js/plugins/webuploader/webuploader.min.js"></script>

    <script src="${pageContext.request.contextPath }/statics/js/demo/webuploader-demo.js"></script>

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
