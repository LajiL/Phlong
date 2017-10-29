package com.lajilao.phlong.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.lajilao.phlong.R;

/**
 * Created by caojy on 2017/10/29.
 */

public class CallTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_task);
        onClickListener();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClickListener() {
        ImageButton imgButton1 = (ImageButton) findViewById(R.id.back_button);
        ImageButton imgButton2 = (ImageButton) findViewById(R.id.call);
        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "15970481474"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
