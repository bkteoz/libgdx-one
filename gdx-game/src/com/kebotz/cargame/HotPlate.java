package com.kebotz.cargame;
import java.security.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.math.*;
import android.util.*;
import com.badlogic.gdx.graphics.*;

public class HotPlate
{
	Vector2 position;
	int width;
	int height;
	
	public HotPlate(float x, float y, int w, int h)
	{
		position = new Vector2(x, y);
		this.width = w;
		this.height = h;
	}
	public void draw(ShapeRenderer shapeRenderer)
	{
		shapeRenderer.setColor(Color.GREEN);
		shapeRenderer.rect(position.x, position.y, width, height);
		
	}
}
