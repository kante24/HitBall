package com.david.hitball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Obstacle {
    private int posX;
    private int posY;
    private Paint crayon;
    private Color pinceau;
    private Random alea;
    private int radius;
    private boolean status;

    private static final int[] palette = {Color.BLUE,Color.GREEN,Color.MAGENTA,Color.YELLOW};


    public Obstacle() {


        status = true;
        alea = new Random();
        posX = alea.nextInt(500);
        posY = alea.nextInt(500);

        crayon = new Paint();
        crayon.setAntiAlias(true);
        crayon.setColor(palette[alea.nextInt(3)]);

        radius = 30;


    }
    public boolean getStatus()
    {
        return this.status;
    }

    public void setStatus(Boolean state)
    {
        this.status = state;

        if (!this.status)
        {
            crayon.setColor(Color.TRANSPARENT);
        }
    }
    public int getPosX()
    {

        return this.posX;
    }

    public int getPosY()
    {
        return
                this.posY;
    }



    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(posX, posY, radius, crayon);
    }
}
