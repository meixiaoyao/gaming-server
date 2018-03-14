package com.ooqiu.gaming.server.service.article.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.domain.Article;
import com.ooqiu.gaming.server.service.article.api.ArticleService;
import com.ooqiu.gaming.server.service.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

/**
 * <p>Title: ArticleServiceImpl </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 14:23 2018/3/9
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_ARTICLE)
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 分页查询文章
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public PageInfo<Article> selectAll(int pageNum, int pageSize) {
        Example example = new Example(Article.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Article> pageInfo = new PageInfo<>(articleMapper.selectByExample(example));

        return pageInfo;
    }

    /**
     * 按类型查询文章
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param channelId 频道 ID
     * @return
     */
    @Override
    public PageInfo<Article> selectByChannelId(int pageNum, int pageSize, Long channelId) {
        Example example = new Example(Article.class);
        example.createCriteria().andEqualTo("channelId", channelId);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Article> pageInfo = new PageInfo<>(articleMapper.selectByExample(example));

        return pageInfo;
    }

    /**
     * 按类型查询文章
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param type 文章类型
     * @return
     */
    @Override
    public PageInfo<Article> selectByType(int pageNum, int pageSize, String type) {
        Example example = new Example(Article.class);
        example.createCriteria().andEqualTo("type", type);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Article> pageInfo = new PageInfo<>(articleMapper.selectByExample(example));

        return pageInfo;
    }
}
