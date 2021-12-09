package core;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import java.util.ArrayList;

public class Firework {
    private ArrayList <Particle> firework1;
    private ArrayList <Particle> firework2;
    private ArrayList <Particle> firework3;
    private int counter = 0;
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
                    firework1.add(new Particle(x, y, (float)(Math.random()*10 - 5), (float)(Math.random()*10- 5), 5,  100, randomColor()));
                }
                break;
            case Input.MOUSE_MIDDLE_BUTTON:
                for(int i = 0; i < 20; i++)
                {
                    firework2.add(new Particle(x, y, (float)(Math.random()*6 - 3), (float)(Math.random()*6), 10,  100, randomColor()));
                }
                break;
            case Input.MOUSE_RIGHT_BUTTON:
                for(int i = 0; i < 20; i++)
                {
                    firework3.add(new Particle(x, y, (float)(Math.random()*10 - 5), (float)(Math.random()*10- 5), 15,  50, randomColor()));
                }
        }
    }

    public void update()
    {
        for(int i = 0; i < firework1.size(); i++)
        {
            firework1.get(i).update();
            if(firework1.get(i).isExpired())
            {
                firework1.remove(i);
                i--;
            }
        }
        for(int i = 0; i < firework2.size(); i++)
        {
            firework2.get(i).update();
            if(counter == 10)
            {
                for (int j = 0; j < firework2.size(); j++) {
                    firework1.add(new Particle(firework2.get(j).getX(), firework2.get(j).getY(), (float) (Math.random() * 4 - 2), (float) (Math.random() * 4 - 2), 5, 50, randomColor()));
                }
                counter = 0;
            }
            if(firework2.get(i).isExpired())
            {
                firework2.remove(i);
                i--;
            }
            counter++;
        }
        for(int i = 0; i < firework3.size(); i++)
        {
            firework3.get(i).update();
            if(firework3.get(i).isExpired())
            {
                for(int j = 0; j < 30; j++)
                {
                    firework1.add(new Particle(firework3.get(i).getX(), firework3.get(i).getY(), (float)(Math.random()*20 - 10), (float)(Math.random()*20- 10), 5,  100, randomColor()));
                }
                for(int j = 0; j < 10; j++)
                {
                    firework1.add(new Particle(firework3.get(i).getX(), firework3.get(i).getY(), (float)(Math.random()*10 - 5), (float)(Math.random()*10- 5), 5,  100, randomColor()));
                }
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
    public Color randomColor()
    {
        switch((int)(Math.random()*5))
        {
            case 0:
                return Color.white;

            case 1:
                return Color.yellow;

            case 2:
                return Color.green;

            case 3:
                return Color.blue;

            case 4:
                return Color.red;
        }
        return null;
    }
}
