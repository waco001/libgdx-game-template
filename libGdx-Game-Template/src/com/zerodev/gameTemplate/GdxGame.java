package com.zerodev.gameTemplate;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;

public class GdxGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private TextureRegion region;
	//private Sprite sprite;
	Button myButton;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		region = new TextureRegion(texture, 0, 0, 512, 275);
		region.flip(false, true);
		//sprite = new Sprite(region);
		//sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		//sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		//sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		Texture buttonTexture = new Texture(Gdx.files.internal("img/button/buttonupdown.png"));
		
		
		
		myButton = new Button(new TextureRegion(buttonTexture,0,0,100,20),new TextureRegion(buttonTexture,0,20,100,20));
		
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	float x = 0.45f;
	
	@Override
	public void render() {	
		ButtonStyle style = new ButtonStyle();
		
		if(myButton.isPressed)
			myButton.setStyle(style);

		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//sprite.draw(batch);
		batch.draw(region,0,0);
		
		
		myButton.draw(batch, 1);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
