package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author sgx
 */
public class Practice11PieChartView extends View {

    private String TAG = "Practice11PieChartView";

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        String string[] = {"ICS","K","L","M","N","O","P"};
        double ints[] = {0.4,0.2,0.1,0.2,0.1};
        int colors[] = {Color.DKGRAY,Color.BLUE,Color.GREEN,Color.RED,Color.YELLOW};
        float centerX = getWidth()/2;
        float centerY = getHeight()/2;
        float r = 200f;
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        float startAngle = 0;
        float sweepAngle = 0;
        RectF rectF = new RectF();
        float left = centerX - 200;
        float top = centerY - 200;
        float right = centerX + 200;
        float bottom = centerY + 200;
        rectF.set(left, top, right, bottom);

        for (int i = 0; i < ints.length ; i++) {
            textPaint.setColor(colors[i]);
            sweepAngle = (float) (360 * ints[i]);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, textPaint);
            startAngle += sweepAngle;
        }
    }
}
