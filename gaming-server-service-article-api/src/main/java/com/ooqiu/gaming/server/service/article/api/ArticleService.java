package com.ooqiu.gaming.server.service.article.api;

import com.github.pagehelper.PageInfo;
import com.ooqiu.gaming.server.domain.Article;

/**
 * <p>Title: ArticleService </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 14:15 2018/3/9
 */

public interface ArticleService {
    /**
     * 分页查询全部文章
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return
     */
    public PageInfo<Article> selectAll(int pageNum, int pageSize);

    /**
     * 按频道查询文章
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param channelId 频道 ID
     * @return
     */
    public PageInfo<Article> selectByChannelId(int pageNum, int pageSize, Long channelId);

    /**
     * 按类型查询文章
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @param type 文章类型
     * @return
     */
    public PageInfo<Article> selectByType(int pageNum, int pageSize, String type);
}
