package com.david.hitball;


import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Toast;

import java.util.Random;

public class BallTable extends View
{
    private Random alea;
    private Paint ballPaint;
    private int ballX;
    private int bally;
    private float ballRadius;
    private Obstacle[] obstacle = new Obstacle[5];
    private int cnt;
    private Context mcontext;
    private boolean fin;


    public BallTable(Context context)
    {
        super(context);
        mcontext = context;

        fin = false;
        cnt =0;
        alea = new Random();
        ballX = alea.nextInt(500);
        bally = alea.nextInt(500);

        ballPaint = new Paint();
        ballPaint.setAntiAlias(true);
        ballPaint.setColor(Color.BLACK);

        for (int i=0;i<5;i++)
        {
            Obstacle temp = new Obstacle();
            obstacle[i] = temp;

        }

        ballRadius = 30;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        // super.onDraw(canvas);
        canvas.drawCircle(ballX, bally, ballRadius, ballPaint);

        for (int i=0;i<5;i++)
        {

            obstacle[i].onDraw(canvas);
        }

        if(cnt>=5 && !fin)
        {
            Toast.makeText(mcontext,"La partie est termin�e",Toast.LENGTH_LONG).show();
            fin = true;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int action = event.getAction();
        int touchX = (int)event.getX();
        int touchY = (int)event.getY();

        boolean limitL,limitR,LimitU,LimitD = false;

        switch (action)
        {

            case MotionEvent.ACTION_MOVE:
                ballX = touchX;
                bally = touchY;

                for(int i =0;i<5;i++)
                {
                    limitL = ballX > (obstacle[i].getPosX()-30);
                    limitR =  ballX < (obstacle[i].getPosX()+30);
                    LimitU =  bally > (obstacle[i].getPosY()-30);
                    LimitD =  bally < (obstacle[i].getPosY()+30);

                    if(limitL && limitR && LimitD && LimitU )
                    {
                        if(obstacle[i].getStatus())
                        {
                            obstacle[i].setStatus(false);
                            cnt++;
                        }


                        System.out.println(cnt);

                    }

                }

                break;


        }
        invalidate();
        return true;
    }
}
