/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.block;

import io.github.SolidStudiosTeam.Flicker.engine.Color4f;

public class VoidBlock extends Block{
	@Override
	public byte getID() {
		return 0;
	}

	@Override
	public BlockTextureCoordinates getTextureCoordinates(BlockFace blockFace) {
		return new BlockTextureCoordinates(4f, 11f);
	}

	@Override
	public Color4f getColor() {
		return new Color4f(0f, 0f, 0f, .5f);
	}
}
