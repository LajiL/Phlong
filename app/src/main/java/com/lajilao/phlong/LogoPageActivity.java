package com.lajilao.phlong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by caojy on 2017/10/22.
 * 创建一个logo页面
 */

public class LogoPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_page);
        //首次打开app时先加载logo页面，3秒后进入app主页面
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(LogoPageActivity.this, MainActivity.class);
                LogoPageActivity.this.startActivity(mainIntent);
                LogoPageActivity.this.finish();
            }
        }, 1000);
    }
}