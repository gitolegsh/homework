package com.example.oshemb.myapplication3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.oshemb.myapplication3.Data.NewsItem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.text.format.DateUtils.MINUTE_IN_MILLIS;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final List<NewsItem> news;
    private final LayoutInflater inflater;
    private final Context context;


    public NewsAdapter(Context context, List<NewsItem> news) {
        this.news = news;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_row, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final NewsItem newsItem = news.get(position);

        holder.categoryView.setText(newsItem.getCategory().getName());
        holder.titleView.setText(newsItem.getTitle());
        holder.contentView.setText(newsItem.getPreviewText());
        holder.dateView.setText(newsItem.getPublishDate().toString());
        System.out.println(newsItem.getPublishDate().toString());
        Glide.with(context).load(newsItem.getImageUrl()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //(Context context, String title, String imageUrl, String category, String publishDate, String previewText, String fullText)
                NewsDetailsActivity.startActyvity(context, newsItem.getTitle(), newsItem.getImageUrl(), newsItem.getCategory().getName(), newsItem.getPublishDate().toString(), newsItem.getPreviewText(), newsItem.getFullText());
            }
        });

    }

    @Override
    public int getItemCount() {
        return news.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryView;
        private final TextView titleView;
        private final TextView contentView;
        private final TextView dateView;
        private final ImageView imageView;

         ViewHolder(View itemView) {
            super(itemView);
             categoryView =  itemView.findViewById(R.id.text_view_category);
             titleView =  itemView.findViewById(R.id.text_view_title);
             contentView =  itemView.findViewById(R.id.text_view_content);
             dateView =  itemView.findViewById(R.id.text_view_date);
             imageView =  itemView.findViewById(R.id.imageView);
        }
    }


}
