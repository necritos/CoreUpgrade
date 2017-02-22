package com.hackspace.coreupgrade.presentation.adapter.components;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.hackspace.coreupgrade.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yonkou Jean on 11/12/16.
 */

public class LoaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    public LoaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
