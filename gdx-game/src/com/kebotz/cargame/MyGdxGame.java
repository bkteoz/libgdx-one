package com.kebotz.cargame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame implements ApplicationListener,InputProcessor
{

	int tx, ty; //for finger touch drag
	@Override
	public boolean keyUp(int p1)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean keyTyped(char p1)
	{
		// TODO: Implement this method
		return false;
	}


	@Override
	public boolean keyDown(int p1)
	{
		// TODO: Implement this method
		return false;
	}


	@Override
	public boolean touchDown(int p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean touchUp(int p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean touchDragged(int p1, int p2, int p3)
	{
		// TODO: Implement this method
		tx=p1;
		ty=p2;
		return true;
	}

	@Override
	public boolean mouseMoved(int p1, int p2)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean scrolled(int p1)
	{
		// TODO: Implement this method
		return false;
	}

	Texture texture;
	SpriteBatch batch;
	BitmapFont font;

    ShapeRenderer shapeRenderer;
    Ingredient ingredient;

	@Override
	public void create()
	{
		texture = new Texture(Gdx.files.internal("android.jpg"));
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		Gdx.input.setInputProcessor(this);
        shapeRenderer = new ShapeRenderer();
        ingredient = new Ingredient();
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, 
				   Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		font.draw(batch, "x:"+tx+" y:"+ty,100,100);
		batch.end();

        ingredient.updatePosition(new Vector2(tx, ty));

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        ingredient.draw(shapeRenderer);
        shapeRenderer.end();

	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
	
}
