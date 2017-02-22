package com.hackspace.coreupgrade.presentation.activities;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.hackspace.coreupgrade.R;
import com.hackspace.coreupgrade.presentation.fragments.ListArticleFragment;
import com.hackspace.coreupgrade.presentation.presenters.ListArticlesPresenter;
import com.hackspace.coreupgrade.presentation.utils.ActivityUtils;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayShowTitleEnabled(true);
        ab.setTitle("Articles");
        if(savedInstanceState == null){
            ListArticleFragment listArticleFragment = (ListArticleFragment) getSupportFragmentManager().findFragmentById(R.id.frame_container);

            if(listArticleFragment == null){
                listArticleFragment = ListArticleFragment.newInstance();
                ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), listArticleFragment, R.id.frame_container);
            }
            new ListArticlesPresenter(listArticleFragment);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
