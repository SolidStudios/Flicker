/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.block;

import io.github.SolidStudiosTeam.Flicker.engine.Color4f;

public class GrassBlock extends Block {
	@Override
	public byte getID() {
		return 2;
	}

	@Override
	public BlockTextureCoordinates getTextureCoordinates(BlockFace blockFace) {
		if(blockFace == BlockFace.BACK || blockFace == BlockFace.FRONT || blockFace == BlockFace.LEFT || blockFace == BlockFace.RIGHT){
			return new BlockTextureCoordinates(1f / 16f, 1f / 16f);
		}
		else if(blockFace == BlockFace.TOP){
			return new BlockTextureCoordinates(0f / 32f, 0f / 32f);
		}
		else{
			return new BlockTextureCoordinates(1f / 16f, 1f / 16f);
		}
	}

	@Override
	public Color4f getColor() {
		return Color4f.GREEN;
	}
}
