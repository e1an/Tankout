package com.tankout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankout.entities.EntitySnapshot;
import com.tankout.entities.EntityType;
import com.tankout.entities.Player;
import com.tankout.world.GameMap;
import com.tankout.world.TiledGameMap;

public class Tankout extends ApplicationAdapter {
	SpriteBatch batch;

    OrthographicCamera camera;
    
    GameMap gameMap;
    
    float deltaX, deltaY;
    
    EntitySnapshot snapshot = new EntitySnapshot();
    Player player = new Player();
    
	@Override
	public void create () {
		
		snapshot.setX(500);
		snapshot.setY(500);
		
		player.create(snapshot, EntityType.PLAYER, gameMap);

		batch = new SpriteBatch();
		
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.update();
        
        gameMap = new TiledGameMap();
        
        
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        camera.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(camera, batch);

        player.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		gameMap.dispose();
	}
}
