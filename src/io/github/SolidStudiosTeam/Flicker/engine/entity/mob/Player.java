/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.entity.mob;

import io.github.SolidStudiosTeam.Flicker.engine.camera.Camera;

public class Player extends Mob{
	public Player(Camera cam, int id) {
		super(cam, cam.getX(), cam.getY(), cam.getZ(), cam.getPitch(), cam.getYaw(), cam.getRoll(), id, 1);
	}

	@Override
	public void update() {
		move();
	}

	@Override
	public void move(){
		getCamera().updateMouse();
		getCamera().updateKeyboard(32, 2);
	}


	@Override
	public void dispose() {
	}
}
