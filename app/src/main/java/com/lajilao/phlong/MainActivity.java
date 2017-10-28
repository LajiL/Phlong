package com.lajilao.phlong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup rg_tab_bar;
    private RadioButton rb_task;

    //Fragment Object
    private ViewFragment fg1,fg2;
    private UserFragment fg3;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getSupportFragmentManager();
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_task = (RadioButton) findViewById(R.id.rb_task);
        rb_task.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.ly_top_bar);
        TextView tv = (TextView) findViewById(R.id.txt_topbar);
        switch (checkedId){
            case R.id.rb_task:
                tv.setText("呼叫任务");
                layout.setVisibility(View.VISIBLE);
                if(fg1 == null){
                    fg1 = new ViewFragment();
                    fg1.setResource(R.layout.task_fragment);
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.rb_sales:
                tv.setText("销售管理");
                layout.setVisibility(View.VISIBLE);
                if(fg2 == null){
                    fg2 = new ViewFragment();
                    fg2.setResource(R.layout.sales_fragment);
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.rb_user:
                layout.setVisibility(View.GONE);
                if(fg3 == null){
                    fg3 = new UserFragment();
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;
        }
        fTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent i= new Intent(Intent.ACTION_MAIN);  //主启动，不期望接收数据
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //新的activity栈中开启，或者已经存在就调到栈前
            i.addCategory(Intent.CATEGORY_HOME);       //添加种类，为设备首次启动显示的页面
            startActivity(i);
        }
        return super.onKeyDown(keyCode, event);
    }

}
