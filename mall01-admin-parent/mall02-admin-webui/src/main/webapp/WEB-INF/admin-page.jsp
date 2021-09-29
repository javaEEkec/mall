<%--
  Created by IntelliJ IDEA.
  User: mzx
  Date: 2021/9/7
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="include-head.jsp" %>
<link rel="stylesheet" href="css/pagination.css">
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<script type="text/javascript" src="js/my-admin.js"></script>
<script type="text/javascript">
    $(function () {
        // 调用后面声明的函数对页码导航条进行初始化操作
        initPagination();


        // 1.点击新增打开模态框
        $("#showAddModalBtn").click(function () {
            $("#adminAddModal").modal("show");
        });

        // 2.模态框数据保存
        $("#adminSaveBtn").click(function () {
            // 收集表单项中用户输入的数据
            var adminAcct = $.trim($("#adminAddModal [name=adminAcct]").val());
            var adminPswd = $.trim($("#adminAddModal [name=adminPswd]").val());
            var adminName = $.trim($("#adminAddModal [name=adminName]").val());
            var adminType = $.trim($("#adminAddModal [name=adminType]").val());

            $.ajax({
                url: "admin/save.json",
                type: "post",
                data: {
                    "adminAcct": adminAcct,
                    "adminPswd": adminPswd,
                    "adminName": adminName,
                    "adminType": adminType
                },
                dataType: "json",
                success: function (response) {
                    var result = response.result;
                    if (result === "SUCCESS") {
                        layer.msg("操作成功,以保存");// 重新加载分页
                        var pageNum = 99999999
                        window.location.href = "admin/get/page.html?pageNum=" + pageNum;
                    }
                    if (result === "FAILED") {
                        layer.msg("操作失败！" + response.message);
                    }
                },
                error: function (response) {
                    layer.msg(response.status + " " + response.statusText);
                }
            });
            // 关闭模态框
            $("#adminAddModal").modal("hide");
            // 清空表单
            // jQuery对象调用click()函数，里面不传任何参数，相当于用户点击了一下
            $("#adminResetBtn").click();
        })

        // 3.点击编辑按钮打开模态框
        $("#adminPageBody").on("click", ".pencilBtn", function () {
            // 打开模态框
            $("#adminEditModal").modal("show");
            window.adminId = this.id;
            var admin = getAdminById(adminId);
            if (admin == null) {
                $("#adminEditModal").modal("hide");
            } else {
                // 回显表单数据
                $("#adminEditModal [name=adminAcct]").val(admin.adminAcct)
                $("#adminEditModal [name=adminName]").val(admin.adminName)
                $("#adminEditModal [name=adminType]").val(admin.adminType)
            }
        });

        // 4.给更新模态框中的更新按钮绑定单机响应函数
        $("#updateAdminBtn").click(function () {
            // 收集表单数据
            var adminAcct = $("#adminEditModal [name=adminAcct]").val();
            var adminName = $("#adminEditModal [name=adminName]").val();
            var adminType = $("#adminEditModal [name=adminType]").val();

            // 发送Ajax请求
            $.ajax({
                url: "admin/update.json",
                data: {
                    "adminId": window.adminId,
                    "adminAcct": adminAcct,
                    "adminName": adminName,
                    "adminType": adminType
                },
                dataType: "json",
                success: function (resp) {
                    let result = resp.result;
                    if (result === "SUCCESS") {
                        layer.msg("更新成功！");

                        // 重新加载分页
                        window.location.href = "admin/get/page.html?pageNum=" +${pageInfo.pageNum};
                    }
                    if (result === "FAILED") {
                        layer.msg("操作失败！" + response.message);
                    }
                },
                error: function (response) {
                    layer.msg(response.status + " " + response.statusText);
                }
            });
            //关闭模态框
            $("#adminEditModal").modal("hide");
        });

        // 8. 点击确认模态框中的确认删除按钮执行删除
        $("#confirmRemoveBtn").click(function () {

            let requestBody = JSON.stringify(window.adminIdArray);
            $.ajax({
                url: "admin/remove/by/admin/id/array.json",
                type: "post",
                data: requestBody,
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (resp) {
                    let result = resp.result;
                    if (result === "SUCCESS") {
                        layer.msg("删除成功！");

                        // 重新加载分页
                        // generatePage();
                        window.location.href = "admin/get/page.html?pageNum=" +${pageInfo.pageNum};
                    }
                    if (result === "FAILED") {
                        layer.msg("操作失败！" + resp.message);
                    }
                },
                error: function (resp) {
                    layer.msg(resp.status + "" + resp.statusText);
                }
            });
            // 关闭模态框
            $("#adminConfirmModal").modal("hide");
        });

        //单条删除
        $("#adminPageBody").on("click", ".removeBtn", function () {
            let adminName = $(this).parent().prev().text();
            let adminArray = [{
                adminId:this.id,
                adminName:adminName
            }];
            // console.log(adminArray);
            showConfirmModal(adminArray);
        });

        // 为总的checkbox绑定单击响应函数
        $("#summaryBox").click(function () {
            var currentStatus = this.checked;
            // 用当前多选框状态设置其它多选框
            $(".itemBox").prop("checked",currentStatus);
        })


        // 11.全选全不选的反向操作
        $("#adminPageBody").on("click", ".itemBox", function (){

            // 获取当前已经选中的.itemBox的数量
            var checkedBoxCount = $(".itemBox:checked").length;

            // 获取全部.itemBox的数量
            var totalBoxCount = $(".itemBox").length;

            // 使用两者的比较结果设置总的checkBox
            $("#summaryBox").prop("checked", checkedBoxCount === totalBoxCount)
        });

        // 12.给批量删除的按钮绑定单击响应函数
        $("#batchRemoveBtn").click(function (){

            // 创建数组对象用来存放后面获取到的角色对象
            var adminArray = [];

            // 遍历当前选中的多选框
            $(".itemBox:checked").each(function (){

                // 使用this引用当前遍历得到的多选框
                var adminId = this.id;
                console.log("adminId:"+adminId);

                // 通过DOM操作获取角色名称
                var adminName = $(this).parent().next().next().next().text();

                adminArray.push({
                    adminId: adminId,
                    adminName: adminName
                });
            });

            // 检查roleArray的长度是否为0
            if (adminArray.length === 0) {
                layer.msg("请至少选择一个执行删除");
                return;
            }

            // 调用专门的函数打开确认模态框
            showConfirmModal(adminArray);
        });
    });

    function initPagination() {
        // 获取总记录数
        var totalRecord = ${pageInfo.total};
        // 声明一个JSON对象存储Pagination要设置的属性
        var properties = {
            num_edge_entries: 3, // 边缘页数
            num_display_entries: 5, // 主体页数
            callback: pageSelectCallback,
            items_per_page:${pageInfo.pageSize}, // 每页显示1项
            current_page: ${pageInfo.pageNum - 1}, // Pagination内部使用pageIndex来管理页码，从0开始，而pageNum从1开始
            prev_text: "上一页",
            next_text: "下一页"
        };
        // 生成页码导航条
        $("#Pagination").pagination(totalRecord, properties);
    }

    // 用户点击页码时调用该函数实现跳转
    function pageSelectCallback(pageIndex, jQuery) {
        // 根据pageIndex计算得到pageNum
        var pageNum = pageIndex + 1;
        // 跳转页码
        window.location.href = "admin/get/page.html?pageNum=" + pageNum + "&keyword=${param.keyword}";
        // 由于每一个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
        return false;
    }


