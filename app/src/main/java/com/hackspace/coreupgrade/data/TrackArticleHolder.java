package com.hackspace.coreupgrade.data;


import java.util.List;

/**
 * Created by Leo on 01/02/2016.
 */
public class TrackArticleHolder {

    public String status;
    public List<ArticleEntity> articles;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }
}
