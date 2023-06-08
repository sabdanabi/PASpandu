package com.example.pts_sabdanabi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pts_sabdanabi.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.news.setLayoutManager(new GridLayoutManager(this, 1));
        getPopularNews();
    }

    private void getPopularNews() {


        ApiService service = APIHeadClient.getRetrofitInstance().create(ApiService.class);
        Call<ResponseNews> callNewsList = service.getDetailNews();

        callNewsList.enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                List<PostsItem> news = response.body().getData().getPosts();

                NewsAdapter adapter = new NewsAdapter(news);
                binding.news.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}