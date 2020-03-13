package com.jby.broadcastbestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button offline=findViewById(R.id.force_offline);
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击按钮");
                Intent intent=new Intent("FORCE_OFFLINE");
                intent.setComponent(new ComponentName( "com.jby.broadcastbestpractice" ,
                        "com.jby.broadcastbestpractice.ForceOffLineReceiver"));
                sendBroadcast(intent);//发送下线广播
            }
        });
    }
}
