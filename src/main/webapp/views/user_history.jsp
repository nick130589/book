<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yan
  Date: 2017/12/27
  Time: 18:31
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

    <title>用户查看</title>

    <!-- Bootstrap core CSS -->
    <link href="/statics/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/statics/font-awesome/css/font-awesome.css" rel="stylesheet" />

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
                        <li ><a  href="/user_borrow">借阅·登记</a></li>
                        <li><a  href="/user_return">归还·登记</a></li>
                        <li class="active"><a  href="/user_history">历史·记录</a></li>
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
            <h3><i class="fa fa-angle-right"></i> 历史·记录</h3>
            <div class="row">



            </div><!-- row -->

            <div class="row mt">
                <div class="col-md-12">
                    <div class="content-panel">
                        <table class="table table-striped table-advance table-hover">
                            <h4>
                                <div class="row">
                                    <div class="col-sm-2 col-lg-1 col-md-2">

                                           <select class="btn-theme03 btn" id="select_1">
                                                <option value="bookId">书 编 号</option>
                                                <option value="status">状 态 </option>
                                           </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control round-form" placeholder="请输入关键字" id="input_1">
                                    </div>
                                    <div class="col-sm-2">
                                        <button type="submit" class="btn" id="btn_1"><span><i class=" fa fa-th"></i> 搜索</span></button>
                                    </div>
                                </div>
                            </h4>
                            <hr>
                            <thead>

                            <tr>
                                <th><i class="fa"></i> 书编号</th>
                                <th><i class="fa "></i> 借阅时间</th>
                                <th><i class=" fa"></i> 状态</th>
                                <th><i class=" fa "></i> 是否续借</th>
                            </tr>

                            </thead>
                            <tbody>
                          <c:forEach var="li" items="${list}">
                            <tr>
                                <td><a >${li.bookId}</a></td>
                                <td >${li.borrowTime}</td>
                               <c:if test="${li.bookStatus==0}">
                                   <td>已还</td>
                               </c:if>
                                <c:if test="${li.bookStatus!=0}">
                                    <td>未还</td>
                                </c:if>
                                <td>
                                    <button class="btn btn-success btn-xs"><i class="fa fa-check">
                                        <c:if test="${li.bookStatus!=0}"><a href="/renew?bookId=${li.bookId}&fullname=${li.fullname}">续借</a></c:if>
                                        <c:if test="${li.bookStatus==0}">不可续借</c:if>
                                    </i></button>
                                </td>
                            </tr>
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

<script>
    //custom select box

    $(function(){
        $('select.styled').customSelect();
    });

    var obj =$("#select_1").val();
    $("#select_1").change(function(){
        obj = $(this).val();

    });
    var btn_1=document.getElementById("btn_1");

    var vue=$("#input_1").val();
    $("#input_1").change(function(){
        vue = $(this).val();

    });
    btn_1.onclick=function () {
        if(obj=="status") {location.href="/user_history_by_status?status="+vue;}
        else if(obj=="bookId") {location.href="/user_history_by_bookId?bookId="+vue;}
    }

</script>

</body>
</html>

