package com.example.zhouxw.androidlearn.groupview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.zhouxw.androidlearn.R

/**
 * Created by zhouxw on 2018/5/18.
 */
class TopBar : RelativeLayout {
    //TopBar上的元素，左按钮，右按钮，标题
    private lateinit var mLeftBtn: Button
    private lateinit var mRightBtn: Button
    private lateinit var mTitleView: TextView


    private lateinit var mLeftParams: ViewGroup.LayoutParams
    private lateinit var mRightParams: ViewGroup.LayoutParams
    private lateinit var mTitleParams: ViewGroup.LayoutParams

    //左按键属性值
    private var mLeftTextColor: Int = 0
    private lateinit var mLeftBackground: Drawable
    private lateinit var mLeftText: String

    //右按键属性值
    private var mRightTextColor: Int = 0
    private lateinit var mRightBackground: Drawable
    private lateinit var mRightText: String

    //title属性值
    private var mTitleTextSize: Float = 0F
    private var mTitleTextColor: Int = 0
    private lateinit var mTitle: String

    private  var mListener: topbarClickListener? =null


    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attrs: AttributeSet, defStyle: Int) : super(ctx, attrs, defStyle)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {
        //设置topbar背景
        setBackgroundColor(0xFFF59563.toInt())
        //通过这个方法，将attrs中定义的declare-styleable的所有属性的值存储到typeArray中
        var ta: TypedArray = ctx.obtainStyledAttributes(attrs, R.styleable.TopBar)

        //从TypeArray中取出对应的值来为要设置的属性赋值
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0)
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground)
        mLeftText = ta.getString(R.styleable.TopBar_leftText)
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground)
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0)
        mRightText = ta.getString(R.styleable.TopBar_rightText)
        mTitle = ta.getString(R.styleable.TopBar_title)
        mTitleTextSize = ta.getDimension((R.styleable.TopBar_titleTextSize), 10F)
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0)
        //获取完TypeArray的值以后，需要调用recycle方法来避免重新创建时出现错误
        ta.recycle()


        mLeftBtn = Button(ctx)
        mRightBtn = Button(ctx)
        mTitleView = TextView(ctx)

        //为创建的组件元素赋值，值来源于我们在引用的xml文件中给对应属性的赋值
        mLeftBtn.setTextColor(mLeftTextColor)
        mLeftBtn.background = mLeftBackground
        mLeftBtn.text = mLeftText

        mRightBtn.setTextColor(mRightTextColor)
        mRightBtn.background = mRightBackground
        mRightBtn.text = mRightText

        mTitleView.text = mTitle
        mTitleView.setTextColor(mTitleTextColor)
        mTitleView.setTextSize(mTitleTextSize)
        mTitleView.gravity = Gravity.CENTER

        //为组件设置相应的布局元素
        mLeftParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        (mLeftParams as LayoutParams).addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE)
        //添加到viewGroup
        addView(mLeftBtn, mLeftParams)

        mRightParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        (mRightParams as LayoutParams).addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE)
        addView(mRightBtn, mRightParams)

        mTitleParams = LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        (mTitleParams as LayoutParams).addRule(RelativeLayout.CENTER_IN_PARENT, TRUE)
        addView(mTitleView, mTitleParams)

        //按钮的点击事件，不进行具体实现，调用接口方法，回调时会具体实现
        mRightBtn.setOnClickListener {
            mListener!!.rightClick()
            Log.d("zhouxx","rightClick")

        }
        mLeftBtn.setOnClickListener { mListener!!.leftClick() }


    }

    /**
     * 设置按钮的显示与否通过ID区分按钮，flag区分是否要显示
     *
     * @param id id
     *
     * @param flag 是否显示
     *
     */
    fun setButtonVisable(id: Int, flag: Boolean) {
        if (flag) {
            if (id == 0) {
                mLeftBtn.visibility = View.VISIBLE
            } else {
                mRightBtn.visibility = View.VISIBLE
            }
        } else {
            if (id == 0) {
                mLeftBtn.visibility = View.GONE
            } else {
                mRightBtn.visibility = View.GONE
            }
        }
    }

    fun setOnTopbarClickListener(mListener: topbarClickListener) {
        this.mListener = mListener
    }


    interface topbarClickListener {
        fun leftClick()
        fun rightClick()
    }
}