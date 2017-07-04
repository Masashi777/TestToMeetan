package com.lifeistech.android.travelapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window varWindow = getWindow();
        varWindow.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageView.setImageResource(R.drawable.base);
        imageView2.setImageResource(R.drawable.frame);

        setContentView(R.layout.activity_main);
    }

    //ボタンの処理
    public void onClickComposition(View v) {
        PopupDialogFlagment popupDialogFlagment = new PopupDialogFlagment();
        popupDialogFlagment.show(getSupportFragmentManager(), "CompositionBitmapDialog");
    }
}
