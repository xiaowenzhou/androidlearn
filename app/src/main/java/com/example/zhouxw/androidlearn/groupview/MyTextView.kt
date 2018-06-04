package com.example.zhouxw.androidlearn.groupview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by zhouxw on 2018/6/4.
 */
class MyTextView :TextView {
    private var mPaint1: Paint? = null
    private var mPaint2: Paint? = null

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    private fun initView() {
        mPaint1 = Paint()
        mPaint1!!.color = resources.getColor(
                android.R.color.holo_blue_light)
        mPaint1!!.style = Paint.Style.FILL
        mPaint2 = Paint()
        mPaint2!!.color = Color.YELLOW
        mPaint2!!.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        // 绘制外层矩形
        canvas.drawRect(
                0f,
                0f,
                measuredWidth.toFloat(),
                measuredHeight.toFloat(),
                mPaint1!!)
        // 绘制内层矩形
        canvas.drawRect(
                10f,
                10f,
                (measuredWidth - 10).toFloat(),
                (measuredHeight - 10).toFloat(),
                mPaint2!!)
        canvas.save()
        // 绘制文字前平移10像素
        canvas.translate(10f, 0f)
        // 父类完成的方法，即绘制文本
        super.onDraw(canvas)
        canvas.restore()
    }
}