package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author sgx
 */
public class Practice8DrawArcView extends View {

    private TextPaint mPaint ;

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new TextPaint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
    //画圆弧
        int left= getWidth() / 2 ;
        int top = getHeight() / 2 - 100;
        int right = getWidth() / 2 + 500;
        int bottom = getHeight() / 2 + 100;
        RectF rectF = new RectF();
        rectF.left = left;
        rectF.top = top;
        rectF.right = right;
        rectF.bottom = bottom;
        canvas.drawArc(rectF,0,90,true,mPaint);

        canvas.drawArc(rectF,270,90,false,mPaint);

        //写字
        mPaint.setTextSize(40);
        canvas.drawText("圆心",getWidth()/2 + 220,getHeight()/2-20,mPaint);

        canvas.drawText("屏幕的坐标系",100f,100f,mPaint);


       //划线，xy轴以及表明方向的半圆弧
        mPaint.setStrokeWidth(10);
        canvas.drawLine(150,600,150,150,mPaint);
        canvas.drawLine(150,150,600,150,mPaint);

        canvas.drawText("x轴右向为正",550f,130f,mPaint);

        canvas.drawText("y轴下向为正",140,630,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(0,0,300,300,0,90,true,mPaint);

    //写画圆弧，扇形角度的旋转方向
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(40);

        canvas.translate(180,380);
        String source = "绘制圆弧或者扇形,由x轴至y轴顺时针方向旋转角度为正向";
        StaticLayout.Builder builder = StaticLayout.Builder
                .obtain(source,0,source.length(),mPaint,400);
        StaticLayout staticLayout = builder.build();
        staticLayout.draw(canvas);


    }
}
