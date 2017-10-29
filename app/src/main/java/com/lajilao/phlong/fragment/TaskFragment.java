package com.lajilao.phlong.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;

import com.lajilao.phlong.R;
import com.lajilao.phlong.activity.CallTaskActivity;

/**
 * Created by caojy on 2017/10/28.
 */

public class TaskFragment extends Fragment {

    public TaskFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btn1 = (Button) getActivity().findViewById(R.id.call_task);
        Button btn2 = (Button) getActivity().findViewById(R.id.pending_remittance);
        Button btn3 = (Button) getActivity().findViewById(R.id.visit_plan);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CallTaskActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b= (Button) v.findViewById(R.id.pending_remittance);
                b.setText("测试待处理汇款点击");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b= (Button) v.findViewById(R.id.visit_plan);
                b.setText("测试回访计划点击");
            }
        });

    }
}
