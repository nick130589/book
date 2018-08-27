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

    <title>个人信息</title>

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
            <h3><i class="fa fa-angle-right"></i> 个人·信息</h3>
            <div class="row">

                <div class="col-lg-12 col-md-12 col-sm-12 mb">
                    <div class="content-panel pn">
                        <div id="profile-02">
                            <div class="user">
                                <img src="/statics/img/friends/fr-06.jpg" class="img-circle" width="80">
                                <h4>DJ SHERMAN</h4>
                            </div>
                        </div>
                        <div class="pr2-social centered">
                            <h4>座右铭：</h4>
                        </div>
                    </div><!--/panel -->
                </div><!--/ col-md-4 -->
                <div class="row mt">
                    <div class="col-lg-12 col-lg-12 col-md-12 col-sm-12 mb">
                        <div class="form-panel">
                            <h4 class="mb"><i class="fa fa-angle-right"></i> 基本信息</h4>
                            <form class="form-horizontal style-form" method="get">

                                <div class="form-group">
                                    <label class="col-lg-1 col-sm-1 control-label">·学号：</label>
                                    <div class="col-lg-11">
                                        <p class="form-control-static">email@example.com</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-1 col-sm-1 control-label">·班级：</label>
                                    <div class="col-lg-11">
                                        <p class="form-control-static">email@example.com</p>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-1 col-sm-1 control-label">·学院：</label>
                                    <div class="col-lg-11">
                                        <p class="form-control-static">email@example.com</p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-1 col-sm-1 control-label">·联系方式：</label>
                                    <div class="col-lg-11">
                                        <p class="form-control-static">email@example.com</p>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div><!-- col-lg-12-->
                </div><!-- /row -->
            </div><!-- row -->


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
