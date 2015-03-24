/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.block;

import io.github.SolidStudiosTeam.Flicker.engine.Color4f;

public class DirtBlock extends Block{
	@Override
	public byte getID() {
		return 1;
	}

	@Override
	public BlockTextureCoordinates getTextureCoordinates(BlockFace blockFace) {
		return new BlockTextureCoordinates(2f / 32f, 0f / 32f);
	}

	@Override
	public Color4f getColor() {
		return Color4f.GREEN;
	}
}
