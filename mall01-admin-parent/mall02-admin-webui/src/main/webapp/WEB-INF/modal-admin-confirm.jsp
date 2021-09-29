<%--
  Created by IntelliJ IDEA.
  User: mzx
  Date: 2021/9/29
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="adminConfirmModal" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
                aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h4 class="modal-title">系统弹窗</h4>
      </div>
      <form>
        <div class="modal-body">
          <h4>确认是否删除下列用户</h4>
          <div id="adminNameDiv" style="text-align: center;"></div>
        </div>
        <div class="modal-footer">
          <button id="confirmRemoveBtn" type="button" class="btn btn-default"><i class="glyphicon glyphicon-edit"></i> 确认删除</button>
        </div>
      </form>
    </div>
  </div>
</div>