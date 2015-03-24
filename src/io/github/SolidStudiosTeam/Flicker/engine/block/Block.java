/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.block;

import io.github.SolidStudiosTeam.Flicker.engine.Color4f;

import java.util.HashMap;

public abstract class Block {
	public static HashMap<Byte, Block> BLOCKMAP = new HashMap<Byte, Block>();
	
	public static Block VOID_BLOCK = new VoidBlock();
	public static Block AIR_BLOCK = new AirBlock();
	public static Block GRASS_BLOCK = new GrassBlock();
	public static Block COBBLESTONE_BLOCK;

	public abstract byte getID();
	public abstract BlockTextureCoordinates getTextureCoordinates(BlockFace blockFace);
	public abstract Color4f getColor();

	public enum BlockFace{
		FRONT, BACK, TOP, BOTTOM, LEFT, RIGHT;
	}

	public static Block getBlock(byte id){
		return BLOCKMAP.get(id);
	}
	
	public static void createBlockMap(){
		BLOCKMAP.put((byte) -1, AIR_BLOCK);
		BLOCKMAP.put((byte) 0, VOID_BLOCK);
		BLOCKMAP.put((byte) 2, GRASS_BLOCK);
	}
}
