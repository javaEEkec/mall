<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="addShopModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">拼客系统弹窗</h4>
            </div>
            <form class="form-signin" role="form">
            <div class="modal-body">

                    <div class="form-group has-success has-feedback">
                        <div class="form-group">
                            <input type="text" name="shopAcct" class="form-control" placeholder="设置商家账号">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group">
                            <input type="text" name="shopName" class="form-control" placeholder="请输商家名称">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>

                        <div class="form-group">
                            <input type="text" name="shopPersonincharge" class="form-control" placeholder="输入商家负责人">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group">
                            <input type="text" name="shopPersonphone" class="form-control" placeholder="输入商家联系电话">
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                    </div>

            </div>
            <div class="modal-footer">
                <button id="shopSaveBtn" type="button" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i>保存</button>
                <button id="shopResetBtn" type="reset" class="btn btn-primary"><i class="glyphicon glyphicon-refresh"></i>重置</button>
            </div>
            </form>
        </div>
    </div>
</div>
