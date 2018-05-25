package com.example.zhouxw.guo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //private lateinit var rel: RelativeLayout
    //private lateinit var ima: MyTextView


    private  var mTopBar: TopBar? =null


    //private lateinit var circleProgressView: CircleProgressView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.circleprogresspiew)


        setContentView(R.layout.myscrollview)


        //MyTextView Start

        /*rel = findViewById(R.id.rel_1) as RelativeLayout
        ima = findViewById(R.id.image_1) as MyTextView
        ima.setOnClickListener({
            Toast.makeText(this, "iiiiii", Toast.LENGTH_SHORT).show()
        })
        rel.setOnClickListener({ })*/



        //TopBar Start

        /*
        setContentView(R.layout.activity_main)
        mTopBar = findViewById(R.id.topBar) as TopBar
        // 为topbar注册监听事件，传入定义的接口
        // 并以匿名类的方式实现接口内的方法(匿名内部类 object :TopBar.topbarClickListener{ override : } )
        mTopBar!!.setOnTopbarClickListener(object : TopBar.topbarClickListener {
            override fun rightClick() {
                Toast.makeText(this@MainActivity,
                        "right", Toast.LENGTH_SHORT)
                        .show()
                Log.d("zhouxx", "rightClick")
            }

            override fun leftClick() {
                Toast.makeText(this@MainActivity,
                        "left", Toast.LENGTH_SHORT)
                        .show()
                Log.d("zhouxx", "rightClick")

            }
        })
         //控制topbar上组件的状态
        mTopBar!!.setButtonVisable(0, true)
        mTopBar!!.setButtonVisable(1, true)
        */


        //CircleProgressView Start
       /*
       setContentView(R.layout.circleprogresspiew)
       circleProgressView = findViewById(R.id.circle) as CircleProgressView
        circleProgressView.setSweepValue(0F)*/



    }



    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }


}
