package com.example.st.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SaveToFileActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eTextSaveToFile;
    private Button buttonSaveToFile;
    private FileOutputStream fileOutputStream;
    private final static String FILENAME = "SaveFile.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_to_file);

        eTextSaveToFile = (EditText) findViewById(R.id.editTextSaveToFile);
        buttonSaveToFile = (Button) findViewById(R.id.buttonSaveToFile);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSaveToFile:
                saveToFile(FILENAME);
                eTextSaveToFile.setText("");
                Toast.makeText(this, "Файл сохранен успешно!", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonOpenFromFile:
                openFromFile(FILENAME);
                Toast.makeText(this, "Файл открыт успешно!", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonDeleteFile:
                deleteFile(FILENAME);
                Toast.makeText(this, "Файл удален успешно!", Toast.LENGTH_LONG).show();
        }
    }

    // Метод для сохранения файла
    private void saveToFile(String fileName) {
        try {
            OutputStream outputStream = openFileOutput(fileName, 0);
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            osw.write(eTextSaveToFile.getText().toString());
            osw.flush();
            osw.close();
        } catch (Throwable t) {
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    // Метод для открытия файла
    private void openFromFile(String fileName) {
        try {
            InputStream inputStream = openFileInput(fileName);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                StringBuilder builder = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                inputStream.close();
                eTextSaveToFile.setText(builder.toString());
            }
        } catch (Throwable t) {
            Toast.makeText(this, "Файл не создан!\nСоздайте новый файл!", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

}


