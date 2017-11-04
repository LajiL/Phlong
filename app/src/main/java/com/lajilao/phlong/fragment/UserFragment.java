package com.lajilao.phlong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        UserToolsAdapter adapter = new UserToolsAdapter(getActivity(),
                R.layout.user_tools,userToolsList);
        ListView listView = (ListView) view.findViewById(R.id.user_tools_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserTools userTools = userToolsList.get(position);
                Toast.makeText(getActivity(),userTools.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        progressBar = (ProgressBar) view.findViewById(R.id.user_progress_bar);
//        progressBar.setVisibility(View.GONE);
    }

    private void initUserTools() {

        UserTools calendar = new UserTools("日程",R.drawable.user_tools_testpng);
        userToolsList.add(calendar);

        UserTools mails = new UserTools("邮件",R.drawable.user_tools_testpng);
        userToolsList.add(mails);

        UserTools settings = new UserTools("设置",R.drawable.user_tools_testpng);
        userToolsList.add(settings);

        UserTools calendar2 = new UserTools("日程2",R.drawable.user_tools_testpng);
        userToolsList.add(calendar2);

        UserTools mails2 = new UserTools("邮件2",R.drawable.user_tools_testpng);
        userToolsList.add(mails2);

        UserTools settings2 = new UserTools("设置2",R.drawable.user_tools_testpng);
        userToolsList.add(settings2);

        UserTools calendar3 = new UserTools("日程3",R.drawable.user_tools_testpng);
        userToolsList.add(calendar3);

        UserTools mails3 = new UserTools("邮件3",R.drawable.user_tools_testpng);
        userToolsList.add(mails3);

        UserTools settings3 = new UserTools("设置3",R.drawable.user_tools_testpng);
        userToolsList.add(settings3);

    }

}
