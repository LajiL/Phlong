package com.lajilao.phlong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lajilao.phlong.tabs.SalesFragment;
import com.lajilao.phlong.tabs.TaskFragment;
import com.lajilao.phlong.tabs.UserFragment;

public class MainActivity extends FragmentActivity {
    private FrameLayout mContent;
    private RadioGroup mRadioGroup;
    private RadioButton mTaskGroup;
    private RadioButton mSalesGroup;
    private RadioButton mUsersGroup;

    static final int NUM_ITEMS = 4;//一共四个fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    protected void initView() {
        mContent = (FrameLayout) findViewById(R.id.mContent); //tab上方的区域
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);  //底部的四个tab
        mTaskGroup = (RadioButton) findViewById(R.id.mTaskGroup);
        mSalesGroup = (RadioButton) findViewById(R.id.mSalesGroup);
        mUsersGroup = (RadioButton) findViewById(R.id.mUsersGroup);

        //监听事件：为底部的RadioGroup绑定状态改变的监听事件
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.mTaskGroup:
                        index = 0;
                        break;
                    case R.id.mSalesGroup:
                        index = 1;
                        break;
                    case R.id.mUsersGroup:
                        index = 2;
                        break;
                }
                Fragment fragment = (Fragment) fragments.instantiateItem(mContent, index);
                fragments.setPrimaryItem(mContent, 0, fragment);
                fragments.finishUpdate(mContent);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mRadioGroup.check(R.id.mTaskGroup);
    }


    FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

        @Override
        public int getCount() {
            return NUM_ITEMS;//一共有三个Fragment
        }

        //进行Fragment的初始化
        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0://待办任务
                    fragment = new TaskFragment();
                    break;
                case 1://销售管理
                    fragment = new SalesFragment();
                    break;

                case 2://我的
                    fragment = new UserFragment();
                    break;
                default:
                    new TaskFragment();
                    break;
            }

            return fragment;
        }
    };

    protected void initData() {

    }

}

