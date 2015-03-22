/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine.world;

import java.nio.FloatBuffer;

import net.BiggerOnTheInside.Binder.engine.UniverseEntity;
import net.BiggerOnTheInside.Binder.engine.block.Block;
import net.BiggerOnTheInside.Binder.engine.geometry.Shape;

import org.lwjgl.BufferUtils;
import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL11.*;

@SuppressWarnings("unused")
public class Chunk implements UniverseEntity{
	public static int CHUNKSIZE = 16;
	
	private boolean isActive, needsRebuilt;
	private Vector3f pos;
	private byte[][][] blocks;
	private int vID, cID, sizeX, sizeY, sizeZ;
	private FloatBuffer vCoords, cCoords;
	
	public Chunk(float x, float y, float z){
		this(new Vector3f(x, y, z));
	}
	
	public Chunk(Vector3f pos){
		this.pos = pos;
		
		initGL();
		init();
	}
	
	private boolean chunkTileInView(){
		return false;
	}
	
	private void createChunk(){
		for(int x = (int) pos.getX(); x < sizeX; x++){
			for(int y = (int) pos.getY(); y < sizeY; y++){
				for(int z = (int)pos.getZ(); z < sizeZ; z++){
					blocks[x][y][z] = Block.GRASS_BLOCK.getID();
					vCoords.put(Shape.createCubeVertices(x, y, z, 1));
					//cCoords.put(Shape.createCubeColors(blocks[x][y][z]));
				}
			}
		}
	}
	
	@Override
	public void addEntities() {
	}

	@Override
	public void initGL() {
		sizeX = (int) (pos.getX() + CHUNKSIZE);
		sizeY = (int) (pos.getY() + CHUNKSIZE);
		sizeZ = (int) (pos.getZ() + CHUNKSIZE);
		
		blocks = new byte[sizeX][sizeY][sizeZ];
	
		vCoords = BufferUtils.createFloatBuffer(Chunk.CHUNKSIZE * Chunk.CHUNKSIZE * Chunk.CHUNKSIZE * (4 * 6 * 4));
		//cCoords = BufferUtils.createFloatBuffer(Chunk.CHUNKSIZE * Chunk.CHUNKSIZE * Chunk.CHUNKSIZE * (4 * 6 * 4));
		
		createChunk();
		
		vCoords.flip();
		//cCoords.flip();
		
		vID = glGenBuffers();
		glEnableClientState(GL_VERTEX_ARRAY);
		glBindBuffer(GL_ARRAY_BUFFER, vID);
		glBufferData(GL_ARRAY_BUFFER, vCoords, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDisableClientState(GL_VERTEX_ARRAY);
		
		/*cID = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, cID);
		glBufferData(GL_ARRAY_BUFFER, cCoords, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);*/
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
	}

	@Override
	public void render() {
		glEnableClientState(GL_VERTEX_ARRAY);
		//glEnableClientState(GL_COLOR_ARRAY);
		
		glBindBuffer(GL_ARRAY_BUFFER, vID);
		glVertexPointer(3, GL_FLOAT, 0, 0L);
		
		//glBindBuffer(GL_ARRAY_BUFFER, cID);
		//glColorPointer(4, GL_FLOAT, 0, 0L);
		
		glDrawArrays(GL_QUADS, 0, 4 * 6);
		
		//glDisableClientState(GL_COLOR_ARRAY);
		glDisableClientState(GL_VERTEX_ARRAY);
	}

	@Override
	public void update() {
	}

	@Override
	public void dispose() {
		glDeleteBuffers(vID);
		glDeleteBuffers(cID);
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
