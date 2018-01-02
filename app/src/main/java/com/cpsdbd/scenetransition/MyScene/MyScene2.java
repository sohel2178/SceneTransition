package com.cpsdbd.scenetransition.MyScene;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cpsdbd.scenetransition.R;

/**
 * Created by Genius 03 on 1/2/2018.
 */

public class MyScene2 extends MyScene {


    private ImageView iv1,iv2,iv3,iv4;


    public MyScene2(Activity activity, ViewGroup container) {
        super(activity, container, R.layout.layout_scene_2);
    }

    @Override
    protected void initView() {

        iv1 = getCurrent_layout().findViewById(R.id.btn1);
        iv2 = getCurrent_layout().findViewById(R.id.btn2);
        iv3 = getCurrent_layout().findViewById(R.id.btn3);
        iv4 = getCurrent_layout().findViewById(R.id.btn4);

        iv1.setOnClickListener((View.OnClickListener) getActivity());
        iv2.setOnClickListener((View.OnClickListener) getActivity());
        iv3.setOnClickListener((View.OnClickListener) getActivity());
        iv4.setOnClickListener((View.OnClickListener) getActivity());

    }

}
