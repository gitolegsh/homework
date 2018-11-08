package com.example.oshemb.myapplication3;

//класс для отсупов между item в RecycleView

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int spaceHeight;

    public SpaceItemDecoration(int spaceHeight) {
        this.spaceHeight = spaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = spaceHeight;
        outRect.left = spaceHeight;
    }
}