package com.ooqiu.gaming.server.service.search.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.ooqiu.gaming.server.commons.constant.DubboVersionConstant;
import com.ooqiu.gaming.server.service.search.api.SearchService;
import com.ooqiu.gaming.server.service.search.domain.SearchResult;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: SearchServiceImpl </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 16:54 2018/3/13
 */
@Service(version = DubboVersionConstant.DUBBO_VERSION_GAMING_SERVER_SERVICE_SEARCH)
public class SearchServiceImpl implements SearchService{
    @Autowired
    private SolrClient solrClient;

    @Override
    public List<SearchResult> search(String query, int page, int row) {
        List<SearchResult> searchResults = Lists.newArrayList();
        // 创建查询对象
        SolrQuery solrQuery = new SolrQuery();

        // 设置查询条件
        solrQuery.setQuery(query);

        // 设置分页
        solrQuery.setStart((page-1)*row);
        solrQuery.setRows(row);

        // 设置默认搜索域
        solrQuery.set("df", "article_keywords");

        // 设置高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("article_title");
        solrQuery.setHighlightSimplePre("<span style='color:red'>");
        solrQuery.setHighlightSimplePost("</span>");

        try{
            // 执行查询操作
            QueryResponse queryResponse = solrClient.query("ik_core", solrQuery);
            SolrDocumentList solrDocuments = queryResponse.getResults();
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            for (SolrDocument solrDocument : solrDocuments) {
                SearchResult result = new SearchResult();
                result.setId((String) solrDocument.get("id"));
                result.getArticle_title(solrDocument.get("article_title"));
                result.getArticle_title(solrDocument.get("article_source"));
                result.getArticle_title(solrDocument.get("article_url"));
                result.getArticle_title(solrDocument.get("article_introduction"));
                result.getArticle_title(solrDocument.get("article_cover"));

                String articleTile = "";
                List<String> list = highlighting.get(solrDocument.get("id")).get("article_title");
                if(list != null && list.size()>0){
                    articleTile = list.get(0);
                }else {
                    articleTile = (String) solrDocument.get("article_title");
                }
                result.setArticle_title(articleTile);
                searchResults.add(result);
            }
        }catch (SolrServerException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return searchResults;
    }
}
