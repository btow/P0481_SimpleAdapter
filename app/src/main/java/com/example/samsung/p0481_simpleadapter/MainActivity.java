package com.example.samsung.p0481_simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //имена атрибутов для Map
    final String ATTRIBUTE_NAME_TEXT = "text",
                 ATTRIBUTE_NAME_CHECKED = "checked",
                 ATTRIBUTE_NAME_IMAGE = "image";
    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //данные размещены в файле strings.xml в массивах строк "texts" и чисел "checked"
        int[] checked = getResources().getIntArray(R.array.checked).clone();
        int img = R.mipmap.ic_launcher;
        //упаковываем данные в понятную для адаптера структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        int index = 0;
        for (String text :
                getResources().getStringArray(R.array.texts)) {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put(ATTRIBUTE_NAME_TEXT, text);
            map.put(ATTRIBUTE_NAME_CHECKED, checked[index] == 1);
            map.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(map);
            index++;
        }

        //массив имён атрибутов, из которых будут читаться данные
        String[] from = {ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED, ATTRIBUTE_NAME_IMAGE};
        //массив ID-компонетов, в которые будут вставляться данные
        int[] to = {R.id.tvText, R.id.cbChecked, R.id.ivImg};

        //создаём адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

        //создаём список и присваемаем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);

    }
}
