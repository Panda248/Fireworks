package core;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;

public class Firework {
    private ArrayList <Particle> firework1;
    private ArrayList <Particle> firework2;
    private ArrayList <Particle> firework3;

    public Firework()
    {
        firework1 = new ArrayList<Particle>();
        firework2 = new ArrayList<Particle>();
        firework3 = new ArrayList<Particle>();
    }

    public void createFirework(int button, float x, float y)
    {
        switch(button)
        {
            case Input.MOUSE_LEFT_BUTTON:
                for(int i = 0; i < 20; i++)
                {
                    firework1.add(new Particle(x, y, (float)(Math.random()*20 - 20), (float)(Math.random()*20 - 20), 5, 1000));
                }
                break;
            case Input.MOUSE_MIDDLE_BUTTON:

                break;
            case Input.MOUSE_RIGHT_BUTTON:

        }
    }

    public void update()
    {
        for(int i = 0; i < firework1.size(); i++)
        {
            if(firework1.get(i).isExpired())
            {
                firework1.remove(i);
                i--;
            }
        }
        for(int i = 0; i < firework2.size(); i++)
        {
            if(firework2.get(i).isExpired())
            {
                firework2.remove(i);
                i--;
            }
        }
        for(int i = 0; i < firework3.size(); i++)
        {
            if(firework3.get(i).isExpired())
            {
                firework3.remove(i);
                i--;
            }
        }
    }

    public void render(Graphics g)
    {
        for(Particle i : firework1)
        {
            i.render(g, 0);
        }
        for(Particle i : firework2)
        {
            i.render(g, 1);
        }
        for(Particle i : firework3)
        {
            i.render(g , 2);
        }
    }
}
