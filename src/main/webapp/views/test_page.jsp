<%--
  Created by IntelliJ IDEA.
  User: zm
  Date: 2018/5/29
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>test_page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <!-- Bootstrap core CSS -->
    <link href="/statics/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/statics/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="/statics/css/style.css" rel="stylesheet">
    <link href="/statics/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="/statics/css/to-do.css">

</head>
<body>
<h>Hello World!</h>

<table class="table table-striped table-advance table-hover">
    <h4>
        <div class="row">
            <div class="col-sm-2 col-lg-1 col-md-2">

                <select class="btn-theme03 btn">
                    <option value="cheese">书编号</option>
                    <option value="tomatoes">书名</option>
                    <option value="mozarella">作者</option>
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
        <th><i class="fa"></i> 书编号</th>
        <th><i class="fa"></i> 书名</th>
        <th><i class="fa"></i> 作者</th>
        <th><i class="fa"></i> 余量</th>
        <th><i class="fa"></i> 操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="li" items="${list}">
        <form action="#" method="get">
            <tr>
                <td><a >${li.bookId}</a></td>
                <td>${li.bookName} </td>
                <td>${li.author} </td>
                <td>${li.remain} </td>
                <td>
                    <button class="btn btn-success btn-xs"><i class="fa fa-check"></i><a href="/book_delete?bookId=${li.bookId}">删除</a></button>
                </td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
<%--<c:forEach var="li" items="${list}">--%>
    <%--<form action="#" method="get">--%>
        <%--<tr>--%>
            <%--<td><a >${li.testId}</a></td>--%>
            <%--<td>${li.testData} </td>--%>
            <%--<td>${li.testName} </td>--%>
            <%--<td>${li.testContent} </td>--%>
            <%--<td>--%>
                <%--<button class="btn btn-success btn-xs"><i class="fa fa-check"></i><a href="/book_delete?bookId=${li.bookId}">删除</a></button>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</form>--%>
<%--</c:forEach>--%>


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

<%--<script>--%>
    <%--jQuery(document).ready(function() {--%>
        <%--TaskList.initTaskWidget();--%>
    <%--});--%>
    <%--$(function() {--%>
        <%--$( "#sortable" ).sortable();--%>
        <%--$( "#sortable" ).disableSelection();--%>
    <%--});--%>
<%--</script>--%>

<%--<script>--%>
    <%--//custom select box--%>
    <%--$(function(){--%>
        <%--$('select.styled').customSelect();--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
