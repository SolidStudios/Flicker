/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine;

public interface UniverseEntity {
	public void addEntities();
	public void initGL();
	public void init();
	public void create();
	public void rebuild();
	public void render();
	public void update();
	public void dispose();
}
