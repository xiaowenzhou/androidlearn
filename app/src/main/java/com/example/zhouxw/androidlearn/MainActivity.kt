package com.example.zhouxw.androidlearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.zhouxw.androidlearn.groupview.GroupViewTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnViewGroupHolder(view: View){
        startActivity(Intent(this, GroupViewTest::class.java))
    }

}
