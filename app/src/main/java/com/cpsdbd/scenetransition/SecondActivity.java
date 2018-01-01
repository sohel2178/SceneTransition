package com.cpsdbd.scenetransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView myText;

    private boolean isVisible;
    private boolean expanded;

    private ViewGroup transitionContainer;

    private ViewGroup imageContainer;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        transitionContainer = findViewById(R.id.transition_container);
        imageContainer = findViewById(R.id.image_container);
        myText = findViewById(R.id.my_text);
        ivImage = findViewById(R.id.image);
        ivImage.setOnClickListener(this);
    }

    public void click_me(View view) {
        /*Transition traslate = new Slide(Gravity.LEFT);
        traslate.setDuration(700);
        traslate.setInterpolator(new FastOutSlowInInterpolator());*/

        isVisible = !isVisible;


        Transition transition = new TransitionSet()
                .addTransition(isVisible? new Slide(Gravity.LEFT) : new Slide(Gravity.RIGHT))
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


    }

    @Override
    public void onClick(View view) {
        TransitionManager.beginDelayedTransition(imageContainer, new TransitionSet()
                .addTransition(new ChangeBounds())
                .addTransition(new ChangeImageTransform()));

        ViewGroup.LayoutParams params = ivImage.getLayoutParams();

        Log.d("HHH",params.height+"");
        Log.d("HHH",params.width+"");

        expanded=!expanded;

        params.height = expanded ? ViewGroup.LayoutParams.MATCH_PARENT :
                ViewGroup.LayoutParams.WRAP_CONTENT;

        params.width = expanded ? ViewGroup.LayoutParams.MATCH_PARENT :
                ViewGroup.LayoutParams.WRAP_CONTENT;

        // Change the Layout Param
        ivImage.setLayoutParams(params);

        // Change Scale Type
        ivImage.setScaleType(expanded ? ImageView.ScaleType.CENTER_CROP :
                ImageView.ScaleType.FIT_CENTER);
    }
}
