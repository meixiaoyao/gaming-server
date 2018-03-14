package com.ooqiu.gaming.server.service.search.api;

import com.ooqiu.gaming.server.service.search.domain.SearchResult;

import java.util.List;

/**
 * <p>Title: SearchService </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 16:46 2018/3/13
 */
public interface SearchService {
    public List<SearchResult> search(String query, int page, int row);
}
