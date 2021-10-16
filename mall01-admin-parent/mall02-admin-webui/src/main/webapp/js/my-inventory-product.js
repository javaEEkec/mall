// 执行分页操作
function generatePage() {
  // 1.获取分页数据
  var pageInfo = getPageInfoRemote();
  // 2.填充表格
  fillTableBody(pageInfo);

}

// 远程访问服务器端程序获取pageInfo数据
function getPageInfoRemote() {

  console.log("pageNum=" + window.pageNum);
  var ajaxResult = $.ajax({
    url: "admin/inventory/product/page/info.json",
    type: "post",
    data: {
      "pageNum": window.pageNum,
      "pageSize": window.pageSize,
      "keyword": window.keyword
    },
    //取消异步执行
    async: false,
    dataType: "json"
  });
  console.log(ajaxResult);
  // 判断当前响应状态码是否为200
  var statusCode = ajaxResult.status;
  // 如果当前响应状态码不是200，说明出现错误，显示提示信息，让当前函数停止执行
  if (statusCode !== 200) {
    layer.msg("失败! 状态码=" + statusCode + " 提示信息=" + ajaxResult.statusText);
    return null;
  }
  // 如果响应码为200，说明请求处理成功，获取pageInfo
  var resultEntity = ajaxResult.responseJSON;
  // 从resultEntity属性中获取result属性
  var result = resultEntity.result;
  // 判断result是否成功
  if (result === "FAILED") {
    layer.msg(resultEntity.message);
    return null;
  }
  return resultEntity.data;
}

// 填充表格
function fillTableBody(pageInfo) {

  var inventoryProductPageBody = $("#inventoryProductPageBody");
  // 清除tbody原来的内容
  inventoryProductPageBody.empty();
  //这里清空是为了当查询不到结果时不显示底部分页导航条
  $("#Pagination").empty();
  // 判断pageInfo是否有效
  if (pageInfo == null || pageInfo.list == null || pageInfo.list.length === 0) {
    inventoryProductPageBody.append("<tr><td colspan='4' align='center'>抱歉！没有查询到您搜索的数据</td></tr>");
    return;
  }
  // 使用pageInfo的list属性填充tBody
  for (let i = 0; i < pageInfo.list.length; i++) {

    let product = pageInfo.list[i];
    let productId = product.productId;
    let productName = product.productName;
    let brand = product.brand;
    let shopName = product.shop.shopName;
    let category = product.category;
    let price = product.price;
    let inventoryNum = product.inventoryNum;

    let numberTd = "<td>" + (i + 1) + "</td>";
    let productNameTd = "<td>" + productName + "</td>";
    let brandTd = "<td>" + brand + "</td>";
    let shopNameTd = "<td>" + shopName + "</td>";
    let priceTd = "<td>" + price + "</td>";
    let categoryTd = "<td>" + category + "</td>";
    let inventoryNumTd = "<td>" + inventoryNum + "</td>";

    var detailBtn = "<button id='" + productId + "' type=\"button\" class=\"btn btn-success btn-xs inventoryDetailBtn\"><i class=\" glyphicon glyphicon-eye-open\"></i></button>";
    var pencilBtn = "<button id='" + productId + "' type='button' class='btn btn-primary btn-xs pencilBtn'><i class='glyphicon glyphicon-pencil'></i></button>";
    var onlineBtn = "<button id='" + productId + "' type=\"button\" class=\"btn btn-info btn-xs onlineBtn\"><i class=\" glyphicon glyphicon-arrow-up\"></i></button>";

    var buttonTd = "<td>" + detailBtn + " " + pencilBtn + " " + onlineBtn + "</td>"
    var tr = "<tr>" + numberTd + productNameTd +brandTd+ shopNameTd +priceTd + categoryTd+ inventoryNumTd + buttonTd + "</tr>";

    inventoryProductPageBody.append(tr);
  }
  // 生成分页导航条
  generateNavigator(pageInfo);
  console.log("生成分页导航条")
}

// 生成分页页码导航条
function generateNavigator(pageInfo) {

  // 获取总记录数
  var totalRecord = pageInfo.total;

  // 声明相关属性
  var properties = {
    num_edge_entries: 3, // 边缘页数
    num_display_entries: 5, // 主体页数
    callback: paginationCallBack,
    items_per_page: pageInfo.pageSize, // 每页显示1项
    current_page: pageInfo.pageNum - 1, // Pagination内部使用pageIndex来管理页码，从0开始，而pageNum从1开始
    prev_text: "上一页",
    next_text: "下一页"
  };

  // 调用pagination()函数
  $("#Pagination").pagination(totalRecord, properties);

}

// 翻页时的回调函数
function paginationCallBack(pageIndex, jQuery) {
  // 根据pageIndex计算得到pageNum
  window.pageNum = pageIndex + 1;

  // 调用分页函数
  generatePage();

  // 由于每一个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
  return false;
}

// 获取库存商品详情
function getInventoryProductById(productId) {
  let ajaxResult = $.ajax({
    url: "admin/get/inventory/product/detail.json",
    type: "post",
    data: {
      productId: productId
    },
    //取消异步执行
    async: false,
    dataType:"json"
  });
  console.log(ajaxResult);
  // 判断当前响应状态码是否为200
  var statusCode = ajaxResult.status;
  // 如果当前响应状态码不是200，说明出现错误，显示提示信息，让当前函数停止执行
  if (statusCode !== 200) {
    layer.msg("失败! 状态码=" + statusCode + " 提示信息=" + ajaxResult.statusText);
    return null;
  }
  // 如果响应码为200，说明请求处理成功，获取pageInfo
  var resultEntity = ajaxResult.responseJSON;
  // 从resultEntity属性中获取result属性
  var result = resultEntity.result;
  // 判断result是否成功
  if (result === "FAILED") {
    layer.msg(resultEntity.message);
    return null;
  }
  return resultEntity.data;
}

function changeInventoryProductNum(productId,changeNum) {
  $.ajax({
    url:"admin/change/inventory/product/num.json",
    data:{
      productId: productId,
      changeNum: changeNum
    },
    dataType: "json",
    success:function (resp){
      let result = resp.result;
      if (result === "SUCCESS"){
        layer.msg("操作成功");
        generatePage();
      }
      if (result === "FAILED"){
        layer.msg("操作失败！" + resp.message);
      }
    },
    error: function (resp) {
      layer.msg(resp.status + " " + resp.statusText);
    }
  })
}

function pushToOnlineProduct(productId,onlineNum){
  $.ajax({
    url:"admin/push/to/online/product.json",
    data:{
      productId: productId,
      onlineNum: onlineNum
    },
    dataType: "json",
    success: function (resp){
      let result = resp.result;
      if (result === "SUCCESS"){
        layer.msg("操作成功")
        generatePage();
      }
      if (result === "FAILED"){
        layer.msg("操作失败" + resp.message);
      }
    },
    error: function (resp) {
      layer.msg(resp.status + " " + resp.statusText);
    }
  })
}



