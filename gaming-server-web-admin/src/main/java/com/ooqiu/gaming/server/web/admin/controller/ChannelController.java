package com.ooqiu.gaming.server.web.admin.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Channel;
import com.ooqiu.gaming.server.service.admin.api.ChannelService;
import com.ooqiu.gaming.server.web.admin.dto.TreeView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Eve
 * @Date:Created in 下午 12:13 2018/2/28 0028
 */
@Controller
@RequestMapping(value = "channel")
public class ChannelController {
    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private ChannelService channelService;

    /**
     * 跳转列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<Channel> list = new ArrayList<>();
        List<Channel> channels = channelService.searchAll();

        sortChannelList(list, channels);

        model.addAttribute("channels", list);

        return "modules/channel/list";
    }

    /**
     * 跳转表单页
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model){
        return "modules/channel/form";
    }

    /**
     * 新增频道数据
     * @param channel
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Channel channel){
        int result = channelService.save(channel);
        return "redirect:/channel/list";
    }

    /**
     * 树形结构
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree")
    public List<TreeView> treeData(String pid){
        List<TreeView> list = Lists.newArrayList();

        if (StringUtils.isBlank(pid) || "#".equals(pid)){
            pid = "0";
        }

        List<Channel> channels = channelService.selectByPid(Long.parseLong(pid));

        for (Channel channel : channels) {
            TreeView treeView = new TreeView();
            treeView.setId(String.valueOf(channel.getId()));
            treeView.setIcon("");
            treeView.setText(channel.getName());
            treeView.setChildren("0".equals(channel.getIsParent()));
            list.add(treeView);
        }

        return list;
    }



    /**
     * 排序
     * @param list
     * @param channels
     */
    public void sortChannelList(List<Channel> list, List<Channel> channels){
        for (Channel channel : channels) {
            if ("0".equals(channel.getIsParent())){
                list.add(channel);
                for (Channel subChannel : channels) {
                    if (subChannel.getPid().equals(channel.getId())){
                        list.add(subChannel);
                    }
                }
            }
        }
    }


}
