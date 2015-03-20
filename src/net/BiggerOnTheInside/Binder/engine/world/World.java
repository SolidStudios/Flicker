/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine.world;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.BiggerOnTheInside.Binder.Player;
import net.BiggerOnTheInside.Binder.engine.UniverseEntity;

public class World implements UniverseEntity{
	private FirstPersonCamera camera;
	private Chunk c;
	private Player p;
	
	public World(){
		initGL();
		init();
	}
	
	@Override
	public void addEntities() {
	}

	@Override
	public void initGL() {
	}

	@Override
	public void init() {
		c = new Chunk(0, 0, 0);
		p = new Player("Kirk", 0, 0);
	}

	@Override
	public void create() {
	}

	@Override
	public void rebuild() {
	}

	@Override
	public void render() {
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			dispose();
		}
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		c.render();
		//switchTo3D();
		//render3D();
		//glColor3f(1, 1, 1);
		//switchTo2D();
		//render2D();
	}

	@Override
	public void update() {
		p.update();
	}

	@Override
	public void dispose() {
		c.dispose();
		System.exit(0);
	}

}
