package com.example.st.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImageActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ImageView imageView;
    AsyncTask<String, Void, Bitmap> asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);

        button = (Button) findViewById(R.id.buttonDownloadImage);
        imageView = (ImageView) findViewById(R.id.imageViewDownload);
        asyncTask = new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                return download("http://www.bmwclub.by/images/banners/bmwclub1.jpg");
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
            }
        };
    }

    @Override
    public void onClick(View v) {
        asyncTask.execute();
    }

    static Bitmap download(String url) {
        Bitmap bitmap = null;

        try {
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);
            bufferedInputStream.close();
            inputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}


