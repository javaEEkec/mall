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
<script type="text/javascript" src="js/my-shop-check.js"></script>
<script type="text/javascript">
    $(function () {
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

        // 点击check按钮弹出审核模态框
        $("#shopCheckPageBody").on("click",".checkBtn",function () {
            $("#shopCheckModal").modal("show");
            let id = this.id;
            let shopCheck = getShopCheckById(id);
            console.log(shopCheck);
            $("#id").text(id);
            $("#shopAcct").text(shopCheck.shopAcct);
            $("#shopName").text(shopCheck.shopName);
            $("#shopPersonincharge").text(shopCheck.shopPersonincharge);
            $("#shopPersonphone").text(shopCheck.shopPersonphone);
            $("#shopCheckStatus").text(shopCheck.shopCheckStatus);
        })

        $("#accessShopCheckBtn").click(function () {
            let id = $("#id").text();
            let shopAcct = getShopCheckById(id).shopAcct;
            $.ajax({
                url: "check/shop.json",
                data: {
                    "id": id,
                    "shopAcct":shopAcct,
                    "operation": 0
                },
                dataType: "json",
                success: function (resp) {
                    let result = resp.result;
                    if (result === "SUCCESS") {
                        layer.msg("更新成功！");

                        // 重新加载分页
                        generatePage();
                    }
                    if (result === "FAILED") {
                        layer.msg("操作失败！" + resp.message);
                    }
                },
                error: function (response) {
                    layer.msg(response.status + " " + response.statusText);
                }
            });
            //关闭模态框
            $("#shopCheckModal").modal("hide");
        })

        $("#failedShopCheckBtn").click(function () {
            let id = $("#id").text();
            $.ajax({
                url: "check/shop.json",
                data: {
                    "id": id,
                    "operation": 1
                },
                dataType: "json",
                success: function (resp) {
                    let result = resp.result;
                    if (result === "SUCCESS") {
                        layer.msg("更新成功！");

                        // 重新加载分页
                        generatePage();
                    }
                    if (result === "FAILED") {
                        layer.msg("操作失败！" + resp.message);
                    }
                },
                error: function (response) {
                    layer.msg(response.status + " " + response.statusText);
                }
            });
            //关闭模态框
            $("#shopCheckModal").modal("hide");
        })
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
<%--                    <button type="button" id="batchRemoveBtn" class="btn btn-danger" style="float:right;margin-left:10px;"><i--%>
<%--                            class=" glyphicon glyphicon-remove"></i> 删除--%>
<%--                    </button>--%>
<%--                    <button type="button" id="showAddModalBtn" class="btn btn-primary" style="float:right;"><i--%>
<%--                            class="glyphicon glyphicon-plus"></i> 新增--%>
<%--                    </button>--%>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th>shop_acct</th>
                                <th>商家名</th>
                                <th>负责人</th>
                                <th>电话</th>
                                <th>审核状态</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="shopCheckPageBody">
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


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="shopCheckModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">商家信息详情</h4>
            </div>
            <div class="modal-body">
                编号：<b id="id"></b><br>
                商家登录账号：<b id="shopAcct"></b><br>
                商家名：<b id="shopName"></b><br>
                负责人：<b id="shopPersonincharge"></b><br>
                联系电话：<b id="shopPersonphone"></b><br>
                审核状态：<b id="shopCheckStatus"></b><br>
            </div>
            <div class="modal-footer">
                <button id="accessShopCheckBtn" type="button" class="btn btn-success">通过审核</button>
                <button id="failedShopCheckBtn" type="button" class="btn btn-danger">审核不通过</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

