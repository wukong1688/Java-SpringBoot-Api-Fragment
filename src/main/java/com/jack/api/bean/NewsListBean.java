package com.jack.api.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NewsList")
public class NewsListBean {

    /**
     * id : 7887ac49ba423f56a3e3a6bfc6b837eb
     * title : IBTM China 2019特邀买家注册系统即将开启
     * md5Title : 7887ac49ba423f56a3e3a6bfc6b837eb
     * md5Url : ce14816ab627143714019b46e8c0eed0
     * sourceId : 5cdaf2e33c254d0fa8005f25
     * sourceName : MICE
     * thumbUrl : http://www.mice.cn/uploadpic/newslogo/2019/3/29/162554107.jpg
     * sourceUrl : http://www.mice.cn/news/3420
     * desc : http://www.mice.cn/news/3420
     * content : http://www.mice.cn/news/3420
     * status : NumberInt(1)
     * created : NumberInt(1557896091)
     */
    @Id
    private String id;
    private String title;
    private String sourceName;
    private String thumbUrl;
    private String content;
    private int status;
    private int created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }
}
