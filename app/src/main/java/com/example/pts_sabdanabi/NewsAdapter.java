package com.example.pts_sabdanabi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsTampilan> localDataSet;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView newstitle;
        private final ImageView tnnewshome;

        public ViewHolder(View view) {
            super(view);

//            tvMovieTitle = view.findViewById(R.id.movie_name);
//            tvReleaseDate = view.findViewById(R.id.movie_release_date);
            newstitle = view.findViewById(R.id.news_name);
            tnnewshome = view.findViewById(R.id.picture);
        }
    }
    public NewsAdapter(List<NewsTampilan> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        NewsTampilan news = localDataSet.get(position);
        String title = news.getTitle();
        String thumbnail = news.getThumbnail();


        viewHolder.newstitle.setText(title);
        viewHolder.tnnewshome.setImageResource(Integer.parseInt(thumbnail));


        Picasso.get()
                .load(thumbnail)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder_error)
                .into(viewHolder.tnnewshome);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("news_title",String.valueOf(news.getTitle()));
                intent.putExtra("news_desc",String.valueOf(news.getDescription()));
                intent.putExtra("news_poster",String.valueOf(news.getThumbnail()));
                intent.putExtra("news_date",String.valueOf(news.getPubDate()));
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

