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
<script type="text/javascript" src="js/my-inventory-product.js"></script>
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

        // 4.打开商品详情模态框
        $("#inventoryProductPageBody").on("click",".inventoryDetailBtn",function () {
            $("#inventoryProductModal").modal("show");
            let productId = this.id;
            let inventoryProduct = getInventoryProductById(productId);
            let produceTime = jutils.formatDate(new Date(inventoryProduct.produceTime),`YYYY-MM-DD HH:ii:ss`);
            let endTime = jutils.formatDate(new Date(inventoryProduct.endTime),`YYYY-MM-DD HH:ii:ss`);

            $("#productId").text(inventoryProduct.productId);
            $("#productName").text(inventoryProduct.productName);
            $("#brand").text(inventoryProduct.brand);
            $("#price").text(inventoryProduct.price);
            $("#productImg").attr("src",inventoryProduct.productImg);
            $("#category").text(inventoryProduct.category);
            $("#produceTime").text(produceTime);
            $("#activityType").text(inventoryProduct.activityType);
            $("#description").text(inventoryProduct.description);
            $("#endTime").text(endTime);
            $("#inventoryNum").text(inventoryProduct.inventoryNum);
        });

        //5.点击编辑按钮打开改变商品库存的模态框
        $("#inventoryProductPageBody").on("click",".pencilBtn",function () {
            $("#inventoryNumChangeModal").modal("show");
            let productId = this.id;
            $("#changeProductId").text(productId);
        })

        $("#confirmChangeBtn").click(function () {
            let productId = $("#changeProductId").text();
            let changeNum = $("#changeNum").val();
            changeInventoryProductNum(productId,changeNum);
            $("#inventoryNumChangeModal").modal("hide");
        })

        // 6.打开上架商品确认模态框
        $("#inventoryProductPageBody").on("click",".onlineBtn",function () {
            $("#putOnlineModal").modal("show");
            let productId = this.id;
            $("#showProductId").text(productId);
        })

        // 7.点击确认上架商品
        $("#confirmOnlineBtn").click(function () {
            let productId = $("#showProductId").text();
            let onlineNum = $("#inputOnlineNum").val();
            pushToOnlineProduct(productId,onlineNum);
            $("#putOnlineModal").modal("hide");
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
                                <input id="keywordInput" class="form-control has-success" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="searchBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
<%--                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>--%>
<%--                    <button type="button" class="btn btn-primary" style="float:right;" ><i class="glyphicon glyphicon-plus"></i> 新增</button>--%>
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
                                <th>库存数量</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="inventoryProductPageBody">
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


<div id="inventoryProductModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">商品详情</h4>
            </div>
            <div class="modal-body">
                商品编号：<b id="productId"></b><br>
                商品名称：<b id="productName"></b><br>
                品牌：<b id="brand"></b><br>
                价格：<b id="price"></b><br>
                图片：<img id="productImg" src="" width="200px" height="160px" alt="商品图片"><br>
                类别：<b id="category"></b><br>
                描述：<b id="description"></b><br>
                生产日期：<b id="produceTime"></b><br>
                活动类型：<b id="activityType"></b><br>
                过期日期：<b id="endTime"></b><br>
                库存数量：<b id="inventoryNum"></b><br>
            </div>
        </div>
    </div>
</div>

<div id="inventoryNumChangeModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">增减库存</h4>
            </div>
            <div class="modal-body">
                商品编号:<p id="changeProductId"></p>
                <p>增加库存的数量</p>
                <input id="changeNum" type="number" />
                <p>正数表示增加库存，负数表示减少库存</p>
            </div>
            <div class="modal-footer">
                <button id="confirmChangeBtn" type="button" class="btn btn-success">确定</button>
            </div>
        </div>
    </div>
</div>


<div id="putOnlineModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">上架商品</h4>
            </div>
            <div class="modal-body">
                商品ID：<p id="showProductId"></p>
                上架数量：<input id="inputOnlineNum" type="number">
            </div>
            <div class="modal-footer">
                <button id="confirmOnlineBtn" type="button" class="btn btn-success">确定</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

