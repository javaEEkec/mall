<%--
  Created by IntelliJ IDEA.
  User: mzx
  Date: 2021/9/9
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3 col-md-2 sidebar">
    <div class="tree">
        <ul style="padding-left:0px;" class="list-group">
            <li class="list-group-item tree-closed" >
                <a href="admin/to/main/page.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
            </li>
            <li class="list-group-item tree-closed">
                <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span>
                <ul style="margin-top:10px;display:none;">
                    <li style="height:30px;">
                        <a href="admin/get/page.html"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                    </li>
                    <li style="height:30px;">
                        <a href="role.html"><i class="glyphicon glyphicon-king"></i> 角色维护</a>
                    </li>
                    <li style="height:30px;">
                        <a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 菜单维护</a>
                    </li>
                </ul>
            </li>
            <li class="list-group-item tree-closed">
                <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span>
                <ul style="margin-top:10px;display:none;">

                    <li style="height:30px;">
                        <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
                    </li>
                    <li style="height:30px;">
                        <a href="admin/to/examine/product/page.html"><i class="glyphicon glyphicon-check"></i> 商品审核</a>
                    </li>
                    <li style="height:30px;">
                        <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 商家入驻审核</a>
                    </li>
                </ul>
            </li>
            <li class="list-group-item tree-closed">
                <span><i class="glyphicon glyphicon-th-large"></i> 业务流程 <span class="badge" style="float:right">6</span></span>
                <ul style="margin-top:10px;display:none;">
                    <li style="height:30px;">
                        <a href="admin/to/inventory/product/page.html"><i class="glyphicon glyphicon-picture"></i> 库存商品管理</a>
                    </li>
                    <li style="height:30px;">
                        <a href="admin/to/online/product/page.html"><i class="glyphicon glyphicon-equalizer"></i> 上架商品管理</a>
                    </li>
                    <li style="height:30px;">
                        <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
                    </li>
                    <li style="height:30px;">
                        <a href="admin/to/shop/list/page.html"><i class="glyphicon glyphicon-comment"></i> 店铺列表</a>
                    </li>
                    <li style="height:30px;">
                        <a href=""><i class="glyphicon glyphicon-comment"></i>订单管理</a>
                    </li>
                    <li style="height:30px;">
                        <a href=""><i class="glyphicon glyphicon-comment"></i>投诉处理</a>
                    </li>
                </ul>
            </li>
            <li class="list-group-item tree-closed" >
                <a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
            </li>
        </ul>
    </div>
</div>


