package com.jack.api.service.impl;

import com.jack.api.bean.PageModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

public class PageRequest implements Serializable, Pageable {
    PageModel page;

    public void setPage(PageModel page) {
        this.page = page;
    }

    public PageModel getPage() {
        return page;
    }

    @Override
    public int getPageNumber() {
        return page.getPageNum();
    }

    @Override
    public int getPageSize() {
        return page.getPageSize();
    }

    @Override
    public long getOffset() {
        return (page.getPageNum() - 1) * page.getPageSize();
    }

    @Override
    public Sort getSort() {
        return page.getSort();
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
