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
import com.zerodev.gameTemplate.screens.*;

public class GdxGame implements ApplicationListener {

	private Screen currentScreen;
	
	
	@Override
	public void create() {		
		currentScreen = new ScreenMenu(this);
		
	}

	@Override
	public void dispose() {
		currentScreen.dispose();
	}

	
	@Override
	public void render() {	
		currentScreen.update();
		currentScreen.draw();
	}

	@Override
	public void resize(int width, int height) {
		currentScreen.resize(width, height);
	}

	@Override
	public void pause() {
		currentScreen.pause();
	}

	@Override
	public void resume() {
		currentScreen.resume();
	}
	
	
	public void setScreen(Screen screen)
	{
		currentScreen.dispose();
		screen.load();
		currentScreen = screen;
	}
}
