package com.example.st.myapplication.headFirstAndroid.menubar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.st.myapplication.R;

/**
 * DrinkActivity получает подробную информацию о напитке из файла класса Drink
 */

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Получить напиток из данных интента
        //Если интент содержит дополнительную информацию, для чтения такой информации используются методы get*() интента.
        //Следующий код читает значение EXTRA_DRINKNO из интента, запустившего DrinkActivity
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo]; // Используем drinkNo для получения подробной информации о напитке, выбранном пользователем

        //Заполнение изображения напитка
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        //Заполнение названия напитка
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        //Заполнение описания напитка
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(drink.getDescription());

    }
}