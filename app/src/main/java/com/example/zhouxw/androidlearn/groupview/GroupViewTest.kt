package com.example.zhouxw.androidlearn.groupview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.example.zhouxw.androidlearn.R

/**
 * Created by zhouxw on 2018/6/4.
 */
class GroupViewTest : Activity() {
    private var mIntent :Intent?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.groupview_test)
        mIntent= Intent(this,GroupViewTestt:: class.java)
    }

    fun btnMytextView(view: View){
        mIntent!!.putExtra("flag",0)
        startActivity(mIntent)

    }
    fun btnshineview(view: View){
        mIntent!!.putExtra("flag",1)
        startActivity(mIntent)
    }

    fun btncircle(view: View){
        mIntent!!.putExtra("flag",2)
        startActivity(mIntent)
    }

    fun btnVolume(view: View){
        mIntent!!.putExtra("flag",3)
        startActivity(mIntent)
    }

    fun btnMyScrollView(view: View){
        mIntent!!.putExtra("flag",4)
        startActivity(mIntent)
    }

    fun btnTopBar(view: View){
        startActivity(Intent(this, TopBarTest::class.java))
    }





}