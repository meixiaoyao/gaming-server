package com.ooqiu.gaming.server.service.channel.api.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.commons.utils.MapperUtils;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.server.service.channel.api.ChannelService;
import com.ooqiu.gaming.server.service.channel.mapper.ChannelMapper;
import com.ooqiu.gaming.server.service.redis.api.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title: ChannelServieImpl </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 14:06 2018/3/9
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_CHANNEL)
public class ChannelServieImpl implements ChannelService{
    @Autowired
    private ChannelMapper channelMapper;

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_REDIS)
    private RedisService redisService;

    @Override
    public List<Channel> searchAll() {
        try{
            String json = (String) redisService.get("channelList");
            if(StringUtils.isNotBlank(json)){
                return MapperUtils.json2list(json, Channel.class);
            }
            else{
                List<Channel> channelList = channelMapper.selectAll();
                redisService.set("channelList", MapperUtils.obj2json(channelList), 3600);
                return channelList;
            }
        }catch (Exception e){
            return null;
        }
    }
}
