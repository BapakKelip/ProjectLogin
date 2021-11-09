package com.example.projectlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {
        String judul, tanggal, deskripsi, gambar;
        Bundle bundle;
        TextView txt_judul, txt_date, txt_deskripsi;
        ImageView img;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            txt_judul= (TextView) findViewById(R.id.txt_judul);
            txt_date = (TextView) findViewById(R.id.txt_date);
            img = (ImageView) findViewById(R.id.imgberita);
            txt_deskripsi = (TextView) findViewById(R.id.txt_deskripsi);
            bundle = getIntent().getExtras();
            if (bundle != null) {
                judul = bundle.getString("judul");
                deskripsi = bundle.getString("deskripsi");
                gambar = bundle.getString("gambar");
                tanggal = bundle.getString("tanggal");

                txt_judul.setText(judul);
                txt_date.setText(tanggal);
                txt_deskripsi.setText(deskripsi);
                Picasso.get()
                        .load(gambar)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher_round)
                        .into(img);
            }

        }
    }