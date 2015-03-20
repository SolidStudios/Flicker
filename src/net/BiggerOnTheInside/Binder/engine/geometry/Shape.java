/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine.geometry;

import net.BiggerOnTheInside.Binder.engine.Color4f;
import net.BiggerOnTheInside.Binder.engine.block.Block;

public class Shape {
	public static float[] createCubeVertices(float x, float y, float z, float size){
		return new float[]{
				// Bottom face
				x, y, z + size,
				x + size, y, z + size,
				x + size, y, z,
				x, y, z,
				
				// Top face
				x, y + size, z,
				x + size, y + size, z,
				x + size, y + size, z + size,
				x, y + size, z + size,
				
				// Front face
				x, y, z,
				x + size, y, z,
				x + size, y + size, z,
				x, y + size, z,
				
				// Back face
				x, y + size, z + size,
				x + size, y + size, z + size,
				x + size, y, z + size,
				x, y + size, z,
				
				// Left face
				x + size, y, z,
				x + size, y, z + size,
				x + size, y + size, z + size,
				x + size, y + size, z,
				
				// Right face
				x, y, z + size,
				x, y, z,
				x, y + size, z,
				x, y + size, z + size
		};
	}
	
	public static float[] createCubeColors(byte id){
		Color4f color = Block.GRASS_BLOCK.getColor();
		
		return new float[]{
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a,
			color.r, color.g, color.b, color.a
		};
	}
}
