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
<script type="text/javascript" src="js/my-complaint.js"></script>
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

        // 4.打开更新模态框
        $("#complaintPageBody").on("click",".changeStatus",function () {
            $("#complaintChangeModal").modal("show");
            $("#complaintId").val(this.id)

        })

        // 5.点击更新订单状态按钮
        $("#statusChangeBtn").click(function () {
            let id = $("#complaintId").val();
            console.log(id);
            $.ajax({
                url: "update/complaint/status.json",
                type: "post",
                data:{
                    id: id
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
            $("#complaintChangeModal").modal("hide");
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
                    <%--                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='form.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>--%>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th>id</th>
                                <th>用户编号</th>
                                <th>商品编号</th>
                                <th>投诉内容</th>
                                <th>商品名称</th>
                                <th>投诉状态</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="complaintPageBody">
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

<div id="complaintChangeModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">系统弹窗</h4>
            </div>
            <form>
                <div class="modal-body">
                    该投诉内容是否已处理,点击确定将订单状态改为已处理
                    <input type="hidden" id="complaintId">
                </div>
                <div class="modal-footer">
                    <button id="statusChangeBtn" type="button" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i>保存</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

