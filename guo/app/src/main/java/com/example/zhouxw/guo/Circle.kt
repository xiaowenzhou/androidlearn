package com.example.zhouxw.guo

/**
 * Created by zhouxw on 2018/5/24.
 */


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Circle : View {

    private var mMeasureHeigth: Int = 0
    private var mMeasureWidth: Int = 0

    private var mCirclePaint: Paint? = null
    private var mCircleXY: Float = 0.toFloat()
    private var mRadius: Float = 0.toFloat()

    private var mArcPaint: Paint? = null
    private var mArcRectF: RectF? = null
    private var mSweepAngle: Float = 0.toFloat()
    private var mSweepValue = 66f

    private var mTextPaint: Paint? = null
    private var mShowText: String? = null
    private var mShowTextSize: Float = 0.toFloat()

    constructor(context: Context, attrs: AttributeSet,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context) : super(context)

    override fun onMeasure(widthMeasureSpec: Int,
                           heightMeasureSpec: Int) {
        mMeasureWidth = View.MeasureSpec.getSize(widthMeasureSpec)
        mMeasureHeigth = View.MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(mMeasureWidth, mMeasureHeigth)
        initView()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint!!)
        // 绘制弧线
        canvas.drawArc(mArcRectF!!, 270f, mSweepAngle, false, mArcPaint!!)
        // 绘制文字
        canvas.drawText(mShowText!!, 0, mShowText!!.length,
                mCircleXY, mCircleXY + mShowTextSize / 4, mTextPaint!!)
    }

    private fun initView() {
        var length = 0f
        if (mMeasureHeigth >= mMeasureWidth) {
            length = mMeasureWidth.toFloat()
        } else {
            length = mMeasureHeigth.toFloat()
        }

        mCircleXY = length / 2
        mRadius = (length * 0.5 / 2).toFloat()
        mCirclePaint = Paint()
        mCirclePaint!!.isAntiAlias = true
        mCirclePaint!!.color = resources.getColor(
                android.R.color.holo_blue_bright)

        mArcRectF = RectF(
                (length * 0.1).toFloat(),
                (length * 0.1).toFloat(),
                (length * 0.9).toFloat(),
                (length * 0.9).toFloat())
        mSweepAngle = mSweepValue / 100f * 360f
        mArcPaint = Paint()
        mArcPaint!!.isAntiAlias = true
        mArcPaint!!.color = resources.getColor(
                android.R.color.holo_blue_bright)
        mArcPaint!!.strokeWidth = (length * 0.1).toFloat()
        mArcPaint!!.style = Style.STROKE

        mShowText = setShowText()
        mShowTextSize = setShowTextSize()
        mTextPaint = Paint()
        mTextPaint!!.textSize = mShowTextSize
        mTextPaint!!.textAlign = Paint.Align.CENTER
    }

    private fun setShowTextSize(): Float {
        this.invalidate()
        return 50f
    }

    private fun setShowText(): String {
        this.invalidate()
        return "Android Skill"
    }

    fun forceInvalidate() {
        this.invalidate()
    }

    fun setSweepValue(sweepValue: Float) {
        if (sweepValue != 0f) {
            mSweepValue = sweepValue
        } else {
            mSweepValue = 25f
        }
        this.invalidate()
    }
}