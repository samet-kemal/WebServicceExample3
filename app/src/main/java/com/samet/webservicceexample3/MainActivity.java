package com.samet.webservicceexample3;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Adapter.InformationAdapter;
import Model.Information;
import RestAPI.RestApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    List<Information> photoList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();
        Request();
    }


    public void Initialize() {
        listView = findViewById(R.id.listViewPhotos);
    }

    public void Request() {
        photoList = new ArrayList<>();

        Call<List<Information>> service = RestApiClient.getInstance().getMyApi().getPhotoList();

        service.enqueue(new Callback<List<Information>>() {
            @Override
            public void onResponse(Call<List<Information>> call, Response<List<Information>> response) {

                if (response.isSuccessful()) {
                    photoList = response.body();
                    InformationAdapter adapter = new InformationAdapter(photoList, getApplicationContext());
                    listView.setAdapter(adapter);

                }
                Log.i("Answer", " " + photoList.size());
            }

            @Override
            public void onFailure(Call<List<Information>> call, Throwable t) {

            }
        });
    }


}