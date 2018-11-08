package com.example.oshemb.myapplication3;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.oshemb.myapplication3.Data.DataUtils;

public class NewsListActivity extends AppCompatActivity {

    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        bar = findViewById(R.id.progressBar);

        showBar(true);

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final NewsAdapter newAdap = new NewsAdapter(NewsListActivity.this, DataUtils.generateNews());


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(newAdap);
                        showBar(false);
                    }
                });

            }}).start();



        //смотрим как расположить элементы
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }

        recyclerView.addItemDecoration(new SpaceItemDecoration(dpToPx(4)));
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_switch:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //переводим dp в px
    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private void showBar(boolean bool){
        if (bool){
            bar.setVisibility(View.VISIBLE);
        }
        else {
            bar.setVisibility(View.INVISIBLE);
        }

    }

}
