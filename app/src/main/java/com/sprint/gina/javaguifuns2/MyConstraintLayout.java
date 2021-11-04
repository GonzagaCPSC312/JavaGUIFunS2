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

        // set up button00's width and height
        constraintSet.constrainWidth(button00.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(button00.getId(), ConstraintSet.WRAP_CONTENT);
        // now, button00 needs at least one horiz and one vert constraint
        constraintSet.connect(button00.getId(), ConstraintSet.START,
                ConstraintSet.PARENT_ID, ConstraintSet.START);
        constraintSet.connect(button00.getId(), ConstraintSet.END,
                button01.getId(), ConstraintSet.START);
        // android:constraint_StartToStartOf="parent"
        constraintSet.connect(button00.getId(), ConstraintSet.TOP,
                ConstraintSet.PARENT_ID, ConstraintSet.TOP);

        // button 01
        constraintSet.constrainWidth(button01.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(button01.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.connect(button01.getId(), ConstraintSet.START,
                button00.getId(), ConstraintSet.END);
        constraintSet.connect(button01.getId(), ConstraintSet.END,
                ConstraintSet.PARENT_ID, ConstraintSet.END);
        constraintSet.connect(button01.getId(), ConstraintSet.TOP,
                button00.getId(), ConstraintSet.TOP);
        constraintSet.connect(button01.getId(), ConstraintSet.BOTTOM,
                button00.getId(), ConstraintSet.BOTTOM);

        // task: finish the 2x2 grid

    }
}
