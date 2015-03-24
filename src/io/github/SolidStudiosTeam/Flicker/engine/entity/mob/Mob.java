/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.entity.mob;

import io.github.SolidStudiosTeam.Flicker.engine.camera.Camera;
import io.github.SolidStudiosTeam.Flicker.engine.entity.Entity;
import io.github.SolidStudiosTeam.Flicker.engine.entity.Renderable;

public class Mob extends Entity implements Renderable{
	private int mobID;
	private boolean isDead;
	
	/**
	 * @param cam
	 * @param x
	 * @param y
	 * @param z
	 * @param id
	 * @param mobID
	 */
	public Mob(Camera cam, float x, float y, float z, int id, int mobID){
		this(cam, cam.getX(), cam.getY(), cam.getZ(), 0, 0, 0, id, mobID);
	}
	
	/**
	 * @param cam
	 * @param x
	 * @param y
	 * @param z
	 * @param rx
	 * @param ry
	 * @param rz
	 * @param id
	 * @param mobID
	 */
	public Mob(Camera cam, float x, float y, float z, float rx, float ry, float rz, int id, int mobID) {
		super(cam, id);
		
		this.mobID = mobID;
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		getCamera().applyTranslations();
	}

	public void move(){
	}
	
	@Override
	public void dispose() {
	}
	
	/**
	 * @return
	 */
	public int getID(){
		return mobID;
	}
	
	/**
	 * @param id
	 */
	public void setID(int id){
		this.mobID = id;
	}
	
	/**
	 * @return
	 */
	public boolean isDead(){
		return isDead;
	}
	
	/**
	 * @param dead
	 */
	public void setDead(boolean dead){
		this.isDead = dead;
	}
}
