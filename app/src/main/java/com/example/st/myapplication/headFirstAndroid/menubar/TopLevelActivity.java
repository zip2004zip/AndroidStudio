package com.example.st.myapplication.headFirstAndroid.menubar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.st.myapplication.R;

/**
 * Атрибут android:onClick в макетах может использоваться только для кнопок или любых представлений,
 * являющихся субклассами Button, например CheckBox и RadioButton.
 * Класс ListView не является субклассом Button, поэтому решение с атрибутом android:onClick не работает.
 * Именно поэтому приходится создавать свою реализацию слушателя.
 */

public class TopLevelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        // OnItemClickListener отслеживает щелчки на вариантах списка, а метод onItemClick() определяет реакцию активности на щелчок
        AdapterView.OnItemClickListener onItemClickListener =
                new AdapterView.OnItemClickListener() { //OnItemClickListener - вложенный класс по отношению к классу AdapterView. ListView - субкласс AdapterView.
                    @Override
                    public void onItemClick(AdapterView<?> listView, View view, int position, long id) {

                        // действие при щелчке варианте
                        if (position == 0) {
                            Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                            startActivity(intent);
                        }
                    }
                };
        //Добавляем слушателя к списковому представлению при помощи метода setOnItemClickListener() класса ListView
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(onItemClickListener);
    }
}

/**
 * При создании активности TopLevelActivity мы связали данные со списковым представлением при помощи атрибута android:entries в XML макета.
 * Такое решение работает, потому что данные хранятся в виде ресурса статического массива строк. Массив описан в файле strings.xml,
 * Атрибут android:entries подходит только для данных, представленных статическим массивом в strings.xml.
 * А если в приложении используется другой способ хранения? Что, если данные хранятся в массиве, созданном на программном уровне в коде Java, или в базе данных?
 * В этом случае атрибут android:entries не работает.
 */
