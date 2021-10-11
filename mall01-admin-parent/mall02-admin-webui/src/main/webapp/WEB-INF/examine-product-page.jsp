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
<script type="text/javascript" src="js/my-examine-product.js"></script>
<script type="text/javascript" src="js/jutils.min.js"></script>
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

        // 4.点击打开商品详情模态框
        $(".examineDetailBtn").click(function () {
            $("#examineProductModal").modal("show");
            let id = this.id;
            let examineProduct = getExamineProductById(id);
            let produceTime = jutils.formatDate(new Date(examineProduct.produceTime),`YYYY-MM-DD HH:ii:ss`);
            let endTime = jutils.formatDate(new Date(examineProduct.endTime),`YYYY-MM-DD HH:ii:ss`);
            $("#id").text(examineProduct.id);
            $("#productName").text(examineProduct.productName);
            $("#brand").text(examineProduct.brand);
            $("#price").text(examineProduct.price);
            $("#productImg").attr("src",examineProduct.productImg);
            $("#category").text(examineProduct.category);
            $("#produceTime").text(produceTime);
            $("#activityType").text(examineProduct.activityType);
            $("#description").text(examineProduct.description);
            $("#endTime").text(endTime);
            $("#inventoryNum").text(examineProduct.inventoryNum);
            $("#status").text(examineProduct.status);
        });

        // 5.点击审核不通过按钮
        $("#failedCheckBtn").click(function (){
            let id = $("#id").text();
           $.ajax({
               url: "check/product/by/id.json",
               data:{
                   "id": id,
                   "operation": 1
               },
               dataType: "json",
               success:function (resp) {
                   let result = resp.result;
                   if (result === "SUCCESS") {
                       layer.msg("更新成功！");

                       // 重新加载分页
                       generatePage();
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
            $("#examineProductModal").modal("hide");
        });

        //点击通过审核入库
        $("#accessCheckBtn").click(function (){
            let id = $("#id").text();
            $.ajax({
                url: "check/product/by/id.json",
                data:{
                    "id": id,
                    "operation": 0
                },
                dataType: "json",
                success:function (resp) {
                    let result = resp.result;
                    if (result === "SUCCESS") {
                        layer.msg("更新成功！");

                        // 重新加载分页
                        generatePage();
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
            $("#examineProductModal").modal("hide");
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
                                <input id="keywordInput" class="form-control has-success" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="searchBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='form.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th>商品名称</th>
                                <th>品牌</th>
                                <th>商家</th>
                                <th>价格</th>
                                <th>类别</th>
                                <th>入库数量</th>
                                <th>审核状态</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="examineProductPageBody">
                            <%--                            <tr>--%>
                            <%--                                <td>1</td>--%>
                            <%--                                <td>苹果</td>--%>
                            <%--                                <td>华圣果业</td>--%>
                            <%--                                <td>商家1</td>--%>
                            <%--                                <td>2.10</td>--%>
                            <%--                                <td>水果</td>--%>
                            <%--                                <td>100</td>--%>
                            <%--                                <td>--%>
                            <%--                                    <button type="button" class="btn btn-success btn-xs"><i class="glyphicon glyphicon-eye-open"></i></button>--%>
                            <%--                                    <button type="button" class="btn btn-primary btn-xs"><i class="glyphicon glyphicon-pencil"></i></button>--%>
                            <%--                                    <button type="button" class="btn btn-danger btn-xs"><i class="glyphicon glyphicon-remove"></i></button>--%>
                            <%--                                </td>--%>
                            <%--                            </tr>--%>
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


<%@include file="modal-examine-product-detail.jsp"%>
</body>
</html>

