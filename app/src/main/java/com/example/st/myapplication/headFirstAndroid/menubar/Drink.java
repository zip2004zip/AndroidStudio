package com.example.st.myapplication.headFirstAndroid.menubar;

import com.example.st.myapplication.R;

/**
 * Класс содержит подробную информацию о напитках;
 * также в приложении используются ресурсы изображений напитков и логотипа Bar menu
 */

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    //drinks — массив с элементами Drink
    public static final Drink[] drinks = {  //drinks — массив из трех объектов Drink
            new Drink("Latte", "A couple of espresso shots with steamed milk",
                    R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam",
                    R.drawable.cappuccino),
            new Drink("Tea", "A hot drink made by infusing the dried, crushed leaves of the tea plant in boiling water",
                    R.drawable.tea)
    };

    //Для каждого напитка хранится имя, описание и ресурс изображения
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}