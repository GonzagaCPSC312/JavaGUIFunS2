package com.sprint.gina.javaguifuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // everything we have done so far in XML w/layouts and views
        // can be done with Java OOP at runtime
        // example: suppose you prompt the user for N, and you use N to populate
        // a NxN Boggle grid

        // demos
        // 1. hardcoded 2x2 grid of buttons that equally share available screen space
        // recreation from ConstraintLayoutFun
        // following MVC design pattern
        // View: prior this was XML file... now this is going to be a subclass of ConstraintLayout
        // Controller: still MainActivity

        // 2. challenge task for you to try later.... solve the dynamic NxN problem above

        MyConstraintLayout layout = new MyConstraintLayout(this);
//        setContentView(R.layout.activity_main);
        setContentView(layout);
    }
}