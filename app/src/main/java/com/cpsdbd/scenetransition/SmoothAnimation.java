package com.cpsdbd.scenetransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class SmoothAnimation extends AppCompatActivity implements View.OnClickListener {

    private TextView myText;
    private ImageView btnClick;
    private ViewGroup transitionContainer;

    private boolean isVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smooth_animation);

        transitionContainer = findViewById(R.id.bottom_container);
        myText = findViewById(R.id.my_text);
        btnClick = findViewById(R.id.click);
        btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        isVisible = !isVisible;

        // Declare a Transition for Button
        Transition btnTr = new ChangeBounds();
        btnTr.setPathMotion(new ArcMotion());

        Transition transition = new TransitionSet()

                .addTransition(isVisible? new Slide(Gravity.BOTTOM) : new Slide(Gravity.BOTTOM))
                .addTransition(btnTr)
                .addListener(new Transition.TransitionListener() {
                    @Override
                    public void onTransitionStart(Transition transition) {
                        Log.d("GGG","onTransitionStart");
                    }

                    @Override
                    public void onTransitionEnd(Transition transition) {
                        Log.d("GGG","onTransitionEnd");

                        if(!isVisible){
                            myText.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onTransitionCancel(Transition transition) {

                    }

                    @Override
                    public void onTransitionPause(Transition transition) {

                    }

                    @Override
                    public void onTransitionResume(Transition transition) {

                    }
                });


        TransitionManager.beginDelayedTransition(transitionContainer,transition);
        myText.setVisibility(isVisible ? View.VISIBLE:View.INVISIBLE);

        // Change Button Property
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) btnClick.getLayoutParams();


        param.gravity = isVisible ? (Gravity.CENTER_HORIZONTAL|Gravity.TOP) : (Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM);

        int resource = isVisible ? R.drawable.down : R.drawable.up;

        btnClick.setLayoutParams(param);
        btnClick.setImageResource(resource);

    }
}