</script>
<body>
<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form action="admin/get/page.html" class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input name="keyword" class="form-control has-success" type="text"
                                       placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button id="batchRemoveBtn" type="button" class="btn btn-danger"
                            style="float:right;margin-left:10px;"><i
                            class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <button id="showAddModalBtn" type="button" class="btn btn-primary" style="float:right;">
                        <i class="glyphicon glyphicon-plus"></i> 新增
                    </button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input id="summaryBox" type="checkbox"></th>
                                <th>admin_id</th>
                                <th>账号</th>
                                <th>用户名</th>
                                <th>类型</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="adminPageBody">
                            <c:if test="${empty pageInfo.list}">
                                <tr>
                                    <td colspan="7" align="center">抱歉！没有找到你想要的数据！</td>
                                </tr>
                            </c:if>
                            <c:if test="${!empty pageInfo.list}">
                                <c:forEach items="${pageInfo.list}" var="admin" varStatus="myStatus">
                                    <tr>
                                        <td>${myStatus.count}</td>
                                        <td><input id="${admin.adminId}" class="itemBox" type="checkbox"/></td>
                                        <td>${admin.adminId}</td>
                                        <td>${admin.adminAcct}</td>
                                        <td>${admin.adminName}</td>
                                        <td>${admin.adminType}</td>
                                        <td>
                                            <button type="button" class="btn btn-success btn-xs"><i
                                                    class=" glyphicon glyphicon-check"></i></button>
                                            <button id="${admin.adminId}" type="button"
                                                    class="btn btn-primary btn-xs pencilBtn"><i
                                                    class=" glyphicon glyphicon-pencil"></i></button>
                                            <button id="${admin.adminId}" type="button"
                                                    class="btn btn-danger btn-xs removeBtn"><i
                                                    class=" glyphicon glyphicon-remove"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6" align="center">
                                    <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="modal-admin-add.jsp" %>
<%@include file="modal-admin-edit.jsp" %>
<%@include file="modal-admin-confirm.jsp"%>
</body>
</html>

