package com.lajilao.phlong.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.lajilao.phlong.R;
import java.util.List;

/**
 * Created by Ricky on 2017/10/29.
 */

public class UserToolsAdapter extends RecyclerView.Adapter<UserToolsAdapter.ViewHolder>{

    private List<UserTools> mToolsList;

    //内部类，这里的view通常是RecycleView子项的最外层布局
    // 在这里就是指user_tools.xml
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ToolsImage;
        TextView ToolsName;

        public ViewHolder(View view){
            super(view);
            ToolsImage = (ImageView)view.findViewById(R.id.user_tools_image);
            ToolsName = (TextView)view.findViewById(R.id.user_tools_text);
        }

    }

    //构造方法用于把要展示的数据源传进来，并赋值给mToolsList
    // 后续的操作都在这个数据源的基础上进行。
    public UserToolsAdapter(List<UserTools> ToolsList){
        mToolsList = ToolsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_tools,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserTools userTools = mToolsList.get(position);
        holder.ToolsImage.setImageResource(userTools.getImageId());
        holder.ToolsName.setText(userTools.getName());
    }

    @Override
    public int getItemCount() {
        return mToolsList.size();
    }

}
