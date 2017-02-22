package com.hackspace.coreupgrade.presentation.presenters;

import com.hackspace.coreupgrade.data.ArticleEntity;
import com.hackspace.coreupgrade.data.TrackArticleHolder;
import com.hackspace.coreupgrade.network.ArticleRequest;
import com.hackspace.coreupgrade.network.ServiceGeneratorSimple;
import com.hackspace.coreupgrade.presentation.contracts.ListArticlesContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by manu on 21/02/17.
 */

public class ListArticlesPresenter implements ListArticlesContract.Presenter {

    ListArticlesContract.View mView;

    public ListArticlesPresenter(ListArticlesContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void getArticles() {
        ArticleRequest articleRequest = ServiceGeneratorSimple.createService(ArticleRequest.class);
        Call<TrackArticleHolder> call = articleRequest.getArticles("techcrunch","dd020a34d895453f8d78e8775fffd6ec");
        mView.setLoadingIndicator(true);
        call.enqueue(new Callback<TrackArticleHolder>() {
            @Override
            public void onResponse(Call<TrackArticleHolder> call, Response<TrackArticleHolder> response) {
                if(response.isSuccessful()){
                    mView.setLoadingIndicator(false);
                    TrackArticleHolder trackArticleHolder = response.body();
                    mView.setListArticles(trackArticleHolder.getArticles());
                }else{
                    mView.setLoadingIndicator(false);
                    mView.setError("No se pudo traer datos");
                }
            }

            @Override
            public void onFailure(Call<TrackArticleHolder> call, Throwable t) {
                mView.setLoadingIndicator(false);
                mView.setError("Ocurrio un error");
            }
        });
    }

    @Override
    public void start() {

    }
}
