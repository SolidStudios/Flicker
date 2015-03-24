/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine;

public class SpriteSheet {
	public static SpriteSheet blockTextures = new SpriteSheet("spritesheets/terrain.png", 16);
	
	private Texture texture;
	private String path;
	private float size;
	
	/**
	 * @param path Path to image.
	 * @param size Size in pixels of all textures. (eg. 8, 16, 32, 64...).
	 */
	public SpriteSheet(String path, float size){
		this.path = path;
		this.size = 1f / size;
		
		load();
	}
	
	private void load(){
		texture = Texture.loadTexture(path);
	}
	
	public void bind(){
		texture.bind();
	}
	
	public void unbind(){
		texture.unbind();
	}
	
	public void delete(){
		texture.delete();
	}
	
	public float uniformSize(){
		return size;
	}
}
