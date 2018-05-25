package com.example.zhouxw.guo

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
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
                mLastY = y
                mStart =scrollY
            }
            MotionEvent.ACTION_MOVE ->{
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
                mEnd =scrollY
                var dScrollY =mEnd-mStart
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

    override fun computeScroll() {
        super.computeScroll()
        if (mScroller!!.computeScrollOffset()){
            scrollTo(0,mScroller!!.currY)
            postInvalidate()
        }
    }

 }