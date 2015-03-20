/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine.block;

import net.BiggerOnTheInside.Binder.engine.Color4f;

public abstract class Block {
	public static Block AIR_BLOCK = new AirBlock();
	public static Block GRASS_BLOCK = new dc();
	public static Block DIRT_BLOCK;
	public static Block COBBLESTONE_BLOCK;

	public enum BlockFace{
		FRONT, BACK, TOP, BOTTOM, LEFT, RIGHT;
	}

	public Block getBlock(byte type){
		switch(type){
		case 0:
			return Block.AIR_BLOCK;
		case 1:
			return Block.GRASS_BLOCK;
		case 2:
			return Block.DIRT_BLOCK;
		case 3:
			return Block.COBBLESTONE_BLOCK;
		default:
			return Block.AIR_BLOCK;
		}
	}
	
	public abstract byte getID();
	public abstract void getTextureCoordinates(BlockFace blockFace);
	public abstract Color4f getColor();
}
