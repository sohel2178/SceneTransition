package com.cpsdbd.scenetransition.MyScene;

import android.app.Activity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.cpsdbd.scenetransition.R;

/**
 * Created by Genius 03 on 1/2/2018.
 */

public class MyScene1 extends MyScene {


    private ImageView iv1,iv2,iv3,iv4;
    private Button btnSmooth;


    public MyScene1(Activity activity, ViewGroup container) {
        super(activity, container, R.layout.layout_scene_1);
    }

    @Override
    protected void initView() {

        iv1 = getCurrent_layout().findViewById(R.id.btn1);
        iv2 = getCurrent_layout().findViewById(R.id.btn2);
        iv3 = getCurrent_layout().findViewById(R.id.btn3);
        iv4 = getCurrent_layout().findViewById(R.id.btn4);
        btnSmooth = getCurrent_layout().findViewById(R.id.smooth);

        iv1.setOnClickListener((View.OnClickListener) getActivity());
        iv2.setOnClickListener((View.OnClickListener) getActivity());
        iv3.setOnClickListener((View.OnClickListener) getActivity());
        iv4.setOnClickListener((View.OnClickListener) getActivity());
        btnSmooth.setOnClickListener((View.OnClickListener) getActivity());

    }

}
