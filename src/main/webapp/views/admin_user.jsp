<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2017/12/27
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>用户管理</title>

    <!-- Bootstrap core CSS -->
    <link href="/statics/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/statics/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="/statics/css/style.css" rel="stylesheet">
    <link href="/statics/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="/statics/css/to-do.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<section id="container" >
    <!-- **********************************************************************************************************************************************************
    TOP BAR CONTENT & NOTIFICATIONS
    *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="/admin_index" class="logo"><b>图书·管理·系统</b></a>
        <!--logo end-->

        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="/logout">Logout</a></li>
            </ul>
        </div>
    </header>
    <!--header end-->

    <!-- **********************************************************************************************************************************************************
    MAIN SIDEBAR MENU
    *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered"><a href="/admin_index"><img src="/statics/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                <h5 class="centered">管理员 admin</h5>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-dashboard"></i>
                        <span>图书·管理</span>
                    </a>
                    <ul class="sub">
                        <li ><a  href="/admin_query" >图书·信息</a></li>

                    </ul>

                </li>

                <li class="sub-menu">
                    <a href="javascript:;"  class="active">
                        <i class="fa fa-desktop"></i>
                        <span>用户·管理</span>
                    </a>
                    <ul class="sub">
                        <li class="active"><a  href="/admin_user" >用户·信息</a></li>

                    </ul>
                </li>

                <li class="sub-menu">
                    <a  href="javascript:;" >
                        <i class="fa fa-cogs"></i>
                        <span>借阅·管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="/admin_borrow">已借·记录</a></li>
                        <li><a  href="/admin_return">已还·记录</a></li>

                    </ul>
                </li>

                <li class="sub-menu">
                    <a  href="javascript:;" >
                        <i class="fa fa-users"></i>
                        <span>学生·管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="/student_admin_query">学生·信息</a></li>

                    </ul>
                </li>

            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <h3><i class="fa fa-angle-right"></i> 用户·信息</h3>
            <div class="row">



            </div><!-- row -->

            <div class="row mt">
                <div class="col-md-12">
                    <div class="content-panel">
                        <table class="table table-striped table-advance table-hover">
                            <h4>
                                <div class="row">
                                    <div class="col-sm-2 col-lg-1 col-md-2">
                                           <select class="btn-theme03 btn">
                                                <option value="cheese">姓 名</option>
                                                <option value="tomatoes">学 号</option>
                                                <option value="mozarella">院 系</option>
                                           </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control round-form" placeholder="请输入关键字">
                                    </div>
                                    <div class="col-sm-2">
                                        <button type="submit" class="btn"><span><i class=" fa fa-th"></i> 搜索</span></button>
                                    </div>
                                </div>
                            </h4>
                            <hr>
                            <thead>

                            <tr>
                                <th><i class="fa"></i> 姓名</th>
                                <th><i class="fa"></i> 学号</th>
                                <th><i class="fa"></i> 院系</th>
                                <th><i class="fa"></i> 联系方式</th>
                                <th><i class="fa"></i> 操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="li" items="${list}">
                            <form action="#" method="get" >
                            <tr>
                                <td>${li.fullname}</td>
                                <td >${li.studentId}</td>
                                <td>${li.dept} </td>
                                <td>${li.phone}</td>
                                <td>
                                    <button class="btn btn-success btn-xs"><i class="fa fa-check"><a href="/user_delete?studentId=${li.studentId}">删除</a></i></button>
                                </td>
                            </tr>
                            </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div><!-- /content-panel -->
                </div><!-- /col-md-12 -->
            </div><!-- /row -->

        </section><!--/wrapper -->
    </section><!-- /MAIN CONTENT -->

    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer ">
        <div class="text-center ">
            Copyright - © - 2017 - All Right Reserved - 鄢文哲

        </div>
    </footer>
    <!--footer end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/statics/js/jquery.js"></script>
<script src="/statics/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="/statics/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/statics/js/jquery.scrollTo.min.js"></script>
<script src="/statics/js/jquery.nicescroll.js" type="text/javascript"></script>


<!--common script for all pages-->
<script src="/statics/js/common-scripts.js"></script>

<!--script for this page-->
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="/statics/js/tasks.js" type="text/javascript"></script>

<script>
    jQuery(document).ready(function() {
        TaskList.initTaskWidget();
    });

    $(function() {
        $( "#sortable" ).sortable();
        $( "#sortable" ).disableSelection();
    });

</script>


<script>
    //custom select box

    $(function(){
        $('select.styled').customSelect();
    });

</script>

</body>
</html>
