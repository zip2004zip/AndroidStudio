package com.example.st.myapplication.headFirstAndroid.menubar;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Активность DrinkCategoryActivity содержит список всех имеющихся напитков. получает данные напитков из класса Drink
 * При выборе напитка должна открываться активность DrinkActivity и передаваться ей информация о том, на каком напитке был сделан щелчок
 */

public class DrinkCategoryActivity extends ListActivity { //Активность должна расширять класс ListActivity вместо Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_drink_category); тут мы не используем макет,
        // потому что списковые активности определяют собственный макет (он создан андроид, но можно и свой создать)

        ListView listDrinks = getListView();
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(this, android.R.layout.simple_list_item_1, Drink.drinks);
        listDrinks.setAdapter(listAdapter);
    }

    /**
     * активность DrinkCategoryActivity запускает активность DrinkActivity и сообщает ей, какой напиток был выбран
     * Передача данных активности с использованием метода onListItemClick() класса ListActivity
     * При использовании списковой активности для вывода категорий метод onListItemClick() обычно используется для запуска другой активности,
     * которая выводит подробное описание варианта, выбранного пользователем
     */
    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        Intent intent = new Intent(this, DrinkActivity.class);
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }
}


/**
 * Если данные спискового представления (ListView) должны поступать из нестатического источника (например, из массива Java или базы данных), необходимо использовать адаптер.
 * Адаптер играет роль моста между источником данных и списковым представлением.
 * В нашем примере источником данных будет массив Drink.drinks, но с таким же успехом можно использовать базу данных или веб-службу.
 * <p/>
 * Адаптер заполняет пробел между списковым представлением и источником данных.
 * Адаптеры позволяют списковым представлениям выводить информацию из самых разнообразных источников.
 * <p/>
 * При инициализации адаптера массива вы сначала указываете тип данных массива, который вы хотите связать со списковым представлением.
 * Затем адаптеру передаются три параметра: Context (обычно текущая активность), ресурс макета, который определяет, как должен отображаться каждый элемент из массива, и сам массив.
 */