package com.cpsdbd.scenetransition.MyScene;

import android.app.Activity;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by Genius 03 on 1/2/2018.
 */

public abstract class MyScene {
    private Activity activity;
    private ViewGroup container;
    private int layout_res;

    private ViewGroup current_layout;

    private Scene scene;

    private Transition transition;

    public MyScene(Activity activity, ViewGroup container, int layout_res) {
        this.activity = activity;
        this.container = container;
        this.layout_res = layout_res;

        current_layout = (ViewGroup) LayoutInflater.from(activity).inflate(layout_res,container,false);

        this.scene = new Scene(container,current_layout);

        transition = new Slide(Gravity.RIGHT);
        transition.setDuration(1000);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());

        initView();

    }

    protected abstract void initView();


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ViewGroup getContainer() {
        return container;
    }

    public void setContainer(ViewGroup container) {
        this.container = container;
    }

    public int getLayout_res() {
        return layout_res;
    }

    public void setLayout_res(int layout_res) {
        this.layout_res = layout_res;
    }

    public ViewGroup getCurrent_layout() {
        return current_layout;
    }

    public void setCurrent_layout(ViewGroup current_layout) {
        this.current_layout = current_layout;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }
}
