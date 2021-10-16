function getUserDetailByUserId(userId) {
    let ajaxResult = $.ajax({
        url: "/get/user/detail",
        type: "post",
        data: {
            userId:userId
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
    var resultEntity = ajaxResult.responseJSON;
    // 从resultEntity属性中获取result属性
    var result = resultEntity.result;
    // // 判断result是否成功
    if (result === "FAILED") {
        layer.msg(resultEntity.message);
        return null;
    }
    return resultEntity.data;
}