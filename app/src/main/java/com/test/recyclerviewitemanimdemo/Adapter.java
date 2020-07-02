package com.test.recyclerviewitemanimdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: RecyclerViewItemAnimDemo
 * @Package: com.test.recyclerviewitemanimdemo
 * @ClassName: Adapter
 * @Description: java类作用描述
 * @Author: Jeffray
 * @CreateDate: 2020/7/2 14:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/2 14:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<String> list = new ArrayList<>();

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView tv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    public void remove(int position) {
        if(list.size() == 0){
            return;
        }
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void add(int position, String data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    public void change(int position, String data) {
        if(list.size() == 0){
            return;
        }
        list.remove(position);
        list.add(position, data);
        notifyItemChanged(position);
    }
}
