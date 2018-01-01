package com.cpsdbd.scenetransition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ArcMotion;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //scenes to transition
    private Scene scene1, scene2;
    //transition to move between scenes
    private Transition transition;
    //flag to swap between scenes
    private boolean start;
    private boolean isBottom;

    private Button btnChangePosition;

    private FrameLayout btnContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        


        //get the layout ID
        RelativeLayout baseLayout = findViewById(R.id.root_container);


//first scene
        ViewGroup startViews = (ViewGroup)getLayoutInflater()
                .inflate(R.layout.layout_scene_1, baseLayout, false);

//second scene
        ViewGroup endViews = (ViewGroup)getLayoutInflater()
                .inflate(R.layout.layout_scene_2, baseLayout, false);

        scene1 = new Scene(baseLayout,startViews);
        scene2 = new Scene(baseLayout,endViews);

        scene1.enter();

        btnContainer =  findViewById(R.id.button_container);
        btnChangePosition = findViewById(R.id.change_position);
        btnChangePosition.setOnClickListener(this);

        //create transition, set properties
        transition = new Slide(Gravity.RIGHT);
        transition.setDuration(1000);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());

//initialize flag
        start=true;
    }

    public void changeScene(View view) {
        //check flag
        if(start) {
            TransitionManager.go(scene2, transition);
           /* scene1.exit();
            scene2.enter();*/
            start=false;
        }
        else {
            /*scene2.exit();
            scene1.enter();*/
            TransitionManager.go(scene1, transition);
            start=true;
        }
    }

    public void next(View view) {
        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_position:
                changePosition();
                break;
        }
    }

    private void changePosition() {

        Transition transition = new ChangeBounds();
        transition.setPathMotion(new ArcMotion());
        transition.setDuration(500);

        TransitionManager.beginDelayedTransition(btnContainer, transition);

        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) btnChangePosition.getLayoutParams();

        isBottom = !isBottom;

        param.gravity = isBottom ? (Gravity.END|Gravity.BOTTOM) : (Gravity.START|Gravity.TOP);

        btnChangePosition.setLayoutParams(param);
    }
}
