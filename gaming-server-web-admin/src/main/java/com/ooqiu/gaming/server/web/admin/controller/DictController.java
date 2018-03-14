package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Dict;
import com.ooqiu.gaming.server.service.admin.api.DictService;
import com.ooqiu.gaming.server.web.admin.dto.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: DictController </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 1:54 2018/3/9
 */
@Controller
@RequestMapping(value = "dict")
public class DictController {
    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private DictService dictService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    private String list(){
        return "modules/dict/list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(){
        return "modules/dict/form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Dict dict){
        int result = dictService.save(dict);
        return "redirect:/dict/list";
    }

    /**
     * Ajax 请求用数据集
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "data")
    public DataTable<Dict> data(HttpServletRequest request){
        String strPageNum = request.getParameter("datatable[pagination][page]");
        String strPageSize = request.getParameter("datatable[pagination][prepage]");

        int pageNum = StringUtils.isBlank(strPageNum) ? 1 : Integer.parseInt(strPageNum);
        int pageSize = StringUtils.isBlank(strPageSize) ? 10 :Integer.parseInt(strPageSize);

        PageInfo<Dict> pageInfo = dictService.page(pageNum, pageSize);
        return new DataTable<>(pageInfo);
    }
}
