package com.kebotz.cargame;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.g2d.*;

public class Ingredient
{
	private Vector2 position;
	
	public Ingredient()
	{}
	public void draw(ShapeRenderer renderer){
		renderer.setColor(Color.RED);
        renderer.circle(position.x, position.y, 50);
	}
    public void updatePosition(Vector2 pos)
    {
        this.position = pos;
    }
}
