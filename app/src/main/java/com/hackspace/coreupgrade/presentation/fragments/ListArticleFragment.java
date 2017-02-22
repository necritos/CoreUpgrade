package com.hackspace.coreupgrade.presentation.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hackspace.coreupgrade.R;
import com.hackspace.coreupgrade.data.ArticleEntity;
import com.hackspace.coreupgrade.presentation.adapter.ArticleAdapter;
import com.hackspace.coreupgrade.presentation.adapter.components.ScrollChildSwipeRefreshLayout;
import com.hackspace.coreupgrade.presentation.contracts.ListArticlesContract;
import com.hackspace.coreupgrade.presentation.presenters.ListArticlesPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manu on 21/02/17.
 */

public class ListArticleFragment extends Fragment implements ListArticlesContract.View {

    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;
    @BindView(R.id.ll_articles)
    LinearLayout llArticles;
    @BindView(R.id.tv_dont_articles)
    TextView tvDontArticles;
    @BindView(R.id.ll_dont_articles)
    LinearLayout llDontArticles;
    @BindView(R.id.rl_container_articles)
    RelativeLayout rlContainerArticles;
    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout refreshLayout;
    ArticleAdapter articleAdapter;
    ListArticlesContract.Presenter mPresenter;
    private LinearLayoutManager linearLayoutManager;


    public static ListArticleFragment newInstance() {
        ListArticleFragment fragment = new ListArticleFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_layout_articles, container, false);
        ButterKnife.bind(this, root);
        final ScrollChildSwipeRefreshLayout srl = (ScrollChildSwipeRefreshLayout) root.findViewById(R.id.refresh_layout);
        srl.setColorSchemeColors(ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));

        srl.setScrollUpChild(rvArticles);

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getArticles();
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvArticles.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvArticles.setLayoutManager(linearLayoutManager);
        articleAdapter = new ArticleAdapter(getContext(), new ArrayList<ArticleEntity>());
        rvArticles.setAdapter(articleAdapter);
        mPresenter.getArticles();
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout srl = (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void setListArticles(List<ArticleEntity> entities) {
        if (rvArticles != null && articleAdapter != null) {
            articleAdapter.setItems(entities);
            if (entities.size() > 0) {
                llDontArticles.setVisibility(View.GONE);
            } else {
                llDontArticles.setVisibility(View.VISIBLE);
            }
        } else {
            llDontArticles.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setPresenter(ListArticlesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setError(String msg) {
        Snackbar.make(getView(), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
