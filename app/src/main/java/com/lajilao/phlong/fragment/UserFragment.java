package com.lajilao.phlong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lajilao.phlong.R;
import com.lajilao.phlong.utils.UserTools;
import com.lajilao.phlong.utils.UserToolsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private View view;
    //private ProgressBar progressBar;
    private List<UserTools> userToolsList = new ArrayList<UserTools>();

    public UserFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_fragment, container, false);
        initUserTools();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.user_tools_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        UserToolsAdapter adapter = new UserToolsAdapter(userToolsList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        progressBar = (ProgressBar) view.findViewById(R.id.user_progress_bar);
//        progressBar.setVisibility(View.GONE);
    }

    private void initUserTools() {

        UserTools calendar = new UserTools("日程",R.drawable.user_tools_calendar_pic);
        userToolsList.add(calendar);

        UserTools mails = new UserTools("邮件",R.drawable.user_tools_mails_pic);
        userToolsList.add(mails);

        UserTools settings = new UserTools("设置",R.drawable.user_tools_setting_pic);
        userToolsList.add(settings);

    }

}
