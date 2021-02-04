package com.example.a28_imagenes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    static final int REQUEST_IMAGE_GET = 1;

    /**
     * Metodo que se ejecuta al crear la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
    }

    /**
     * Metodo que se ejecuta cuando se pulsa la imagen
     * @param view
     */
    public void imgClick(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }

    /**
     * Carga la imagen seleccionada
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {

            Uri imagePath = data.getData();
            Bitmap thumbnail = null;

            try { thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath); }
            catch (IOException e) { e.printStackTrace(); }

            image.setImageBitmap(thumbnail);
        }
    }
}