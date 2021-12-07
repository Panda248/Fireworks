package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Particle {
    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float size;
    private int time;
    private float expirationTime;
    private boolean expired;
    private Color color;

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public boolean isExpired() {
        return expired;
    }

    public Particle(float x, float y, float xSpeed, float ySpeed, float size, float expirationTime, Color color) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.size = size;
        this.expirationTime = expirationTime;
        this.expired = false;
        this.time = 0;
        this.color = color;
    }

    public void update()
    {
        this.x += xSpeed;
        this.y += ySpeed;
        if(this.time > expirationTime * 0.9)
        {
            this.color = this.color.darker(0.2f);
        }
        if(this.time > expirationTime)
        {
            this.expired = true;
        }
        else
        {
            this.time++;
        }



    }

    public void render(Graphics g, int type)
    {
        switch(type)
        {
            case 0:
                g.setColor(this.color);
                g.fillOval(this.x, this.y, this.size, this.size);
                break;
            case 1:
                g.setColor(this.color);
                g.fillRect(this.x, this.y, this.size, this.size);
                break;
            case 2:
                g.setColor(this.color);
                g.fillRoundRect(this.x, this.y ,this.size, this.size, 5);
        }
    }

}
