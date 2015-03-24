/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.entity.mob;

import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glDeleteLists;
import static org.lwjgl.opengl.GL11.glGenLists;
import io.github.SolidStudiosTeam.Flicker.engine.camera.Camera;
import io.github.SolidStudiosTeam.Flicker.engine.entity.Renderable;

import java.util.ArrayList;

public class MobManager implements Renderable{
	private ArrayList<Mob> mobs;
	private Player player;
	private int mobRenderID;
	
	public MobManager(){
		initGL();
		init();
	}
	
	private void initGL(){
		mobRenderID = glGenLists(1);
	}
	
	private void init(){
		mobs = new ArrayList<Mob>();
		player = new Player(new Camera(0, 0, 0, 2, 90, -90, 1), 0);
	}

	@Override
	public void update() {
		for(int i = 0; i < mobs.size(); i++){
			if(mobs.get(i).isDead()){
				mobs.remove(i);
			}
			
			mobs.get(i).update();
		}
		
		player.update();
	}

	@Override
	public void render() {
		for(int i = 0; i < mobs.size(); i++){
			if(mobs.get(i).isDead()){
				mobs.get(i).render();
			}
		}
		
		glCallList(mobRenderID);
	}

	@Override
	public void dispose() {
		player.dispose();
		glDeleteLists(mobRenderID, 1);
	}
	
	public Player getPlayer(){
		return player;
	}
}
