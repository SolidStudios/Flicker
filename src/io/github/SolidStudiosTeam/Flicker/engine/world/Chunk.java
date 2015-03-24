/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine.world;

import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

import io.github.SolidStudiosTeam.Flicker.engine.Constants;
import io.github.SolidStudiosTeam.Flicker.engine.ShaderProgram;
import io.github.SolidStudiosTeam.Flicker.engine.UniverseEntity;
import io.github.SolidStudiosTeam.Flicker.engine.block.Block;
import io.github.SolidStudiosTeam.Flicker.engine.geometry.VoxelGeometry;

import org.lwjgl.util.vector.Vector3f;

/**
 * @author Walt Pach
 *
 */
public class Chunk implements UniverseEntity{
	public static final int CHUNKSIZE = 16;
	
	private boolean isActive, needsRebuilt;
	private Vector3f pos;
	private byte[][][] blocks;
	private int vcID, sizeX, sizeY, sizeZ, type;
	private ShaderProgram shader;
	private Random randomHelper;
	
	/**
	 * @param shader The ShaderProgram to use for this chunk.
	 * @param type The Chunk type, either 1 or 0.
	 * @param x The X start coordinate.
	 * @param y The Y start coordinate.
	 * @param z The Z start coordinate.
	 * @see ShaderProgram
	 */
	public Chunk(ShaderProgram shader, int type, float x, float y, float z){
		this(shader, type, new Vector3f(x, y, z));
	}
	
	/**
	 * @param shader The ShaderProgram to use for this chunk.
	 * @param type The Chunk type, either 1 or 0.
	 * @param pos The Vector3f to start the chunk at.
	 * @see ShaderProgram
	 */
	public Chunk(ShaderProgram shader, int type, Vector3f pos){
		this.pos = pos;
		this.shader = shader;
		this.type = type;
		
		initGL();
		init();
	}

	/**
	 * @param x The block X from the chunk array to check.
	 * @param y The block Y from the chunk array to check.
	 * @param z The block Z from the chunk array to check.
	 * @return Does the block have any friends on it's sides that are air?
	 */
	private boolean checkBlockInView(int x, int y, int z){
		boolean facesHidden[] = new boolean[6];
		
		if(x > pos.getX()){
			if(blocks[x - 1][y][z] != Block.AIR_BLOCK.getID()) facesHidden[0] = true;
			else facesHidden[0] = false;
		}else{
			facesHidden[0] = false;
		}
		if(x < sizeX - 1){
			if(blocks[x + 1][y][z] != Block.AIR_BLOCK.getID()) facesHidden[1] = true;
			else facesHidden[1] = false;
		}else{
			facesHidden[1] = false;
		}
		
		if(y > pos.getY()){
			if(blocks[x][y - 1][z] != Block.AIR_BLOCK.getID()) facesHidden[2] = true;
			else facesHidden[2] = false;
		}else{
			facesHidden[2] = false;
		}
		if(y < sizeY - 1){
			if(blocks[x][y + 1][z] != Block.AIR_BLOCK.getID()) facesHidden[3] = true;
			else facesHidden[3] = false;
		}else{
			facesHidden[3] = false;
		}

		if(z > pos.getZ()){
			if(blocks[x][y][z - 1] != Block.AIR_BLOCK.getID()) facesHidden[4] = true;
			else facesHidden[4] = false;
		}else{
			facesHidden[2] = false;
		}
		if(z < sizeZ - 1){
			if(blocks[x][y][z + 1] != Block.AIR_BLOCK.getID()) facesHidden[5] = true;
			else facesHidden[5] = false;
		}else{
			facesHidden[5] = false;
		}
		
		return facesHidden[0] && facesHidden[1] && facesHidden[2] && facesHidden[3] && facesHidden[4] && facesHidden[5];
	}
	
	private void createChunk(){
		if(type == Constants.AIRCHUNK){
			for(int x = (int) pos.getX(); x < sizeX; x++){
				for(int y = (int) pos.getY(); y < sizeY; y++){
					for(int z = (int)pos.getZ(); z < sizeZ; z++){
						blocks[x][y][z] = Block.AIR_BLOCK.getID();
					}
				}
			}
		}
		
		if(type == Constants.MIXEDCHUNK){
			for(int x = (int) pos.getX(); x < sizeX; x++){
				for(int y = (int) pos.getY(); y < sizeY; y++){
					for(int z = (int)pos.getZ(); z < sizeZ; z++){
						blocks[x][y][z] = Block.AIR_BLOCK.getID();
						
						if(randomHelper.nextInt(10) > 7){
							blocks[x][y][z] = Block.GRASS_BLOCK.getID();
						}
					}
				}
			}
		}
	}
	
	@Override
	public void addEntities() {
	}

	@Override
	public void initGL() {
		randomHelper = new Random();
		
		sizeX = (int) (pos.getX() + CHUNKSIZE);
		sizeY = (int) (pos.getY() + CHUNKSIZE);
		sizeZ = (int) (pos.getZ() + CHUNKSIZE);
		
		vcID = glGenLists(1);
		
		blocks = new byte[sizeX][sizeY][sizeZ];
		
		createChunk();
		rebuild();
	}

	@Override
	public void init() {
	}

	@Override
	public void create() {
	}

	// TODO: Re-build mesh.
	@Override
	public void rebuild() {
		if(type != Constants.AIRCHUNK){
			glNewList(vcID, GL_COMPILE);
			glBegin(GL_QUADS);
			
			for(int x = (int) pos.getX(); x < sizeX; x++){
				for(int y = (int) pos.getY(); y < sizeY; y++){
					for(int z = (int)pos.getZ(); z < sizeZ; z++){
						if(blocks[x][y][z] != Block.AIR_BLOCK.getID() && !checkBlockInView(x, y, z)){
							VoxelGeometry.createVoxel(x, y, z, blocks[x][y][z], 1);
						}
					}
				}
			}
			
			glEnd();
			glEndList();
		}
	}

	@Override
	public void render() {
		if(type != Constants.AIRCHUNK){
			glCallList(vcID);
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void dispose() {
		shader.dispose();
		
		glDeleteLists(vcID, 1);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean needsRebuilt() {
		return needsRebuilt;
	}

	public void setNeedsRebuilt(boolean needsRebuilt) {
		this.needsRebuilt = needsRebuilt;
	}
}
