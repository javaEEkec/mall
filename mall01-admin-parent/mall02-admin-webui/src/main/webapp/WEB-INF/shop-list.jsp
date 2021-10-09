<%--
  Created by IntelliJ IDEA.
  User: mzx
  Date: 2021/9/7
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="include-head.jsp" %>
<link rel="stylesheet" href="css/pagination.css">
<script type="text/javascript" src="jquery/jquery.pagination.js"></script>
<script type="text/javascript" src="js/my-shop.js"></script>
<script type="text/javascript">
    $(function (){
        // 1.为分页操作准备初始化数据
        window.pageNum = 1;
        window.pageSize = 5;
        window.keyword = "";

        //2.调用执行分页函数，显示分页效果
        generatePage();

        // 3. 查询操作
        $("#searchBtn").click(function () {
            window.keyword = $("#keywordInput").val();
            generatePage();
        });

        // 4. 点击新增打开模态框
        $("#showAddModalBtn").click(function () {
            $("#addShopModal").modal("show");
        });

        // 5.模态框数据保存
        $("#shopSaveBtn").click(function () {
            // 1.获取用户在模态框中输入的角色名，trim去前后空格
            // #addModal表示找到整个模态框
            // 空格表示在后代元素中继续查找
            // [name=roleName]表示匹配name属性等于roleName的元素
            let shopAcct = $.trim($("#addShopModal [name=shopAcct]").val())
            let shopName = $.trim($("#addShopModal [name=shopName]").val());
            let shopPersonincharge = $.trim($("#addShopModal [name=shopPersonincharge]").val())
            let shopPersonphone = $.trim($("#addShopModal [name=shopPersonphone]").val())

            console.log("打印：shopName" +shopName);
            // 发送ajax请求
            $.ajax({
                url: "admin/do/save/shop.json",
                type: "post",
                data: {
                    shopAcct: shopAcct,
                    shopName: shopName,
                    shopPersonincharge: shopPersonincharge,
                    shopPersonphone: shopPersonphone
                },
                dataType: "json",
                success: function (resp) {
                    let result = resp.result;
                    if (result === "SUCCESS") {
                        layer.msg("已保存");

                        // 重新加载分页
                        window.pageNum = 99999999;
                        generatePage();
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
            $("#addShopModal").modal("hide");

            // 清空表单
            // jQuery对象调用click()函数，里面不传任何参数，相当于用户点击了一下
            $("#shopResetBtn").click();

        });
    })
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
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="keywordInput" class="form-control has-success" type="text"
                                       placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="searchBtn" type="button" class="btn btn-warning"><i
                                class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button type="button" id="batchRemoveBtn" class="btn btn-danger" style="float:right;margin-left:10px;"><i
                            class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <button type="button" id="showAddModalBtn" class="btn btn-primary" style="float:right;"><i
                            class="glyphicon glyphicon-plus"></i> 新增
                    </button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input id="summaryBox" type="checkbox"></th>
                                <th>shop_acct</th>
                                <th>商家名</th>
                                <th>负责人</th>
                                <th>电话</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="shopPageBody">
                            <%--my-shop.js fillTableBody方法填充表格--%>
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

<%--新增商家模态框--%>
<%@include file="modal-shop-add.jsp"%>
</body>
</html>

