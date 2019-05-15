package com.jack.api.service.impl;

import com.jack.api.bean.NewsListBean;
import com.jack.api.bean.PageModel;
import com.jack.api.dao.NewsListRepository;
import com.jack.api.service.NewsListService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsListServiceImpl implements NewsListService {
    @Autowired
    MongoTemplate mongoTemplate;

    private final NewsListRepository repository;

    @Autowired
    NewsListServiceImpl(NewsListRepository repository) {
        this.repository = repository;
    }

    public NewsListBean getNewsById(String id) {
        return repository.findById(new ObjectId(id));
    }

    public Page<NewsListBean> getPageNewsList(int pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        PageRequest pageable = new PageRequest();
        PageModel pm = new PageModel();
        Query query = new Query();

//        List<Order> orders = new ArrayList<Order>();  //排序
//        orders.add(new Order(Sort.Direction.DESC, "created"));
        Sort sort = new Sort(Sort.Direction.DESC, "created");
        // 开始页
        pm.setPageNum(pageNum);
        // 每页条数
        pm.setPageSize(5);
        // 排序
        pm.setSort(sort);
        pageable.setPage(pm);
        // 查询出一共的条数
        Long count = mongoTemplate.count(query, NewsListBean.class);
        // 查询
        List<NewsListBean> list = mongoTemplate.find(query.with(pageable), NewsListBean.class);
        // 将集合与分页结果封装
        Page<NewsListBean> pageList = new PageImpl<NewsListBean>(list, pageable, count);
        return pageList;
    }

    @Override
    public Page<NewsListBean> getPageNewsListByType(String type, int pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        PageRequest pageable = new PageRequest();
        PageModel pm = new PageModel();
        Query query = new Query();

//        List<Order> orders = new ArrayList<Order>();  //排序
//        orders.add(new Order(Sort.Direction.DESC, "created"));
        Sort sort = new Sort(Sort.Direction.DESC, "created");
        // 开始页
        pm.setPageNum(pageNum);
        // 每页条数
        pm.setPageSize(5);
        // 排序
        pm.setSort(sort);
        pageable.setPage(pm);
        // 查询出一共的条数
        Long count = mongoTemplate.count(query, NewsListBean.class);
        // 查询
        List<NewsListBean> list = mongoTemplate.find(query.with(pageable), NewsListBean.class);
        // 将集合与分页结果封装
        Page<NewsListBean> pageList = new PageImpl<NewsListBean>(list, pageable, count);
        return pageList;
    }
}
