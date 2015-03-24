/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine;

public class Color4f {
	public static final Color4f GREEN = new Color4f(0f, 1f, 0f, 1f);
	public static final Color4f WHITE = new Color4f(0f, 0f, 0f, 1f);
	
	public float r, g, b, a;
	
	public Color4f(float r, float g, float b, float a){
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
}
