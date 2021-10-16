package com.david.hitball;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class StartScreen extends View
{

    private int screenW;
    private int screenH;
    private Bitmap startPageLogo;
    private Bitmap btnStartUp;
    private Bitmap btnStartDown;
    private boolean playBtnState;
    private Context MyContext;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }

    public StartScreen(Context context)
    {
        super(context);
        MyContext = context;
        startPageLogo = BitmapFactory.decodeResource(getResources(),R.drawable.start_page);
        btnStartUp = BitmapFactory.decodeResource(getResources(),R.drawable.play_btn_up);
        btnStartDown = BitmapFactory.decodeResource(getResources(),R.drawable.play_btn_down);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //  super.onDraw(canvas);
        canvas.drawBitmap(startPageLogo, (screenW-startPageLogo.getWidth())/2,(int)(screenH*0.10), null);
        if (playBtnState) {canvas.drawBitmap(btnStartDown, (screenW-btnStartDown.getWidth())/2,
                (int)(screenH*0.75), null);
        } else {
            canvas.drawBitmap(btnStartUp,
                    (screenW-btnStartUp.getWidth())/2,
                    (int)(screenH*0.75), null);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // return super.onTouchEvent(event);
        int action = event.getAction();
        int touchX = (int)event.getX();
        int touchY = (int)event.getY();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                if ((touchX > (screenW-btnStartUp.getWidth())/2 &&
                        touchX< ((screenW-btnStartUp.getWidth())/2) +
                                btnStartUp.getWidth())&& ((touchY > (int)(screenH*0.75)) &&
                        (touchY < ((int)(screenH*0.75) +
                                btnStartUp.getHeight())))) {
                    playBtnState = true;
                }

                break;

            case MotionEvent.ACTION_UP:
                if(playBtnState)
                {
                    Intent gameIntent = new Intent(MyContext,GameOn.class);
                    MyContext.startActivity(gameIntent);
                }
                playBtnState = false;

                break;

            case MotionEvent.ACTION_MOVE:

                break;


        }
        invalidate();
        return true;
    }
}
