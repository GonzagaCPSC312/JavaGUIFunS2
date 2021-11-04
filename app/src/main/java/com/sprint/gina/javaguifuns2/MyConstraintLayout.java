package com.sprint.gina.javaguifuns2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MyConstraintLayout extends ConstraintLayout {
    public MyConstraintLayout(@NonNull Context context) {
        super(context);

        // first, we need to set some "attributes" for our constraint layout
        this.setId(View.generateViewId());
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        setBackgroundColor(getResources().getColor(R.color.purple_200));

        // next, we need to start setting up child views and constraints
        // but first...
        // 2 ways to setup the constraints
        // 1. using ConstraintLayout.LayoutParams and setting cosntraint values
        // directly
        // bottomToBottomOf
        // 2. using the ConstraintSet convenience class to indirectly set up the
        // constraint values
        // we will do 2. because it is the preferred approach
        // I do not recommend mixing the approaches (pick one)

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this); // initializes parameters like the parent id

        // add child views and connect then using the constraint set
        hardcoded2by2Grid(context, constraintSet);
        // TODO: comment out the above call and call a new function to solve
        // challenge task #2 described in MainActivity

        constraintSet.applyTo(this);
    }

    // solution to demo #1
    void hardcoded2by2Grid(Context context, ConstraintSet constraintSet) {
        Button button00 = new Button(context);
        button00.setId(View.generateViewId());
        button00.setText("00");
        addView(button00);

        Button button01 = new Button(context);
        button01.setId(View.generateViewId());
        button01.setText("01");
        addView(button01);

        Button button10 = new Button(context);
        button10.setId(View.generateViewId());
        button10.setText("10");
        addView(button10);

        Button button11 = new Button(context);
        button11.setId(View.generateViewId());
        button11.setText("11");
        addView(button11);

        // set up button00's width and height
        constraintSet.constrainWidth(button00.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.constrainHeight(button00.getId(), ConstraintSet.MATCH_CONSTRAINT);
        // now, button00 needs at least one horiz and one vert constraint
        constraintSet.connect(button00.getId(), ConstraintSet.START,
                ConstraintSet.PARENT_ID, ConstraintSet.START);
        constraintSet.connect(button00.getId(), ConstraintSet.END,
                button01.getId(), ConstraintSet.START);
        // android:constraint_StartToStartOf="parent"
        constraintSet.connect(button00.getId(), ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        constraintSet.connect(button00.getId(), ConstraintSet.BOTTOM,
                button10.getId(), ConstraintSet.TOP);

        // button 01
        constraintSet.constrainWidth(button01.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.constrainHeight(button01.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.connect(button01.getId(), ConstraintSet.START,
                button00.getId(), ConstraintSet.END);
        constraintSet.connect(button01.getId(), ConstraintSet.END,
                ConstraintSet.PARENT_ID, ConstraintSet.END);
        constraintSet.connect(button01.getId(), ConstraintSet.TOP,
                button00.getId(), ConstraintSet.TOP);
        constraintSet.connect(button01.getId(), ConstraintSet.BOTTOM,
                button00.getId(), ConstraintSet.BOTTOM);

        // task: finish the 2x2 grid
        // button10
        constraintSet.constrainWidth(button10.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.constrainHeight(button10.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.connect(button10.getId(), ConstraintSet.START,
                ConstraintSet.PARENT_ID, ConstraintSet.START);
        constraintSet.connect(button10.getId(), ConstraintSet.END,
                button11.getId(), ConstraintSet.START);
        constraintSet.connect(button10.getId(), ConstraintSet.TOP,
                button00.getId(), ConstraintSet.BOTTOM);
        constraintSet.connect(button10.getId(), ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);

        // button11
        constraintSet.constrainWidth(button11.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.constrainHeight(button11.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.connect(button11.getId(), ConstraintSet.START,
                button10.getId(), ConstraintSet.END);
        constraintSet.connect(button11.getId(), ConstraintSet.END,
                ConstraintSet.PARENT_ID, ConstraintSet.END);
        constraintSet.connect(button11.getId(), ConstraintSet.TOP,
                button10.getId(), ConstraintSet.TOP);
        constraintSet.connect(button11.getId(), ConstraintSet.BOTTOM,
                button10.getId(), ConstraintSet.BOTTOM);

    }
}
