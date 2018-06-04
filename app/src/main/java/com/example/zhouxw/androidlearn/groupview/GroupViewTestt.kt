package com.example.zhouxw.androidlearn.groupview

import android.app.Activity
import android.os.Bundle
import com.example.zhouxw.androidlearn.R

/**
 * Created by zhouxw on 2018/6/4.
 */
class GroupViewTestt : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val flag =intent.getIntExtra("flag",-1)
        when(flag){
            0-> setContentView(R.layout.my_textview)
            1-> setContentView(R.layout.shine_textview)
            2-> {
                setContentView(R.layout.circle_progress)
                val circle = findViewById(R.id.circle) as CircleProgressView
                circle.setSweepValue(0f)
            }
            3->setContentView(R.layout.volume)
            4-> setContentView(R.layout.my_scrollview)

        }
    }
}