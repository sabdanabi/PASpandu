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

public class NewsHomeAdapter extends RecyclerView.Adapter<NewsTampilan.ViewHolder> {

    private List<News> localDataSet;

    public NewsAdapter(List<News> dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

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

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        NewsTampilan news = localDataSet.get(position);
        String title = news.getTitle();
        String thumbnail = news.getThumbnail();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyy-mm-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(releaseDate);
            simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
            releaseDate = simpleDateFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        viewHolder.tvMovieTitle.setText(title);
        viewHolder.tvReleaseDate.setText(releaseDate);
        viewHolder.tvMovieRating.setText(movieRating);

        Picasso.get()
                .load(urlPoster)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder_error)
                .into(viewHolder.imgMoviePoster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("movie_id",String.valueOf(movie.getId()));
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

