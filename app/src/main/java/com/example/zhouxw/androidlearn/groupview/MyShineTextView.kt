package com.example.zhouxw.androidlearn.groupview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by zhouxw on 2018/6/4.
 */
class MyShineTextView : TextView {
    private var mLinearGradient: LinearGradient? = null
    private var mGradientMatrix: Matrix? = null
    private var mPaint: Paint? = null
    private var mViewWidth = 0
    private var mTranslate = 0

    constructor(ctx :Context): super(ctx)
    constructor(ctx: Context,attrs : AttributeSet) :super(ctx,attrs)
    constructor(ctx: Context,attrs: AttributeSet,defSty:Int) : super(ctx,attrs,defSty)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (mViewWidth == 0) {
            mViewWidth = measuredWidth
            if (mViewWidth > 0) {
                mPaint = paint
                mLinearGradient = LinearGradient(
                        0f,
                        0f,
                        mViewWidth.toFloat(),
                        0f,
                        intArrayOf(Color.BLUE, -0x1, Color.BLUE), null,
                        Shader.TileMode.CLAMP)
                mPaint!!.shader = mLinearGradient
                mGradientMatrix = Matrix()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth
            }
            mGradientMatrix!!.setTranslate(mTranslate.toFloat(), 0f)
            mLinearGradient!!.setLocalMatrix(mGradientMatrix)
            postInvalidateDelayed(100)
        }
    }
}