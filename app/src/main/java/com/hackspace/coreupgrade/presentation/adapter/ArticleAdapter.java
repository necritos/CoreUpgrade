package com.hackspace.coreupgrade.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hackspace.coreupgrade.R;
import com.hackspace.coreupgrade.data.ArticleEntity;
import com.hackspace.coreupgrade.presentation.adapter.components.LoaderAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by root on 15/12/16.
 */

public class ArticleAdapter extends LoaderAdapter<ArticleEntity> {

    private Context context;

    public ArticleAdapter(Context context, List<ArticleEntity> articleEntities) {
        super(context);
        this.context = context;
        setItems(articleEntities);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public long getYourItemId(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder getYourItemViewHolder(ViewGroup parent) {
        return new ViewHolder(mInflater.inflate(R.layout.item_article, parent, false));
    }

    @Override
    public void bindYourViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            ArticleEntity articleEntity = getmItems().get(position);
            viewHolder.tvTitle.setText(articleEntity.getTitle());
            Log.d("XD", articleEntity.getUrlToImage());
            Glide.with(viewHolder.ivArticle.getContext())
                    .load(articleEntity.getUrlToImage())
                    .centerCrop()
                    .into(viewHolder.ivArticle);

        }
    }

    public void setItem(ArticleEntity item) {
        addItem(item);

        //addItem(item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_article)
        ImageView ivArticle;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_data)
        TextView tvData;
;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
