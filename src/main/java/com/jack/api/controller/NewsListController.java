package com.jack.api.controller;

import com.jack.api.bean.NewsListBean;
import com.jack.api.dao.NewsListRepository;
import com.jack.api.http.Result;
import com.jack.api.http.ResultUtil;
import com.jack.api.service.NewsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsListController {
    @Autowired
    private NewsListService service;

    private NewsListRepository repository;

    @Autowired
    public NewsListController(NewsListRepository repository, NewsListService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public Result getNews(@PathVariable String id) {
        NewsListBean data = service.getNewsById(id);
        return ResultUtil.success(data);
    }

    @RequestMapping(value = "/list/{pageNum}", method = RequestMethod.GET)
    public Result getNewsList(@PathVariable int pageNum) {
        Page<NewsListBean> data = service.getPageNewsList(pageNum);
        return ResultUtil.success(data);
    }

    @RequestMapping(value = "/list/{typeId}/{pageNum}", method = RequestMethod.GET)
    public Page<NewsListBean> getNewsList(@PathVariable String typeId, @PathVariable int pageNum) {
        return service.getPageNewsListByType(typeId, pageNum);
    }


}
