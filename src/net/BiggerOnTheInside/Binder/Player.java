package net.BiggerOnTheInside.Binder;

import net.BiggerOnTheInside.Binder.engine.PlayerConstants;
import net.BiggerOnTheInside.Binder.engine.world.FirstPersonCamera;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/**
 * @author Walt
 * @since  1/14/15
 * @category Human/Player Control
 */ 
public class Player{
	private FirstPersonCamera cam;
	
	public Player(String name, float maxLife, float life){		
		init(name, maxLife, life);
	}
	
	private void init(String name, float maxLife, float life) {
		this.cam = new FirstPersonCamera(0, 0, 0);
		
		cam.lookThrough();
	}

	public FirstPersonCamera getCamera(){
		return this.cam;
	}

	public void update() {
		PlayerConstants.DELTA_TIME = (int)0.01; //(time - lastTime)/1000.0f;
        //distance in mouse movement from the last getDX() call.
		PlayerConstants.DELTA_X = Mouse.getDX();
        //distance in mouse movement from the last getDY() call.
		PlayerConstants.DELTA_Y = Mouse.getDY();

        //control cam yaw from x movement from the mouse
        cam.yaw(PlayerConstants.DELTA_X * PlayerConstants.MOUSE_SENSITIVITY);
        //control cam pitch from y movement from the mouse
        cam.pitch(-PlayerConstants.DELTA_Y * PlayerConstants.MOUSE_SENSITIVITY);

        //when passing in the distrance to move
        //we times the movementSpeed with dt this is a time scale
        //so if its a slow frame u move more then a fast frame
        //so on a slow computer you move just as fast as on a fast computer
        
        //OVER HERE! What do I do to make the boolean canWalk actually work the right way?
        
        if (Keyboard.isKeyDown(Keyboard.KEY_W))//move forward
        {
            cam.walkForward(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S))//move backwards
        {
            cam.walkBackwards(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A))//strafe left
        {
            cam.strafeLeft(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D))//strafe right
        {
            cam.strafeRight(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
        	cam.floatUp(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
        	cam.floatDown(PlayerConstants.MOVEMENT_SPEED * PlayerConstants.DELTA_TIME);
        }
        //set the modelview matrix back to the identity
        GL11.glLoadIdentity();
        //look through the cam before you draw anything
        cam.lookThrough();
	}
}
