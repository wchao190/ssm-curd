<%--
  Created by IntelliJ IDEA.
  User: wuc
  Date: 2021/8/7
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("path",request.getContextPath());
%>
<html>
    <head>
        <title>员工列表</title>
        <!--引入jquery-->
        <script src="${path}/static/js/jquery-3.6.0.min.js"></script>
        <!--引入样式-->
        <link rel="stylesheet" href="${path}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" >
        <!--引入js-->
        <script src="${path}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    </head>
    <body>
    <!--搭建首页-->
    <div class="container">
        <!--标题-->
        <div class="row" >
            <div class="col-xs-12"><h2>ssm-curd</h2></div>
        </div>
        <!--操作-->
        <div class="row">
            <div class="col-md-8 col-md-offset-8">
                <button type="button" class="btn btn-success">添加</button>
                <button type="button" class="btn btn-danger">删除</button>
            </div>
        </div>
        <!--内容区-->
        <div class="row">
            <div class="col-xs-12">
                <table class="table table-hover" id="emps_table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>邮箱</th>
                            <th>性别</th>
                            <th>部门</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
        <!--分页信息-->
        <div class="row">
            <!--分页信息-->
            <div class="col-md-6" id="page_info">

            </div>
            <!--分页条-->
            <div class="col-md-6" id="page_nav">

            </div>
        </div>
    </div>

    <script  type="text/javascript">
        // 进入页面就 获取首页数据
        $(function () {
            to_page(1);
        });
        // 将发送 ajax 请求抽取为一个方法，翻页时使用
        function to_page(index) {
            $.get(
                {"url":"${path}/emps",
                    "data":"index="+index, "success":function (result) {
                        build_emps_table(result);
                        build_page_info(result);
                        build_page_nav(result)
                    },
                    "dataType":"json"
                }
            );
        }

        /**
         * <button type="button" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;编辑
         </button>
         <button type="button" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;删除
         </button>
         */
        // 解析 显示 员工 信息
        function build_emps_table(result) {
            // 调用前 先清空信息
            $("#emps_table tbody").empty();
            var emps = result.extend.pageInfo.list;
            $.each(emps,function (index,item) {
                var idTd = $("<th></th>").append(item.id);
                var nameTd = $("<th></th>").append(item.lastName);
                var genderTd = $("<th></th>").append(item.gender);
                var emailTd = $("<th></th>").append(item.email);
                var dptTd = $("<th></th>").append(item.department.dptName);
                //给button按钮添加一个 class 名
                var editTd = $("<button></button>").addClass("btn btn-success btn-sm")
                    .append("<span></span>").addClass("glyphicon glyphicon-pencil").append("编辑");
                var delTd = $("<button></button>").addClass("btn btn-danger btn-sm")
                    .append("<span></span>").addClass("glyphicon glyphicon-trash").append("删除");
                //将操作按钮添加到 th 中
                var btnTd = $("<th></th>").append(editTd).append(" ").append(delTd);
                $("<tr></tr>").append(idTd).append(nameTd).append(genderTd).append(emailTd).append(dptTd).append(btnTd).appendTo("#emps_table tbody")
            });
        }
        // 解析 显示 分页信息
        function build_page_info(result) {
            // 调用前先清空信息
            $("#page_info").empty();
            $("#page_info").append("当前第"+result.extend.pageInfo.pageNum+"页,总共"+result.extend.pageInfo.pages+"页,总计"+result.extend.pageInfo.total+"条记录");
        }
        //解析 显示分页条
        function build_page_nav(result) {
            //调用前先清空信息
            $("#page_nav").empty();
            var pageInfo = result.extend.pageInfo;
            // 首页
            var firstPageLi = $("<li></li>").append($("<a></a>").attr("href","#").append("首页"));
            firstPageLi.click(function () {
                to_page(1);
            });
            // 末页
            var lastPageLi = $("<li></li>").append($("<a></a>").attr("href","#").append("末页"));
            lastPageLi.click(function () {
                to_page(pageInfo.pages);
            });
            // 上一页
            var prevPageLi = $("<li></li>").append($("<a></a>").attr("href","#").append($("<span></span>").append("&laquo;")));
            prevPageLi.click(function () {
                to_page(pageInfo.pageNum -1);
            });
            // 下一页
            var nextPageLi = $("<li></li>").append($("<a></a>").attr("href","#").append($("<span></span>").append("&raquo;")));
            nextPageLi.click(function () {
                to_page(pageInfo.pageNum +1);
            });
            var ul = $("<ul></ul>").addClass("pagination");
            // 添加 首页、上一页
            ul.append(firstPageLi).append(prevPageLi);
            // 如果没有上一页 禁用 首页、上一页
            if(!pageInfo.hasPreviousPage){
                firstPageLi.addClass("disabled");
                prevPageLi.addClass("disabled");
            }
            // 如果没有下一页 禁用 末页、下一页
            if(!pageInfo.hasNextPage){
                lastPageLi.addClass("disabled");
                nextPageLi.addClass("disabled");
            }
            $.each(pageInfo.navigatepageNums,function (index,page_num) {
                var li = $("<li></li>").append($("<a></a>").attr("href","#").append(page_num));
                // 当前页高亮显示
                if(pageInfo.pageNum === page_num ){
                    li.addClass("active")
                }
                // 绑定单击事件，发送 ajax请求 跳转页面; 发送请求前，先清空 员工信息、分页信息、导航条
                li.click(function () {
                    to_page(page_num);
                });
                // 循环添加 中间页
                ul.append(li);
            });
            // 添加 下一页、末页
            ul.append(nextPageLi).append(lastPageLi);
            $("#page_nav").append(ul);
        }
    </script>

    </body>
</html>
