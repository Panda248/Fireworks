package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState 
{	
	private int id;
	private Firework firework;
	private Star[] starfield;
	public Game(int id) 
	{
		this.id = id;
	}
	
	public int getID() 
	{
		return id;		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a game state for the *first time.*
		gc.setShowFPS(true);
		firework = new Firework();
		starfield = new Star[1000];
		for(int i = 0; i < starfield.length; i++)
		{
			starfield[i] = new Star();
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		// This is updates your game's logic every frame.  NO DRAWING.
		firework.update();
		for(Star i : starfield)
		{
			i.update();
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		// This code renders shapes and images every frame.
		for(Star i : starfield)
		{
			i.render(g);
		}
		g.setColor(new Color(25,51,0));
		g.fillRect(0,Main.getScreenHeight()*0.9f, Main.getScreenWidth(), Main.getScreenHeight()/10f);
		firework.render(g);

	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.  
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		// This code happens when you leave a gameState. 
	}

	public void keyPressed(int key, char c)
	{
		// This code happens every time the user presses a key
	}
	
	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
		firework.createFirework(button, x, y);
	}
	
	


}
