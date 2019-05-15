package com.jack.api.controller;

import com.jack.api.bean.NewsListBean;
import com.jack.api.dao.NewsListRepository;
import com.jack.api.http.Result;
import com.jack.api.http.ResultUtil;
import com.jack.api.service.NewsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private NewsListService service;
    private NewsListRepository repository;

    @Autowired
    public TestController(NewsListRepository repository, NewsListService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping("/index")
    public String sayHello() {
        return "index!";
    }

    @RequestMapping("/err")
    public String err() throws Exception {
        throw new Exception("error");
    }

    @RequestMapping("/err_ret")
    public Result errRet() {
        return ResultUtil.fail("数据为空或获取失败!");
    }

    @RequestMapping(value = "/success_ret/{id}", method = RequestMethod.GET)
    public Result success(@PathVariable String id) {
        NewsListBean bean = service.getNewsById(id);
        return ResultUtil.success("获取详细信息", bean);
    }

}