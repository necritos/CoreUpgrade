package com.hackspace.coreupgrade.data;

import java.io.Serializable;

/**
 * Created by manu on 21/02/17.
 */

public class ArticleEntity implements Serializable {
    String title;
    String urlToImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
