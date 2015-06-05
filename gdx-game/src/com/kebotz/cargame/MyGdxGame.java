package com.kebotz.cargame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.*;


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
	OrthographicCamera camera;
	float runningTime;

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
		camera = new OrthographicCamera();
		configureCamera();
		runningTime = 0;
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, 
				   Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		font.draw(batch, "x:"+tx+" y:"+ty,100,100);
		batch.end();
		
		runningTime += Gdx.graphics.getDeltaTime();
		ingredient.update(Gdx.graphics.getDeltaTime());
		//maybe create vextor is slow...
		
		Vector3 touchVector = new Vector3(tx, ty, 0);
		camera.unproject(touchVector);
        ingredient.updatePosition(touchVector.x, touchVector.y);
		
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		shapeRenderer.setProjectionMatrix(camera.combined);
         shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        ingredient.draw(shapeRenderer);
        shapeRenderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	private void configureCamera()
	{
		float size = 1600;
		if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
			camera.setToOrtho(false, size, size * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		else
			camera.setToOrtho(false, size * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), size);
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
