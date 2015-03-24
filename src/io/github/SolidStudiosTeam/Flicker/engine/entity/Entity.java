/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.entity;

import io.github.SolidStudiosTeam.Flicker.engine.camera.Camera;

import org.lwjgl.util.vector.Vector3f;

/**
 * @author Walt
 * @category Renderable
 */
public class Entity {
	public static int lastID;
	
	private Vector3f pos, rot;
	private int id;
	private Camera cam;
	
	public Entity(float x, float y, float z, int id){
		this(x, y, z, 0, 0, 0, id);
	}
	
	public Entity(float x, float y, float z, float rx, float ry, float rz, int id){
		this(new Vector3f(x, y, z), new Vector3f(rx, ry, rz), id);
	}

	public Entity(Camera cam, int id){
		this(cam, new Vector3f(cam.getX(), cam.getY(), cam.getZ()), new Vector3f(cam.getPitch(), cam.getYaw(), cam.getRoll()), id);
	}
	
	public Entity(Camera cam, Vector3f pos, Vector3f rot, int id){
		this(pos, rot, id);
		
		this.cam = cam;
	}
	
	public Entity(Vector3f pos, Vector3f rot, int id){
		this.pos = pos;
		this.rot = rot;
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public Camera getCamera() {
		return cam;
	}

	/**
	 * @param cam
	 */
	public void setCamera(Camera cam) {
		this.cam = cam;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the pos
	 */
	public Vector3f getPos() {
		return pos;
	}

	/**
	 * @param pos The 3D vector to set the location too.
	 */
	public void setPos(Vector3f pos) {
		this.pos = pos;
	}

	/**
	 * @param x The X coordinate to set.
	 */
	public void setX(float x){
		this.pos.x = x;
	}
	
	/**
	 * @param y The Y coordinate to set.
	 */
	public void setY(float y){
		this.pos.y = y;
	}
	
	/**
	 * @param z The Z coordinate to set.
	 */
	public void setZ(float z){
		this.pos.z = z;
	}
	
	/**
	 * @return The X coordinate of pos.
	 */
	public float getX(){
		return pos.x;
	}
	
	/**
	 * @return The Y coordinate of pos.
	 */
	public float getY(){
		return pos.y;
	}
	
	public float getZ(){
		return pos.z;
	}
	
	/**
	 * @return the rot
	 */
	public Vector3f getRot() {
		return rot;
	}

	/**
	 * @param rot the rot to set
	 */
	public void setRot(Vector3f rot) {
		this.rot = rot;
	}
	
	/**
	 * @return Pitch of camera.
	 */
	public float getPitch(){
		return rot.x;
	}
	
	public float getYaw(){
		return rot.y;
	}
	
	public float getRoll(){
		return rot.z;
	}
	
	public void setPitch(float p){
		rot.x = p;
	}
	
	public void setYaw(float y){
		rot.y = y;
	}
	
	public void setRoll(float r){
		rot.z = r;
	}
}
