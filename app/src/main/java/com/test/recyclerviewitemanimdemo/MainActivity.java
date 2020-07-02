package com.test.recyclerviewitemanimdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.test.recyclerviewitemanimdemo.anim.MyItemAnimator;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String text = "上个月，日本汽车制造商马自达，正式于日本本土的广岛Ujina第一工厂开始紧凑型跨界SUV——MX-30。马自达MX-30这不仅是马自达在新一代魂动KODO设计语言下，打造的首款轿跑SUV，也是马自达品牌历史中的首款纯电动量产汽车产品。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyc);
        final com.test.recyclerviewitemanimdemo.Adapter adapter = new com.test.recyclerviewitemanimdemo.Adapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 设置默认动画
//        DefaultItemAnimator animator = new DefaultItemAnimator();
        MyItemAnimator animator = new MyItemAnimator();
        // 设置动画时间
//        animator.setAddDuration(2000);
//        animator.setRemoveDuration(2000);
        recyclerView.setItemAnimator(animator);

        recyclerView.setAdapter(adapter);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add(0, getText());
                recyclerView.scrollToPosition(0);
            }
        });

        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.remove(0);
            }
        });

        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.change(0,getText());
            }
        });

        findViewById(R.id.btn_lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });

        findViewById(R.id.btn_grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
            }
        });

        findViewById(R.id.btn_flow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            }
        });
    }

    private String getText(){
        int end = 0;
        while (end == 0){
            end = (int) (Math.random() * text.length());
        }
        return text.substring(0,end);
    }
}