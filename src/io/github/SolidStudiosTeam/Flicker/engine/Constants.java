/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine;

import java.util.Random;

public class Constants {
    public static final float MOUSE_SENSITIVITY = 0.5f;
    public static final float MOVEMENT_SPEED = 0.1f;
    public static float DELTA_X;
    public static float DELTA_Y;
    public static int DELTA_TIME;
    
    public static Random randomHelper = new Random();
    public static final int VIEW_DISTANCE = 4;
    public static final int AIRCHUNK = 0;
	public static final int MIXEDCHUNK = 1;
}
