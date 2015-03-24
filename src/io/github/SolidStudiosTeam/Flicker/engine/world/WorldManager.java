/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.world;

import io.github.SolidStudiosTeam.Flicker.engine.Constants;
import io.github.SolidStudiosTeam.Flicker.engine.Shader;
import io.github.SolidStudiosTeam.Flicker.engine.ShaderProgram;
import io.github.SolidStudiosTeam.Flicker.engine.SpriteSheet;
import io.github.SolidStudiosTeam.Flicker.engine.entity.mob.MobManager;

import java.util.ArrayList;

public class WorldManager {
	@SuppressWarnings("unused")
	private ArrayList<Chunk> loadedChunks;
	private ArrayList<Chunk> activeChunks;
	private ShaderProgram shader;
	private MobManager mobManager;
	
	/**
	 * 
	 */
	public WorldManager(){
		initGL();
		init();
		createWorld();
	}
	
	/**
	 * @category OpenGL_Initializer
	 */
	private void initGL(){
		Shader temp = new Shader("shaders/Chunk.vert", "shaders/Chunk.frag");
		shader = new ShaderProgram(temp.getvShader(), temp.getfShader());
	}
	
	/**
	 * @category Object_Initializer
	 */
	private void init(){
		// Not in use.
		mobManager = new MobManager();
		loadedChunks = new ArrayList<Chunk>();
		activeChunks = new ArrayList<Chunk>();
	}

	/**
	 * @category Object_Builder
	 */
	private void createWorld(){
		for(int x = 0; x < Constants.VIEW_DISTANCE; x++){
			for(int y = 0; y < Constants.VIEW_DISTANCE; y++){
				for(int z = 0; z < Constants.VIEW_DISTANCE; z++){
					activeChunks.add(new Chunk(shader, 1, x * Chunk.CHUNKSIZE, y * Chunk.CHUNKSIZE, z * Chunk.CHUNKSIZE));
				}
			}
		}
	}
	
	public void update(){
		mobManager.update();
	}
	
	public void render(){
		SpriteSheet.blockTextures.bind();
		getMobManager().getPlayer().getCamera().applyTranslations();
		
		for(int i = 0; i < activeChunks.size(); i++){
			activeChunks.get(i).render();
		}
		
		mobManager.render();
	}
	
	public MobManager getMobManager(){
		return mobManager;
	}
}
