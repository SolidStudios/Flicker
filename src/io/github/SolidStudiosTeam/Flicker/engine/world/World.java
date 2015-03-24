/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.world;

import static org.lwjgl.opengl.GL11.*;
import io.github.SolidStudiosTeam.Flicker.engine.UniverseEntity;
import io.github.SolidStudiosTeam.Flicker.engine.block.Block;

public class World implements UniverseEntity{
	private WorldManager worldManager;
	
	public World(){
		initGL();
		init();
	}
	
	@Override
	public void addEntities() {
	}

	@Override
	public void initGL() {
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glEnable(GL_CULL_FACE);
		
		glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
	}

	@Override
	public void init() {
		Block.createBlockMap();
		worldManager = new WorldManager();
	}

	@Override
	public void create() {
	}

	@Override
	public void rebuild() {
	}

	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
		glCullFace(GL_FRONT);
		glColor3f(1, 1, 1);
		
		worldManager.render();
		
		glCullFace(GL_BACK);
	}

	@Override
	public void update() {
		worldManager.update();
	}

	@Override
	public void dispose() {
		System.exit(0);
	}
}
