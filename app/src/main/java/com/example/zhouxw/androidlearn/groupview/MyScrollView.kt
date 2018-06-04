package com.example.zhouxw.androidlearn.groupview

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Scroller

/**
 * Created by zhouxw on 2018/5/25.
 */
class MyScrollView :ViewGroup {
    private  var mScreenHeight : Int=0
    private var mScroller :Scroller? =null
    private var mLastY : Int =0
    private var mStart : Int =0
    private var mEnd :Int =0

    constructor(ctx:Context,attrs:AttributeSet,defStyleAttr:Int) :super(ctx,attrs,defStyleAttr){initView(ctx)}
    constructor(ctx: Context,attrs: AttributeSet):super(ctx,attrs){initView(ctx)}
    constructor(ctx: Context) :super(ctx){initView(ctx)}

    private fun initView(ctx: Context){
        val wm = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm =DisplayMetrics()
        wm.defaultDisplay.getMetrics(dm)
        mScreenHeight =dm.heightPixels
        mScroller = Scroller(ctx)

    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for (i in 0 until childCount){
            measureChild(getChildAt(i),widthMeasureSpec,heightMeasureSpec)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //设置ViewGroup高度
        layoutParams.height =mScreenHeight*childCount
        for(i in 0 until childCount){
            if (getChildAt(i).visibility!= View.GONE){
                getChildAt(i).layout(1,i*mScreenHeight,r,(i+1)*mScreenHeight)
            }
        }
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        var y =event.y.toInt()
        when(event.action){
            MotionEvent.ACTION_DOWN ->{
                Log.e("zhouxx","ACTION_DOWN"+event.action)
                mLastY = y
                mStart =scrollY
            }
            MotionEvent.ACTION_MOVE ->{
                Log.e("zhouxx","ACTION_MOVE"+event.action)
                if(!mScroller!!.isFinished){
                    mScroller!!.abortAnimation()
                }
                var dy = mLastY - y
                if(scrollY<0){
                    dy= 0
                }
                if (scrollY>height-mScreenHeight){
                    dy =0
                }
                scrollBy(0,dy)
                mLastY =y
            }
            MotionEvent.ACTION_UP ->{
                Log.e("zhouxx","ACTION_UP"+event.action)
                var dScrollY =checkAlignment()
                if (dScrollY>0){
                    if(dScrollY<mScreenHeight/3){
                        mScroller!!.startScroll(0,scrollY,0,-dScrollY)
                    }else {
                        mScroller!!.startScroll(0,scrollY,0,mScreenHeight-dScrollY)
                    }
                } else {
                    if(-dScrollY<mScreenHeight/3){
                        mScroller!!.startScroll(0,scrollY,0,-dScrollY)
                    } else{
                        mScroller!!.startScroll(0,scrollY,0,-mScreenHeight-dScrollY)
                    }
                }
            }
        }
        postInvalidate()
        return true
    }


    private fun checkAlignment(): Int {
        val mEnd = scrollY
        val isUp = mEnd - mStart > 0
        val lastPrev = mEnd % mScreenHeight
        val lastNext = mScreenHeight - lastPrev
        return if (isUp) {
            //向上的
            lastPrev
        } else {
            -lastNext
        }
    }

    override fun computeScroll() {
        super.computeScroll()
        if (mScroller!!.computeScrollOffset()){
            scrollTo(0,mScroller!!.currY)
            postInvalidate()
        }
    }

 }