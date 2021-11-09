package com.example.projectlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {


        RecyclerView recyclerView;
        private List<Model> modelList;
        private  Model model;
        MainAdapter main;
        private String judul, deskripsi,tanggal,gambar;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            recyclerView = findViewById(R.id.recy);
            recyclerView.setHasFixedSize(true);
            getapi();
        }

        private void getapi() {

            modelList = new ArrayList<>();
            AndroidNetworking.get("https://newsapi.org/v2/top-headlines")
                    .addQueryParameter("country", "id")
                    .addQueryParameter("apiKey", "70c9c73cd4764e449efbf91d4fd3a065")
//                .addQueryParameter("language", "en-US")
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("Response: ", "yes");
                            try {
                                JSONArray resultArray = response.getJSONArray("articles");
                                for (int i = 0; i < resultArray.length(); i++) {
                                    JSONObject resultObj = resultArray.getJSONObject(i);
                                    judul = resultObj.getString("title");
                                    deskripsi = resultObj.getString("description");
                                    gambar = resultObj.getString("urlToImage");
                                    tanggal = resultObj.getString("publishedAt");
                                    modelList.add(new Model(judul, deskripsi,tanggal, gambar));
                                }

                                main = new MainAdapter(modelList, MainActivity.this, new MainAdapter.Callback() {
                                    @Override
                                    public void call(int position) {
                                        Model Operator = modelList.get(position);
                                        Intent move = new Intent(getApplicationContext(), DetailActivity.class);
                                        move.putExtra("deskripsi", Operator.getDeskripsi());
                                        move.putExtra("judul", Operator.getJudul());
                                        move.putExtra("tanggal", Operator.getTanggal());
                                        move.putExtra("gambar", Operator.getGambar());
                                        startActivity(move);
                                    }
                                });
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                                recyclerView.setLayoutManager(layoutManager);
                                recyclerView.setAdapter(main);

                            } catch (Exception e) {
                                Log.d("Error: ", e.toString());
                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            Toast.makeText(getApplicationContext(), "Something error", Toast.LENGTH_SHORT).show();
                        }

                    });
        }
    }