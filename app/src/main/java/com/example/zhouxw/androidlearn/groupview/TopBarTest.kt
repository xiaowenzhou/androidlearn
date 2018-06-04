package com.example.zhouxw.androidlearn.groupview

/**
 * Created by zhouxw on 2018/5/26.
 */
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.zhouxw.androidlearn.R

class TopBarTest : Activity() {

    private  var mTopBar: TopBar? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TopBar Start


        setContentView(R.layout.topbar_test)
        mTopBar = findViewById(R.id.topBar) as TopBar
        // 为topbar注册监听事件，传入定义的接口
        // 并以匿名类的方式实现接口内的方法(匿名内部类 object :TopBar.topbarClickListener{ override : } )
        mTopBar!!.setOnTopbarClickListener(object : TopBar.topbarClickListener {
            override fun rightClick() {
                Toast.makeText(this@TopBarTest,
                        "right", Toast.LENGTH_SHORT)
                        .show()
                Log.d("zhouxx", "rightClick")
            }

            override fun leftClick() {
                Toast.makeText(this@TopBarTest,
                        "left", Toast.LENGTH_SHORT)
                        .show()
                Log.d("zhouxx", "rightClick")

            }
        })
         //控制topbar上组件的状态
        mTopBar!!.setButtonVisable(0, true)
        mTopBar!!.setButtonVisable(1, true)

    }
}