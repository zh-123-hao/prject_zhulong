package com.zh.prject_zhulong;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_show;
    private TextView tv_skip;
    int times = 5;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1 :
                    if (times>1){
                        times -- ;
                        tv_skip.setText("跳过 "+times+"");
                        handler.sendEmptyMessageDelayed(1, 1000);
                    }else {
                        netActivity();
                    }
                    break;
            }
            return false;
        }
    });

    private void netActivity() {
        Intent intent = new Intent(MainActivity.this, ShowActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        img_show = (ImageView) findViewById(R.id.img_show);
        tv_skip = (TextView) findViewById(R.id.tv_skip);

        tv_skip.setText("跳过 5");
        handler.sendEmptyMessage(1);

        tv_skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_skip :
                netActivity();
                handler.removeMessages(1);
                break;
        }
    }
}
