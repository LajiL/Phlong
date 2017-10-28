package com.lajilao.phlong;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewFragment extends Fragment {

    private @LayoutRes int resource;

    public ViewFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(resource,container,false);
        return view;
    }

    public @LayoutRes int getResource() {
        return resource;
    }

    public void setResource(@LayoutRes int resource) {
        this.resource = resource;
    }
}
