package com.example.imagefragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class FullImage extends Activity {
    ImageView img;
    String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_full);

        Intent intent = getIntent();
        url = intent.getExtras().getString("url");
        img = findViewById(R.id.imageView);

        Picasso.get()
                .load(url)
                .resize(1000,1000)
                .into(img);

    }

    public void returnHome(View view){
        Intent intent = new Intent(getApplication(), MainActivity.class);
        intent.putExtra("history", url);
        startActivity(intent);
    }
}
