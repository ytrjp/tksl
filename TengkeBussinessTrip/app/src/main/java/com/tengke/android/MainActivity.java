package com.tengke.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.text_view) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<String> array = new ArrayList<>();

        textView.setOnClickListener(v-> {

        });

        new Thread(()->{}).start();

        List languages = Arrays.asList("java", "Scala", "Java", "C++");

        languages.();

    }

}


 class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
        return 0;
    }

    public void printPerson() {
        // ...
    }
 }
