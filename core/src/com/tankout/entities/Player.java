package com.tankout.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankout.world.GameMap;

public class Player extends Entity {

	private static final int SPEED = 80;
	private static final int JUMP_VEL = 5; //TEMPORARY
	
	Texture image;
	
	@Override
	public void create(EntitySnapshot snapshot, EntityType type, GameMap map) {
		super.create(snapshot, type, map);
		image = new Texture("tankbody.png");
		
	}
	
	@Override
	public void update(float deltaTime, float gravity) {
		if(Gdx.input.isKeyPressed(Keys.SPACE) && grounded) {
			this.velocityY += JUMP_VEL * getWeight();
		}else if(Gdx.input.isKeyPressed(Keys.SPACE) && !grounded && this.velocityY > 0) {
			this.velocityY += JUMP_VEL * getWeight() * deltaTime;
		}
		
		super.update(deltaTime, gravity); //apply gravity
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			moveX(-SPEED * deltaTime);
		}
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			moveX(SPEED * deltaTime);
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(image, pos.x, pos.y, getWidth(), getHeight());
		batch.end();
		//DEBUG System.out.println(pos.x + " " + pos.y); //debug
	}
	
	
	@Override
	public EntitySnapshot getSaveSnapshot() {
		EntitySnapshot snapshot = super.getSaveSnapshot();
		//snapshot.putFloat("spawnRadius", spawnRadius);
		return snapshot;
	}
}
