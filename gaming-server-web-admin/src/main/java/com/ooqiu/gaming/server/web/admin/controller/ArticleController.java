package com.ooqiu.gaming.server.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.server.service.admin.api.ArticleService;
import com.ooqiu.gaming.server.web.admin.dto.DataTable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 * <p>Title:  </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 11:25 2018/3/5
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {
    @Reference(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ADMIN)
    private ArticleService articleService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<Article> articles = articleService.searchAll();
        model.addAttribute("articles", articles);

        return "modules/article/list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(){
        return "modules/article/form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Article article){
        articleService.save(article);
        return "redirect:/article/list";
    }


    @ResponseBody
    @RequestMapping(value = "data")
    public DataTable<Article> data(HttpServletRequest request){
        String strPage = request.getParameter("datatable[pagination][page]");
        String strPageSize = request.getParameter("datatable[pagination][perpage]");

        int page = 1;
        int pageSize = 10;

        if (!StringUtils.isBlank(strPage)){
            page = Integer.parseInt(strPage);
        }
        if (!StringUtils.isBlank(strPageSize)){
            pageSize = Integer.parseInt(strPageSize);
        }

        PageInfo<Article> pageInfo = articleService.page(page, pageSize);
        return new DataTable<Article>(pageInfo);
    }
}
