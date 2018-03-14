package com.ooqiu.gaming.server.web.admin.dto;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/*
 * 前端数据表格
 * <p>Title: DataTable </p>
 * <p>Description: </p>
 *
 * @author: Eve
 * @version: 1.0.0
 * @Date: 17:28 2018/3/7
 */
@Data
public class DataTable<T> {
    private Mete mete;
    private List<T> data;

    public DataTable(PageInfo<T> pageInfo){
        data = pageInfo.getList();

        mete.setPage(pageInfo.getPageNum());
        mete.setPages(pageInfo.getPages());
        mete.setPerpage(pageInfo.getPageSize());
        mete.setTotal(pageInfo.getTotal());
    }

    @Data
    class Mete{
        // 页码
        private int page;
        // 总页数
        private int pages;
        // 笔数
        private int perpage;
        // 总笔数
        private long total;
        private String sort;
        private String field;
    }
}

