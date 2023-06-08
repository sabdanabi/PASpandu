package com.example.pts_sabdanabi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pts_sabdanabi.databinding.ActivityDetailBinding;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class DetailActivity extends AppCompatActivity{
    private ActivityDetailBinding binding;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String newsId = intent.getStringExtra("movie_id");

        getDetailNews(newsId);
    }
    private void getDetailNews(String newsId){
        progressDialog = new ProgressDialog(DetailActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        ApiService service = APIHeadClient.getRetrofitInstance().create(ApiService.class);
        Call<NewsTampilan> call = service.getDetailNews(newsId);

        call.enqueue(new Callback<NewsTampilan>() {
            @Override
            public void onResponse(Call<NewsTampilan> call, Response<NewsTampilan> response) {
                progressDialog.dismiss();
                NewsTampilan newsberita = response.body();
                setDataUI(newsberita);
            }

            @Override
            public void onFailure(Call<NewsTampilan> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(DetailActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setDataUI(NewsTampilan news) {
        binding.newsTitle.setText(news.getTitle());
        binding.newsDesc.setText(news.getDescription());
        binding.date.setText(news.getPubDate());
//        binding.newsPoster.setImageResource(news.getThumbnail());
        setShareButton(news.getLink());


        /*String releaseDate = movie.getReleaseDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyy-mm-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(releaseDate);
            simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            releaseDate = simpleDateFormat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        binding.movieReleaseDate.setText(getString(R.string.release, releaseDate));*/


//        String baseUrlImage = getString(R.string.base_url_image_w500);
        String urlPoster = news.getThumbnail();
        Picasso.get()
                .load(urlPoster)
                .placeholder(R.drawable.image_placeholder)
                .error(R.drawable.image_placeholder_error)
                .into(binding.newsPoster);





    }
    private void setShareButton(String title) {
        binding.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this news");
                intent.putExtra(Intent.EXTRA_TEXT, title);
                startActivity(Intent.createChooser(intent, "Share via"));
            }
        });
    }
}

















