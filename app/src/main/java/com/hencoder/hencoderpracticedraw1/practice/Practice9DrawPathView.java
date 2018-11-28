package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        Path path = new Path();
        RectF rectF = new RectF();
        int left = getWidth() / 2 - 200;
        int right = getWidth()/2;
        int top = getHeight() / 2 - 200;
        int bottom = getHeight()/2;
        rectF.set(left,top,right,bottom);
        path.addArc(rectF,-225,225);

        RectF rectF1 = new RectF();
        int left1 = getWidth() / 2;
        int right1 = getWidth()/2 + 200;
        int top1 = getHeight() / 2 - 200;
        int bottom1 = getHeight()/2;
        rectF1.set(left1,top1,right1,bottom1);

        path.arcTo(rectF1,-180,225);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        path.lineTo(getWidth()/2,getHeight()/2+150);
        path.close();

        canvas.drawPath(path,paint);

    }
}
