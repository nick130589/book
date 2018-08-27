<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2017/12/27
  Time: 18:40
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

    <title>借书登记</title>

    <!-- Bootstrap core CSS -->
    <link href="/statics/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/statics/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="/statics/js/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="/statics/js/bootstrap-daterangepicker/daterangepicker.css" />

    <!-- Custom styles for this template -->
    <link href="/statics/css/style.css" rel="stylesheet">
    <link href="/statics/css/style-responsive.css" rel="stylesheet">

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
        <a href="/user_index" class="logo"><b>图书·管理·系统</b></a>
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

                <p class="centered"><a href="/user_person"><img src="/statics/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                <h5 class="centered">-${sessionScope.name}-</h5>


                <!--导航栏-->
                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-tasks"></i>
                        <span>个人·中心</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="/user_person">个人信息</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a class="active" href="javascript:;" >
                        <i class="fa fa-th"></i>
                        <span>借阅·中心</span>
                    </a>
                    <ul class="sub">
                        <li ><a  href="/user_query">借阅·查看</a></li>
                        <li class="active"><a  href="/user_borrow">借阅·登记</a></li>
                        <li ><a  href="/user_return">归还·登记</a></li>
                        <li ><a  href="/user_history">历史·记录</a></li>
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
            <h3><i class="fa fa-angle-right"></i> 借阅·登记</h3>

            <!-- BASIC FORM ELELEMNTS -->
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="form-panel">
                        <h4 class="mb"><i class="fa fa-angle-right"></i> 基本信息</h4>
                        <form class="form-horizontal style-form" method="post" action="/user_borrow">
                            <div class="form-group">
                                <label class="col-sm-1 control-label">图书编号</label>
                                <div class="col-sm-11">
                                    <input type="text" class="form-control" name="bookId">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">书名</label>
                                <div class="col-sm-11">
                                    <input type="text" class="form-control" name="bookName">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">借阅人姓名</label>
                                <div class="col-sm-11">
                                    <input type="text" class="form-control" name="fullname">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">借阅人学号</label>
                                <div class="col-sm-11">
                                    <input type="text" class="form-control" name="studentId">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-1 control-label">借阅时间</label>
                                <div class="col-sm-11">
                                    <input type="date" class="form-control" placeholder="2017-12-11" name="borrowTime">
                                </div>
                            </div>

                            <input type="submit" value="确认借阅" class="btn btn-theme">
                            <br>
                            <div><h3>${error}</h3></div>
                        </form>
                    </div>
                </div><!-- col-lg-12-->
            </div><!-- /row -->






        </section><! --/wrapper -->
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
<script src="/statics/js/jquery-ui-1.9.2.custom.min.js"></script>

<!--custom switch-->
<script src="/statics/js/bootstrap-switch.js"></script>

<!--custom tagsinput-->
<script src="/statics/js/jquery.tagsinput.js"></script>

<!--custom checkbox & radio-->

<script type="text/javascript" src="/statics/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap-daterangepicker/date.js"></script>
<script type="text/javascript" src="/statics/js/bootstrap-daterangepicker/daterangepicker.js"></script>

<script type="text/javascript" src="/statics/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


<script src="/statics/js/form-component.js"></script>


<script>
    //custom select box

    $(function(){
        $('select.styled').customSelect();
    });

</script>

</body>
</html>
