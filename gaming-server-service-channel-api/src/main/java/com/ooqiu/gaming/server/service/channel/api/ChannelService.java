package com.ooqiu.gaming.server.service.channel.api;

import com.ooqiu.gaming.server.domain.Channel;

import java.util.List;

/**
 * <p>Title: ChannelService </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 13:56 2018/3/9
 */

public interface ChannelService {
    /**
     * 查询全部频道
     * @return
     */
    public List<Channel> searchAll();
}
