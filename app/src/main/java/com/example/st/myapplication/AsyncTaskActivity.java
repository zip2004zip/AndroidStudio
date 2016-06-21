package com.example.st.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ProgressBar progressBar;
    TextView tView;

    AsyncTask<String, Integer, Boolean> asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        button = (Button) findViewById(R.id.buttonAsyncTask);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tView = (TextView) findViewById(R.id.textViewAsyncTaskProgressBar);

        asyncTask = new AsyncTask<String, Integer, Boolean>() {

            @Override
            protected void onPostExecute(Boolean aVoid) {
                super.onPostExecute(aVoid);

            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                int i = values[0] * 10;
                progressBar.setProgress(i);
                tView.setText(String.valueOf(i));
            }

            @Override
            protected Boolean doInBackground(String... params) {
                try {
                    for (int i = 0; i < 101; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        publishProgress(i);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }

        };
    }


    @Override
    public void onClick(View v) {
        asyncTask.execute("DED");
    }
}
