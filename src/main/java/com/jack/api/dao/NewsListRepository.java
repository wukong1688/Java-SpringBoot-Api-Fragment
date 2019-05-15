package com.jack.api.dao;

import com.jack.api.bean.NewsListBean;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsListRepository extends MongoRepository<NewsListBean, String> {
    NewsListBean findById(ObjectId id);
}
