package com.example.showdata;

import com.example.cantoolapp.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyWatch extends View{


	    private Paint paint;
	    private Paint textPaint;

	    private int mWidth;
	    private int mHeight;

	    int speed = 0;
	    float radius;
	    //    private Bitmap back;
	    private Bitmap center;
	    private Bitmap arrow;
	    private int left;
	    private int top;

	    public MyWatch(Context context) {
	        this(context, null, 0);
	    }

	    public MyWatch(Context context, AttributeSet attrs) {
	        this(context, attrs, 0);
	    }

	    public MyWatch(Context context, AttributeSet attrs, int defStyleAttr) {
	        super(context, attrs, defStyleAttr);
	        /**
	         * ���������������Զ�����ʽ����
	         */
	        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyWatch, defStyleAttr, 0);

	        speed = a.getInt(R.styleable.MyWatch_speed, 0);

	        paint = new Paint();
	        textPaint = new Paint();

	        radius = a.getDimension(R.styleable.MyWatch_radius, 200);

	        center = BitmapFactory.decodeResource(getResources(), R.drawable.icon_watch_center);
	        arrow = BitmapFactory.decodeResource(getResources(), R.drawable.icon_watch_arrow);

	        a.recycle();

	    }

	    @Override
	    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
	        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
	        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
	        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

	        if (widthMode == MeasureSpec.EXACTLY) {
	            mWidth = widthSize;
	        } else {
	            float needWidth = radius * 2+8;
	            int desired = (int) (getPaddingLeft() + needWidth + getPaddingRight());
	            mWidth = desired;
	        }

	        if (heightMode == MeasureSpec.EXACTLY) {
	            mHeight = heightSize;
	        } else {
	            float needWidth = radius+24;
	            int desired = (int) (getPaddingTop() + needWidth + getPaddingBottom());
	            mHeight = desired;
	        }

	        setMeasuredDimension(mWidth, mHeight);
	    }

	    @Override
	    protected void onDraw(Canvas canvas) {

	        paint.setStrokeWidth(6);
	        paint.setColor(getResources().getColor(R.color.watchBlue));
	        paint.setStyle(Paint.Style.STROKE);
	        //�����
	        paint.setAntiAlias(true);

	        //���Ʊ���
	        RectF oval1 = new RectF(4, 4, radius * 2, radius * 2);// ���ø��µĳ����Σ�ɨ�����
	        canvas.drawArc(oval1, -180, 180, false, paint);

	        //����ָ��
	        paint.setColor(Color.WHITE);
	        float arc = (float) (speed % 140) * 180 / 140;

	        canvas.save(); //��¼����״̬
	        canvas.rotate(-90+arc, mWidth / 2, radius);
	        canvas.drawLine(mWidth / 2, 20, mWidth / 2, radius, paint);//��ָ��
	        canvas.restore();

	        //����Բ��
	        // �������λ��
	        left = mWidth / 2 - center.getWidth() / 2;
	        // �����ϱ�λ��
	        top = mHeight - center.getHeight();
	        canvas.drawBitmap(center, left, top, paint);

	        //���հٷֱȻ��ƿ̶�
	        //����С�̶�
	        canvas.save(); //��¼����״̬
	        canvas.rotate(-90, mWidth / 2, radius);
	        float rAngle1 = (float) 180.0 / 70;
	        canvas.drawLine(mWidth / 2, 3, mWidth / 2, 40, paint);//���̶���

	        for (int i = 0; i < 70; i++) {
	            canvas.rotate(rAngle1, mWidth / 2, radius);
	            canvas.drawLine(mWidth / 2, 10, mWidth / 2, 30, paint);//���̶���
	            //            canvas.drawText("" + i * 10, getWidth() / 2 - mArcWidth * 2, 40, paintouter_Num);//���̶�

	        }
	        canvas.restore();

	        //���ƴ�̶ȺͶ���
	        paint.setColor(getResources().getColor(R.color.watchBlue));

	        textPaint.setColor(Color.WHITE);
	        textPaint.setTextSize(30);
	        textPaint.setTextAlign(Paint.Align.CENTER);
	        //�����
	        textPaint.setAntiAlias(true);

	        canvas.save(); //��¼����״̬
	        canvas.rotate(-90, mWidth / 2, radius);
	        float rAngle = (float) 180 / 14;
	        canvas.drawLine(mWidth / 2, 3, mWidth / 2, 40, paint);//���̶���
//	        canvas.drawText("" + 0, mWidth / 2, 75, textPaint);//���̶�
	        for (int i = 0; i < 14; i++) {
	            canvas.rotate(rAngle, mWidth / 2, radius);
	            canvas.drawLine(mWidth / 2, 4, mWidth / 2, 40, paint);//���̶���
//	            canvas.drawText("" + (i+1)* 10, mWidth / 2, 75, textPaint);//���̶�

	        }
	        canvas.restore();

	        //��������
	        textPaint.setStrokeWidth(4);
	        textPaint.setTextSize(90);

//	        canvas.drawText(speed % 140 + "", mWidth / 2, mHeight * 2 / 3, textPaint);

	    }

	    public void setSpeed(int speed) {
	        this.speed = speed;
	        invalidate();
	}
}
