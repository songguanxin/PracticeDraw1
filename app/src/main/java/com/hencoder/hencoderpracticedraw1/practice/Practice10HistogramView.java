package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author sgx
 */
public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
          String string[] = {"ICS","K","L","M","N","O","P"};
          float ints[] = {50,200,300,500,200,450,360};

        TextPaint textPaint = new TextPaint();
        float yLength = 500f;
        float centerX = 200f;
        float centerY = 600f;
        float xLength = 900f;

        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);

        canvas.drawLine(centerX,centerY,centerX,centerY - yLength,textPaint);
        canvas.drawLine(centerX,centerY,xLength,centerY,textPaint);

        textPaint.setTextSize(40);
        for (int i = 1; i < ints.length ; i++) {
            textPaint.setStrokeWidth(50);
            textPaint.setColor(Color.GREEN);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);

            Path path = new Path();
            float x = centerX + 100 * i;
            path.moveTo(x,centerY);
            float y = centerY - ints[i];
            path.lineTo(x, y);
            canvas.drawPath(path,textPaint);

            textPaint.setStrokeWidth(50);
            textPaint.setColor(Color.WHITE);
            textPaint.setStyle(Paint.Style.FILL);
            //x轴文本
            canvas.drawText(string[i],x-10,centerY + 50,textPaint);
            //y轴文本
            canvas.drawText(i + "",centerX-40,centerY - 70 * i,textPaint);
        }
    }
}
