package com.hackspace.coreupgrade.presentation.contracts;


import com.hackspace.coreupgrade.core.BasePresenter;
import com.hackspace.coreupgrade.core.BaseView;
import com.hackspace.coreupgrade.data.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yonkou Jean on 21/11/16.
 */

public interface ListArticlesContract {

    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);
        void setListArticles(List<ArticleEntity> entities);

    }


    interface Presenter extends BasePresenter {
        void getArticles();
    }
}

