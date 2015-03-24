/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.geometry;

import static org.lwjgl.opengl.GL11.*;
import io.github.SolidStudiosTeam.Flicker.engine.SpriteSheet;
import io.github.SolidStudiosTeam.Flicker.engine.block.Block;
import io.github.SolidStudiosTeam.Flicker.engine.block.Block.BlockFace;

public class VoxelGeometry{
	public static void createVoxel(float x, float y, float z, byte id, float size){
		// right face
        //glColor4f(Block.getBlock(id).getColor().r, Block.getBlock(id).getColor().g, Block.getBlock(id).getColor().b, Block.getBlock(id).getColor().a);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY() + SpriteSheet.blockTextures.uniformSize());
        	glVertex3f(x, y, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY());
        	glVertex3f(x, y, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY());
        	glVertex3f(x, y + size, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY() + SpriteSheet.blockTextures.uniformSize());
        	glVertex3f(x, y + size, z + size);
        
        // left face
        //glColor4f(Block.getBlock(id).getColor().r, Block.getBlock(id).getColor().g, Block.getBlock(id).getColor().b, Block.getBlock(id).getColor().a);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getY());
        glVertex3f(x + size, y, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getY());
        glVertex3f(x + size, y, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x + size, y + size, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.LEFT).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x + size, y + size, z);
        
        // back face
        //glColor4f(Block.getBlock(id).getColor().r, Block.getBlock(id).getColor().g, Block.getBlock(id).getColor().b, Block.getBlock(id).getColor().a);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getY());
        glVertex3f(x, y + size, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getY());
        glVertex3f(x + size, y + size, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x + size, y, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.BACK).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x, y, z + size);
        
        // front face
        //glColor4f(Block.getBlock(id).getColor().r, Block.getBlock(id).getColor().g, Block.getBlock(id).getColor().b, Block.getBlock(id).getColor().a);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getY());
        glVertex3f(x, y, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getY());
        glVertex3f(x + size, y, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x + size, y + size, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.FRONT).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x, y + size, z);
        
        // top face
        //glColor4f(Block.getBlock(id).getColor().r, Block.getBlock(id).getColor().g, Block.getBlock(id).getColor().b, Block.getBlock(id).getColor().a);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getY());
        glVertex3f(x, y + size, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getY());
        glVertex3f(x + size, y + size, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x + size, y + size, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.TOP).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x, y + size, z + size);    
        
		//bottom face
        //glColor4f(Block.getBlock(id).getColor().r, Block.getBlock(id).getColor().g, Block.getBlock(id).getColor().b, Block.getBlock(id).getColor().a);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BOTTOM).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY());
        glVertex3f(x, y, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BOTTOM).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY());
        glVertex3f(x + size, y, z + size);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BOTTOM).getX() + SpriteSheet.blockTextures.uniformSize(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x + size, y, z);
        glTexCoord2f(Block.getBlock(id).getTextureCoordinates(BlockFace.BOTTOM).getX(), Block.getBlock(id).getTextureCoordinates(BlockFace.RIGHT).getY() + SpriteSheet.blockTextures.uniformSize());
        glVertex3f(x, y, z);
	}
}
