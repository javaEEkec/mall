<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="adminAddModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">系统弹窗</h4>
            </div>
            <form>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="InputLogin">用户账号</label>
                        <input name="admin_acct" type="text" class="form-control" id="InputLogin" placeholder="请输入登陆账号">
                    </div>
                    <div class="form-group">
                        <label for="InputPassword">用户密码</label>
                        <input name="admin_pswd" type="password" class="form-control" id="InputPassword" placeholder="请输入登陆密码">
                    </div>
                    <div class="form-group">
                        <label for="InputAdminName">用户昵称</label>
                        <input name="admin_name" type="text" class="form-control" id="InputAdminName" placeholder="请输入用户昵称">
                    </div>
                    <div class="form-group">
                        <label for="InputAdminType">管理员类型</label>
                        <input name="admin_type" type="text" class="form-control" id="InputAdminType" placeholder="管理员类型">
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="adminSaveBtn" type="button" class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i>保存</button>
                    <button id="adminResetBtn" type="reset" class="btn btn-primary"><i class="glyphicon glyphicon-refresh"></i>重置</button>
                </div>
            </form>
        </div>
    </div>
</div>
