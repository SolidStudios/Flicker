/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.block;

import io.github.SolidStudiosTeam.Flicker.engine.Color4f;

public class AirBlock extends Block{

	@Override
	public byte getID() {
		return -1;
	}

	@Override
	public BlockTextureCoordinates getTextureCoordinates(BlockFace blockFace) {
		return new BlockTextureCoordinates(-1f, -1f);
	}

	@Override
	public Color4f getColor() {
		return Color4f.WHITE;
	}

	
	
}
