package com.example.ejercicio_persistencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.companion.WifiDeviceFilter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityAcceso extends AppCompatActivity {

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    private File photoFile = null;
    private String currentPhotoPath, fichero_externo = "fichero_externo.txt", fichero_interno = "fichero_interno.txt";

    private ImageView img_camera;
    private EditText texto_guardar;
    private RadioButton rb_interno, rb_externo;

    /**
     * Metodo que se ejecuta al crear la actividad
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        img_camera = findViewById(R.id.img_camera);
        texto_guardar = findViewById(R.id.texto_guardar);
        rb_interno = findViewById(R.id.rb_interno);
        rb_externo = findViewById(R.id.rb_externo);
    }

    /**
     * Metodo que se ejecuta al pulsar sobre la imagen de la camara
     * @param view
     */
    public void img_camera(View view) {

        // Creamos el intent para abrir la camara
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Comprobamos que existen aplicaciones que puedan ejecutar el intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            // Creamos el fichero de la imagen
            try { photoFile = createImageFile(); }
            catch(IOException ex) {}

            if (photoFile != null) {

                // Creamos el URI de la imagen
                Uri photoUri = FileProvider.getUriForFile(this, "com.example.ejercicio_persistencia.fileprovider", photoFile);

                // Enviamos la imagen al intent y abrimos la actividad de la camara
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    /**
     * Guarda una imagen en el sistema de ficheros
     * @return
     * @throws IOException
     */
    private File createImageFile() throws IOException {

        // Crea el nombre del fichero
        String imageFileName = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";

        // Obtiene la ruta donde se almacenan las imagenens y crea el fichero
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);

        // Obtiene el path de la imagen
        currentPhotoPath = image.getAbsolutePath();

        // Devuelve el fichero
        return image;
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

        // Si la imagen se ha tomado correctamente se muestra en el ImageView del layout
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap imageBitmap = BitmapFactory.decodeFile(currentPhotoPath);
            img_camera.setImageBitmap(imageBitmap);
        }
    }

    /**
     * Metodo que se ejecuta al pulsar el boton de guardar
     * @param view
     */
    public void btn_guardar(View view) {

        if (rb_interno.isChecked()) { almacenamientoInterno(); }
        else if (rb_externo.isChecked()) { almacenamientoExterno(); }
        else { Toast.makeText(this, "No ha seleccionado dónde guardar el texto", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Guarda el contenido del EditText en el almacenamiento externo
     */
    private void almacenamientoExterno() {

        // Comprueba si el almacenamiento externo esta disponible
        if (!isExternalStorageReadable()) {

            File fileExt = new File(getExternalFilesDir("directorio_externo"), fichero_externo);
            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(fileExt);
                fos.write(texto_guardar.getText().toString().getBytes());
                fos.close();

                Toast.makeText(this, "Archivo guardado correctamente", Toast.LENGTH_SHORT).show();
            }
            catch (IOException ioErr) { Toast.makeText(this, "Error al guardar el fichero", Toast.LENGTH_SHORT).show(); }
        }
        else { Toast.makeText(this, "El almacenamiento exteno no está disponible", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Guarda el contenido del EditText en el almacenamiento interno
     */
    private void almacenamientoInterno() {

        String archivos[] = fileList();

        // Si no existe el fichero en el sistema de ficheros lo crea
        if (!archivoExiste(archivos, fichero_interno)) { File file = new File(this.getFilesDir(), fichero_interno); }

        // Guarda el contenido del EditText en el fichero
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(fichero_interno, Activity.MODE_PRIVATE));
            archivo.write(texto_guardar.getText().toString());
            archivo.flush();
            archivo.close();

            Toast.makeText(this, "Archivo guardado correctamente", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ioErr) { Toast.makeText(this, "Error al guardar el fichero", Toast.LENGTH_SHORT).show(); }
    }

    /**
     * Comprueba si un fichero existe en el sistema de ficheros
     * @param archivos
     * @param nombreArchivo
     * @return
     */
    private boolean archivoExiste(String archivos[], String nombreArchivo) {

        boolean rtn = false;
        for (String nombre:archivos) { if (nombre.equals(nombreArchivo)) { rtn = true; } }
        return rtn;
    }

    /**
     * Comprueba que se puede escribir en el almacenamiento interno
     * @return
     */
    private boolean isExternalStorageReadable() {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED || Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED_READ_ONLY;
    }
}