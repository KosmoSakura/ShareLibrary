package com.chcts.sina;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.windward.sharelibrary.qq.QQUtil;
import com.windward.sharelibrary.weibo.WBUtil;
import com.windward.sharelibrary.wxapi.WXUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button sina, QFriend, QZone, WFriend, WCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSina();
            }
        });
        QFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toQFriend();
            }
        });
        QZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toQZone();
            }
        });
        WFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toWFriend();
            }
        });
        WCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toWCircle();
            }
        });

        Button button = (Button) findViewById(R.id.sssss);
        button.setEnabled(false);
    }

    private void toWCircle() {
        WXUtils u = new WXUtils();
        int type = 1;//1--微信朋友圈
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        String title = "标题";
        String description = "详细描述";
        u.sendImageMessageToWeiXin(this,type,bitmap,title,description);
    }

    private void toWFriend() {
        WXUtils u = new WXUtils();
        int type = 0;//0--微信好友
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        String title = "标题";
        String description = "详细描述";
        u.sendImageMessageToWeiXin(this,type,bitmap,title,description);
    }

    private void toQZone() {
        QQUtil util = new QQUtil(this);
        String title = "标题";// 必填
        String summary = "摘要";// 选填
        String target_url = null;// 乱填会崩
        ArrayList<String> list = new ArrayList<String>();
        list.add("http://media-cdn.tripadvisor.com/media/photo-s/01/3e/05/40/the-sandbar-that-links.jpg");

        util.sendTextMessageToQzone(this, title, summary, target_url, list);
    }

    private void toQFriend() {
        QQUtil u = new QQUtil(this);
        String title = "标题";// 分享的标题, 最长30个字符。
        String summary = "摘要";// 分享的消息摘要，最长40个字。
        // 分享图片的URL或者本地路径
        String bitmapPath = "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif";
        // 这条分享消息被好友点击后的跳转URL。"http://www.qq.com/news/1.html"
        String target_url = null;
        u.sendImageTextMessageToQQ(this, title, summary, bitmapPath, target_url);
    }

    private void toSina() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, WBUtil.class);
        intent.putExtra("bmp", BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        intent.putExtra("title", "这里是title");
        intent.putExtra("msg", "这个是信息主体");
        intent.putExtra("pageUrl", "www.baidu.com");
        startActivity(intent);
    }

    private void init() {
        sina = (Button) findViewById(R.id.sina);
        QFriend = (Button) findViewById(R.id.s_friend);
        QZone = (Button) findViewById(R.id.s_zone);
        WFriend = (Button) findViewById(R.id.weichat);
        WCircle = (Button) findViewById(R.id.weichat_circle);
    }
}
