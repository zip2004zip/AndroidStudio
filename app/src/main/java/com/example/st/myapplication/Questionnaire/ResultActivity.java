package com.example.st.myapplication.Questionnaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.st.myapplication.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView listView;

        Gson gson = new Gson();
        Questionnaire questionnaire;

        listView = (ListView) findViewById(R.id.listView);

        // принимаем из QuestionnaireActivity
        questionnaire = gson.fromJson(getIntent().getStringExtra("Json"), Questionnaire.class);

        List<String> stringList = new ArrayList<>();
        stringList.add("Имя: " + questionnaire.getFirstName());
        stringList.add("Фамилия: " + questionnaire.getLastName());
        stringList.add("Дата и время" + questionnaire.getDateAndTimeOfArrive().toString());
        stringList.add("Ночей: " + String.valueOf(questionnaire.getNights()));
       // stringList.add(questionnaire.getSex());
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view, stringList);
        listView.setAdapter(stringArrayAdapter);
    }

}
