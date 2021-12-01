package core;

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

    public boolean isExpired() {
        return expired;
    }

    public Particle(float x, float y, float xSpeed, float ySpeed, float size, float expirationTime) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.size = size;
        this.expirationTime = expirationTime;
        this.expired = false;
        this.time = 0;
    }

    public void update()
    {
        this.x += xSpeed;
        this.y += ySpeed;
        if(time > expirationTime)
        {
            expired = true;
        }
        time++;
    }

    public void render(Graphics g, int type)
    {
        switch(type)
        {
            case 0:
                g.fillOval(this.x, this.y, this.size, this.size);
                break;
            case 1:
                g.fillRect(this.x, this.y, this.size, this.size);
                break;
            case 2:
                g.fillRoundRect(this.x, this.y ,this.size, this.size, 1);
        }
    }

}
