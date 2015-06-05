package com.kebotz.cargame;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.security.*;
import com.badlogic.gdx.*;

public class Ingredient
{
	private Vector2 position;
	private int cookVelocity = 10;
	private float cookStatus;
	private static int RAW=0;
	private static int COOKED=100;
	private static int COOKING = 1;
	private static int SERVED = 2;
	private static int UNKNOWN = 0;
	private int state = COOKING;
	
	public Ingredient()
	{}
	public void draw(ShapeRenderer renderer){
		renderer.setColor(Color.PINK);
        renderer.circle(position.x, position.y, 50);
	
		
		renderer.setColor(0.0f, .0f, .0f, this.getFoodColor(cookStatus));
        renderer.circle(position.x, position.y, 50);
	}
    public void updatePosition(float x, float y)
    {
        this.position = new Vector2(x, y);
    }
	public void update(float delta)
	{
		if(isCooking())
		{
			cookStatus += cookVelocity * delta;
			
		}
	}
	private float getFoodColor(float status)
	{
		
		if(status > 100.0f)
			status = 100.0f;
		return status/100.0f;
		
	}
	public Boolean isCooked()
	{
		if(this.cookStatus >= COOKED)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public Boolean isCooking()
	{
		if(this.state == COOKING)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
