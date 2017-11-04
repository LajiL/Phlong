package com.lajilao.phlong.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lajilao.phlong.R;
import java.util.List;

/**
 * Created by Ricky on 2017/10/29.
 */

public class UserToolsAdapter extends ArrayAdapter<UserTools>{

    private int resourceId;

    public UserToolsAdapter(Context context, int textViewResourceId, List<UserTools> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserTools userTools = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(resourceId,parent,false);
        }else {
            view = convertView;
        }
        ImageView userToolsImage = (ImageView)view.findViewById(R.id.user_tools_image);
        TextView userToolsName = (TextView)view.findViewById(R.id.user_tools_text);
        userToolsImage.setImageResource(userTools.getImageId());
        userToolsName.setText(userTools.getName());
        return view;
    }
}
