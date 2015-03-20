/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine.block;

import net.BiggerOnTheInside.Binder.engine.Color4f;

public class DirtBlock extends Block{
	@Override
	public byte getID() {
		return 2;
	}

	@Override
	public void getTextureCoordinates(BlockFace blockFace) {
	}

	@Override
	public Color4f getColor() {
		return Color4f.GREEN;
	}
}
