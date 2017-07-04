package com.lifeistech.android.travelapp;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Masashi Hamaguchi on 2017/05/30.
 */

public class PopupDialogFlagment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity());
        //タイトル非表示
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //フルスクリーン
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        //layoutの読み込み
        dialog.setContentView(R.layout.popuplayout);
        //背景を透明にする
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //Bitmap合成
        //Bitmapの枠を作成
        Bitmap baseBitmap = Bitmap.createBitmap(480, 278, Bitmap.Config.ARGB_8888);
        //BaseになるBitmapの生成
        Canvas canvas = new Canvas(baseBitmap);

        //表示画面の取得&設定
        Bitmap baseImage = BitmapFactory.decodeResource(getResources(), R.drawable.frame);
        baseImage = Bitmap.createScaledBitmap(baseImage, 400, 278, false);
        canvas.drawBitmap(baseImage, 0, 0, null);

        Bitmap frameBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.base);
        frameBitmap = Bitmap.createScaledBitmap(frameBitmap, 400, 278, false);
        canvas.drawBitmap(baseImage, 0, 0, null);

        ((ImageView)dialog.findViewById(R.id.imageView3)).setImageBitmap(baseBitmap);

        //OKボタンのリスナ
        dialog.findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // Dialogを返す
        return dialog;

    }
}
