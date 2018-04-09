package com.fxj.changeViewPosition;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity  implements View.OnClickListener{

    private TextView tv;

    private Button btnUp;
    private Button btnDown;
    private Button btnLeft;
    private Button btnRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        btnUp =findViewById(R.id.up);
        btnDown =findViewById(R.id.down);
        btnLeft=findViewById(R.id.left);
        btnRight=findViewById(R.id.right);

        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.up:
                changeMarginLayoutParamsInVertical(false);
                break;
            case R.id.down:
                changeMarginLayoutParamsInVertical(true);
                break;
            case R.id.left:
                changeMarginLayoutParamsInHorizontal(true);
                break;
            case R.id.right:
                changeMarginLayoutParamsInHorizontal(false);
                break;
        }
    }

    private  void changeMarginLayoutParamsInVertical(boolean isDown){
        RelativeLayout.MarginLayoutParams marginLayoutParams = (RelativeLayout.MarginLayoutParams) tv.getLayoutParams();
        if(isDown){
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin,marginLayoutParams.topMargin+10,marginLayoutParams.rightMargin,marginLayoutParams.bottomMargin);
        }else{
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin,marginLayoutParams.topMargin-10,marginLayoutParams.rightMargin,marginLayoutParams.bottomMargin);
        }
        tv.setLayoutParams(marginLayoutParams);
    }

    private  void changeMarginLayoutParamsInHorizontal(boolean isLeft){
        RelativeLayout.MarginLayoutParams marginLayoutParams = (RelativeLayout.MarginLayoutParams) tv.getLayoutParams();
        if(isLeft){
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin-10,marginLayoutParams.topMargin,marginLayoutParams.rightMargin,marginLayoutParams.bottomMargin);
        }else{
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin+10,marginLayoutParams.topMargin,marginLayoutParams.rightMargin,marginLayoutParams.bottomMargin);
        }
        tv.setLayoutParams(marginLayoutParams);
    }
}
