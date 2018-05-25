package com.example.zhouxw.guo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.*

/**
 * Created by zhouxw on 2018/5/24.
 */
class VolumeView :View{
    private  var  mWidth : Float =0f
    private var mRectWidth :Float =0f
    private var offset =5
    private var mRectHeight : Float =0f
    private var mRectCount : Int =0
    private var mPaint: Paint = Paint()
    private var mRandom :Double =0.toDouble()
    private lateinit var mLinearGradient: LinearGradient

    constructor(ctx:Context,attrs :AttributeSet,defStyleAttr :Int) : super(ctx,attrs,defStyleAttr)
    constructor(ctx: Context,attrs: AttributeSet): super(ctx,attrs)
    constructor(ctx: Context):super(ctx)

    init {
        mPaint.color = Color.BLUE
        mPaint.style=Paint.Style.FILL
        mRectCount =12
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in 0 until mRectCount){
            mRandom =Math.random()
            var currentHeight =(mRectHeight * mRandom).toFloat()
            canvas!!.drawRect((mWidth*0.4/2+mRectWidth*i+offset).toFloat(),
                        currentHeight,
                    (mWidth*0.4/2+mRectWidth*(i+1)).toFloat(),
                        mRectHeight,
                        mPaint)

        }
        postInvalidateDelayed(300)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth= width.toFloat()
        mRectHeight=height.toFloat()
        mRectWidth = (mWidth*0.6/mRectCount).toFloat()
        mLinearGradient= LinearGradient(0f,
                0f,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP)
        mPaint.shader = mLinearGradient
    }


}