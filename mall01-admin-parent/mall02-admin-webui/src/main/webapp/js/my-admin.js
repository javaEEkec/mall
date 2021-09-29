function getAdminById(adminId) {
    let ajaxResult = $.ajax({
        url: "admin/get/admin.json",
        type: "post",
        data: {
            "adminId": adminId
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

// 声明专门的函数，显示确认模态框
function showConfirmModal(adminArray) {

    console.log(adminArray);
    // 打开模态框
    $("#adminConfirmModal").modal("show");

    // 清除旧数据
    $("#adminNameDiv").empty();

    // 全局变量，存放角色id
    window.adminIdArray = [];

    // 遍历roleArray数组
    for (let i = 0; i < adminArray.length; i++) {
        var admin = adminArray[i];
        var adminName = admin.adminName;
        $("#adminNameDiv").append(adminName+"<br/>");

        var adminId = admin.adminId;

        //调用数组对象push方法存入新元素
        window.adminIdArray.push(adminId);
    }
}