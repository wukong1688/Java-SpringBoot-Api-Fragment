package com.jack.api.service;

import com.jack.api.bean.NewsListBean;
import org.springframework.data.domain.Page;

/**
 * 新闻列表 业务 接口类
 */
public interface NewsListService {

    NewsListBean getNewsById(String id);

    Page<NewsListBean> getPageNewsList(int pageNum);

    Page<NewsListBean> getPageNewsListByType(String type, int pageNum);
}
