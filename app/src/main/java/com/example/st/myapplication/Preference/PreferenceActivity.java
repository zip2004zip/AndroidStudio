package com.example.st.myapplication.Preference;

import android.os.Bundle;

import com.example.st.myapplication.R;

/**
 * Для упрощения работы с группой настроек Android предоставляет специальный тип activity - PreferenceActivity;
 * Оно умеет читать определенные xml-файлы и создавать из них экран с настройками
 * в папке res создал папку xml в которой создал файл prefsettings.xml
 * в котором создаю свой экран настроек, используя готовые компоненты;
 * android:key: устанавливает ключ настройки в SharedPreferences
 * android:title: название настройки для пользователя
 * android:summary: краткое описание по данной настройке для пользователя
 */

public class PreferenceActivity extends android.preference.PreferenceActivity { //наследоваться от класса PreferenceActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencesettings); // вместо setContentView() вызовем метод addPreferencesFromResource


    }
}
