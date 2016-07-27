package javaClass;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomProgress extends ImageView {

    private final int STROKE_WIDTH = 8;
    private Paint paint;
    private Paint textPaint;
    private int percent = 0;

    public CustomProgress(Context context) {
        super(context);
        initialize(context);
    }

    public CustomProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public CustomProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    private void initialize(Context context){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint();
        textPaint.setColor(Color.GREEN);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(35);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setPercent(int value){
        percent = value;
        postInvalidate();
    }

    public int getPercent(){
        return percent;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rect = new RectF();
        rect.left = 0 + STROKE_WIDTH;
        rect.right = getWidth() - STROKE_WIDTH;
        rect.top = 0 + STROKE_WIDTH;
        rect.bottom = getHeight() - STROKE_WIDTH;

        int sweepAngle = percent * 360 / 100;

        int red = (int )((100 - percent) * 2.5f);
        int green = (int)(percent * 2.5f);
        int bule = 0;
        paint.setColor(Color.rgb(red, green, bule));

        canvas.drawArc(rect, -90, sweepAngle, false, paint);
        canvas.drawText(String.valueOf(percent) , getWidth() / 2, getHeight() / 2, textPaint);
    }
}
