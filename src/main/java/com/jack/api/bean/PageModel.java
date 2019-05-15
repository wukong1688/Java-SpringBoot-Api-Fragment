package com.jack.api.bean;


import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * 分页模型
 */
public class PageModel  implements Serializable {
    // 当前页
    private Integer pageNum = 1;
    // 当前页面条数
    private Integer pageSize = 10;
    // 排序条件
    private Sort sort;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
