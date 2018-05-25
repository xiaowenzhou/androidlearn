package com.example.zhouxw.guo

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.Color.YELLOW
import android.util.AttributeSet
import android.widget.TextView


/**
 * Created by zhouxw on 2018/5/17.
 */
class MyTextView : TextView{
    private  var mPaint1 : Paint
    private  var mPaint2 : Paint
    private lateinit var mPaint : Paint
    private lateinit var mLinearGradient : LinearGradient
    private lateinit var mGradientMatrix : Matrix
    private  var mViewWidth : Float =0F
    private  var mTranslate : Float =0F

    constructor(ctx :Context): super(ctx)
    constructor(ctx: Context,attrs : AttributeSet) :super(ctx,attrs)
    constructor(ctx: Context,attrs: AttributeSet,defSty:Int) : super(ctx,attrs,defSty)


   init {
        mPaint1 = Paint()
       mPaint1.color =resources.getColor(android.R.
               color.holo_blue_bright)
       mPaint1.style = Paint.Style.FILL
        mPaint2 = Paint()
       mPaint2.color = Color.YELLOW
       mPaint2.style = Paint.Style.FILL
   }

   /* override fun onDraw(canvas: Canvas) {
        canvas.drawRect(0F,0F,measuredWidth.toFloat(),measuredHeight.toFloat(),mPaint1)
        canvas.drawRect(10F,10F,measuredWidth.toFloat()-10F,measuredHeight.toFloat()-10F,mPaint2)
        canvas.save()
        canvas.translate(10F,0F)
        super.onDraw(canvas)
        canvas.restore()
    }*/


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if(mViewWidth==0F){
            mViewWidth =measuredWidth.toFloat()
            if (mViewWidth>0F){
                mPaint = paint
                mLinearGradient = LinearGradient(0F,0F,mViewWidth,0F, intArrayOf(Color.BLUE,Color.WHITE,Color.BLUE),null,Shader.TileMode.CLAMP)
                mPaint.setShader(mLinearGradient)
                mGradientMatrix = Matrix()


            }
        }
    }


    override  fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        if(mGradientMatrix!=null){
            mTranslate+=mViewWidth/5
            if(mTranslate>2*mViewWidth){
                mTranslate =-mViewWidth
            }
        mGradientMatrix.setTranslate(mTranslate,0F)
            mLinearGradient.setLocalMatrix(mGradientMatrix)
            postInvalidateDelayed(100L)
        }
    }




}