package com.muhaiminurabir.slider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class TWO extends AppCompatActivity {

    List<CARD> card_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        initData();

        final HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        Two_Adapter adapter = new Two_Adapter(card_list,getBaseContext());
        pager.setAdapter(adapter);


        /*pager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("abir","ok");
            }
        });*/
    }
    private void initData() {
        for (int c = 0; c < 10; c++) {
            CARD movie1 = new CARD("Muhaiminur Rahman", "522", "01/17", "5805678900000000"+c);
            card_list.add(movie1);
        }
    }
}
