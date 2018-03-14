var Utils = function() {

    // 主机地址
    var HOST_URL = "http://192.168.155.1:8500/";

    /**
     * Ajax 请求 - GET
     * @param {Object} url 请求地址
     * @param {Object} params 请求参数
     * @param {Function} callback 请求成功之后的回调函数
     */
    var handlerGetRequest = function(url, params, callback) {
        handlerAjaxRequest("get", url, params, callback);
    }

    /**
     * Ajax 请求 - POST
     * @param {Object} url 请求地址
     * @param {Object} params 请求参数
     * @param {Function} callback 请求成功之后的回调函数
     */
    var handlerPostRequest = function(url, params, callback) {
        handlerAjaxRequest("post", url, params, callback);
    }

    /**
     * Ajax 请求
     * @param {Object} type 请求类型
     * @param {Object} url 请求地址
     * @param {Object} params 请求参数
     * @param {Object} callback 成功后的回调函数
     */
    var handlerAjaxRequest = function(type, url, params, callback){
        mui.ajax(HOST_URL + url, {
            data: params,
            dataType: 'json', //服务器返回json格式数据
            type: type, //HTTP请求类型
            timeout: 10000, //超时时间设置为10秒；
            headers: {
                'Content-Type': 'application/json'
            },
            success: function(data) {
                var status = data.status;
                var msg = data.msg;

                // 请求成功
                if (status == 200) {
                    callback(data);
                }

                // 请求失败
                else {
                    mui.toast(msg);
                }
            },
            error: function(xhr, type, errorThrown) {
                // 异常处理
                mui.toast("检测到您的网络有问题，请稍后再试...");
            }
        });
    }

    return {
        getRequest: function(url, params, callback) {
            handlerGetRequest(url, params, callback);
        },

        postRequest: function(url, params, callback) {
            handlerPostRequest(url, params, callback);
        }
    }

}();