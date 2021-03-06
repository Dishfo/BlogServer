<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>个人中心</title>

    <!-- 网站图标 -->
    <link rel="shortcut icon" href="/images/favicon.ico">

    <!-- Bootstrap  -->
    <link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.min.css">
    <!-- 导航栏 CSS -->
    <link rel="stylesheet" href="/css/personal_center/mycenter.css">
    <!-- jquery confirm -->
    <link rel="stylesheet"
          href="/plugins/jqueryconfirm/css/jquery-confirm.min.css" />
    <!-- validator -->
    <link rel="stylesheet"
          href="/plugins/validator/css/bootstrapValidator.min.css" />

    <!-- jQuery -->
    <script src="/plugins/jquery/js/jquery-3.2.1.min.js"></script>
    <!-- jQuery form -->
    <script src="/plugins/jquery/js/jquery.form.min.js"></script>
    <!-- Bootstrap -->
    <script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- validator -->
    <script src="/plugins/validator/js/bootstrapValidator.min.js"></script>
    <script src="/js/login/formvalidator.js"></script>
    <!-- JQuery cookie -->
    <script src="/plugins/jquery/js/jquery.cookie.js"></script>
    <!-- 个人中心js -->
    <script src="/js/personal_center/personal-center.js"></script>
    <!-- jquery confirm -->
    <script src="/plugins/jqueryconfirm/js/jquery-confirm.min.js"></script>
    <!-- 自定开开发工具包  -->
    <script src="/js/customize-sdk.js"></script>
    <!-- validator -->
    <script src="/plugins/validator/js/bootstrapValidator.min.js"></script>

</head>
<body>
<!-- 左侧菜单栏 -->
<div class="container-fluid back-left-menu">
    <div class="row">
        <div class="col-md-2">
            <ul id="menunav" class="nav nav-tabs nav-stacked">
                <li class="active"><a href="#"><i
                        class="glyphicon glyphicon-th-large"></i> 菜单栏</a></li>
                <li><a id="personaldata" href="#nav_personalData"
                       class="nav-header collapsed" data-toggle="collapse"> <i
                        class="glyphicon glyphicon-cog"></i> 个人资料 <span
                        class="pull-right glyphicon glyphicon-chevron-down"></span>
                </a>
                    <ul id="nav_personalData" class="nav nav-list collapse secondmenu">
                        <li><a href="#" id="showuserinfo"><i
                                class="glyphicon glyphicon-user"></i> 个人资料查看</a></li>
                        <li><a href="#" id="edituserinfo"><i
                                class="glyphicon glyphicon-th-list"></i> 个人资料修改</a></li>
                    </ul></li>
                <li><a href="#" id="modifypassword"> <i
                        class="glyphicon glyphicon-credit-card"></i> 修改密码
                </a></li>
                <li><a href="#" id="btn_modifyEmail"> <i
                        class="glyphicon glyphicon-credit-card"></i> 修改邮箱
                </a></li>
                <li><a href="#" id="aboutweb"> <i
                        class="glyphicon glyphicon-fire"></i> 关于本站
                </a></li>
            </ul>
        </div>
        <div id="mainWindow" class="col-md-6">
            <!-- 代码动态添加  -->
        </div>
    </div>
</div>
</body>
</html>