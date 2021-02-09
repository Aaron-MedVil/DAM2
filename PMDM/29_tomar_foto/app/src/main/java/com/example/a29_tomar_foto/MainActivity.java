package com.example.a29_tomar_foto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imgCamera;
    private String currentPhotoPath;
    private  Uri photoURI = null;

    /**
     * Metodo que se ejecuta cuando se crea la actividad
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCamera = findViewById(R.id.imgCamera);
    }

    /**
     * Metodo que se ejecuta cuando se pulsa la imagen y abre la camara
     * @param view
     */
    public void onClickCamera(View view) {

        // Crea un intent para abrir la camara
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Comprueba que existe alguna aplicacion para realizar el intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            // Inicia la actividad que abre la camara
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            // Comprueba si se ha creado la imagen correctamente
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                // Crea el fichero donde se guardara la imagen
                File photoFile = null;

                // Obtiene el fichero de la imagen del metodo createImageFile()
                try { photoFile = createImageFile(); }
                catch (IOException ex) {}

                // Comprueba si se ha creado el fichero
                if (photoFile != null) {

                    // Crea el uri de la foto
                    photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);

                    // Guarda la imagen en el sistema de archivos
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                }
            }
        }
    }

    /**
     * Metodo que se ejecuta cuando se toma la foto
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgCamera.setImageBitmap(imageBitmap);

            // Bitmap imageBitmap = BitmapFactory.decodeFile(currentPhotoPath);
            // imgCamera.setImageBitmap(imageBitmap);
        }
    }

    /**
     * Guarda una imagen en el sistema de ficheros
     * @return
     * @throws IOException
     */
    private File createImageFile() throws IOException {

        // Crea el nombre del fichero usando la fecha actual
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";

        // Obtiene la ruta del directorio donde se almacenara el fichero
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        // Obtiene el path de a imagen
        currentPhotoPath = image.getAbsolutePath();

        // Devuelve la imagen
        return image;
    }
}