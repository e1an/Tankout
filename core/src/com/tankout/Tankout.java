package com.tankout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Tankout extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Rectangle playerRect;
	SpriteBatch batch;
	Texture img;
	private Texture tankBodyTexture;
	private Sprite tankBodySprite;
	private Texture grassTexture;
	private Texture dirtTexture;
	
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		tankBodyTexture = new Texture("tankbody.png");
		grassTexture = new Texture("grass.png");
		dirtTexture = new Texture("dirt.png");
		
		playerRect = new Rectangle();
		playerRect.x = 1280 / 2 - 64 / 2;
		playerRect.y = 600;
		playerRect.width = 100;
		playerRect.height = 100;
		
		tankBodySprite = new Sprite(tankBodyTexture);
		tankBodySprite.setSize(100, 100);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		tankBodySprite.draw(batch);
		System.out.println(tankBodySprite.getX() + " " + tankBodySprite.getY());
		batch.end();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		tankBodyTexture.dispose();
		grassTexture.dispose();
		dirtTexture.dispose();
	}
}
