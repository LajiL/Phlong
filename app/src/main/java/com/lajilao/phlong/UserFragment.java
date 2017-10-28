package com.lajilao.phlong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private View view;
    private ProgressBar progressBar;
    private String[] data = { "Apple","Banana","Orange","Watermelon","pear","Grape","Pineapple",
            "Strawberry","Cherry","Mango","Apple","Banana","Orange",
            "Watermelon","pear","Grape","Pineapple",
            "Strawberry","Cherry","Mango"};

    public UserFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        progressBar = (ProgressBar) view.findViewById(R.id.user_progress_bar);
//        progressBar.setVisibility(View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_expandable_list_item_1,data);
        ListView listView = (ListView)view.findViewById(R.id.user_todo_listview);
        listView.setAdapter(adapter);

    }

}
