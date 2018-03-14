/**
 * 后台的数据结构
 * @param {Object} status 状态码
 * @param {Object} msg 消息
 * @param {Object} data 数据
 */
function BaseResult(status, msg, data) {
    var result = new Object();

    result.status = status;
    result.msg = msg;
    result.data = data;

    return result;
}

/**
 * 频道
 * @param {Object} data
 */
function Channel(data) {
    var channel = new Object();

    // ID
    channel.id = data.id;

    // 频道名称
    channel.name = data.name;

    return channel;
}

