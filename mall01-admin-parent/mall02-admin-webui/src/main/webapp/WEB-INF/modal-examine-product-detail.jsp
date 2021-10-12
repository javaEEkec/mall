<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="examineProductModal" class="modal fade" tabindex="-1" role="dialog">
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
                    编号：<b id="id"></b><br>
                    商品名称：<b id="productName"></b><br>
                    品牌：<b id="brand"></b><br>
                    价格：<b id="price"></b><br>
                    图片：<img id="productImg" src="" width="200px" height="160px" alt="商品图片"><br>
                    类别：<b id="category"></b><br>
                    描述：<b id="description"></b><br>
                    生产日期：<b id="produceTime"></b><br>
                    活动类型：<b id="activityType"></b><br>
                    过期日期：<b id="endTime"></b><br>
                    入库数量：<b id="inventoryNum"></b><br>
                    审核状态：<b id="status"></b><br>
                </div>
                <div class="modal-footer">
                    <button id="accessCheckBtn" type="button" class="btn btn-success">通过审核并入库</button>
                    <button id="failedCheckBtn" type="button" class="btn btn-danger">审核不通过</button>
                </div>
        </div>
    </div>
</div>