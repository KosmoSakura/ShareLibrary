package com.wechat.zull;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.windward.sharelibrary.wxapi.WXUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.bb);
        Button b2 = (Button) findViewById(R.id.bb2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toWCircle(0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toWCircle(1);
            }
        });
    }
    private void toWCircle(int x) {
        WXUtils u = new WXUtils();
        int type = x;//1--微信朋友圈
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        String title = "标题";
        String description = "详细描述";
        u.sendImageMessageToWeiXin(this,type,bitmap,title,description);
    }

}
