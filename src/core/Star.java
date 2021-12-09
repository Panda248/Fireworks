package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Star {
    private float x;
    private float y;
    private int size;

    Star()
    {
        x = (float) (Math.random() * Main.getScreenWidth());
        y = (float) (Math.random() * Main.getScreenHeight());
        size = (int) (Math.random()*3 + 1);

    }
    public void update()
    {

        x+=(float)(Math.random()*0.5);
        if(x > Main.getScreenWidth())
        {
            x = 0;
            y = (float) (Math.random() * Main.getScreenHeight());
            size = (int) (Math.random()*3 + 1);
        }
    }
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.drawOval(x,y,size,size);
    }
}
