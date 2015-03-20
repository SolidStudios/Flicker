/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine.world;

import java.awt.event.KeyEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;
 
 
//First Person Camera Controller
public class FirstPersonCamera
{
    //3d vector to store the camera's position in
    private static Vector3f    position    = null;
    //the rotation around the Y axis of the camera
    private float       yaw         = 0.0f;
    //the rotation around the X axis of the camera
    private float       pitch       = 0.0f;
    //Constructor that takes the starting x, y, z location of the camera
    public FirstPersonCamera(float x, float y, float z)
    {
        //instantiate position Vector3f to the x y z params.
        position = new Vector3f(x, y, z);
    }
    
    //increment the camera's current yaw rotation
    public void yaw(float amount)
    {
        //increment the yaw by the amount param
        yaw += amount;
    }
 
    public static Vector3f getPosition(){
    	return position;
    }
    
    //increment the camera's current yaw rotation
    public void pitch(float amount)
    {
        //increment the pitch by the amount param
        pitch += amount;
    }
    //moves the camera forward relitive to its current rotation (yaw)
    public void walkForward(float distance)
    {
            position.x -= (distance * (float)Math.sin(Math.toRadians(yaw))) * 2;
            position.z += (distance * (float)Math.cos(Math.toRadians(yaw))) * 2;
    }
 
    //moves the camera backward relitive to its current rotation (yaw)
    public void walkBackwards(float distance)
    {       
            position.x += (distance * (float)Math.sin(Math.toRadians(yaw))) * 2;
            position.z -= (distance * (float)Math.cos(Math.toRadians(yaw))) * 2;
    }
 
    //strafes the camera left relitive to its current rotation (yaw)
    public void strafeLeft(float distance)
    {
            position.x -= (distance * (float)Math.sin(Math.toRadians(yaw-90))) * 2;
            position.z += (distance * (float)Math.cos(Math.toRadians(yaw-90))) * 2;
    }
 
    //strafes the camera right relitive to its current rotation (yaw)
    public void strafeRight(float distance)
    {
            position.x -= (distance * (float)Math.sin(Math.toRadians(yaw+90))) * 2;
            position.z += (distance * (float)Math.cos(Math.toRadians(yaw+90))) * 2;
    }
 
    public void floatUp(float distance)
    {
    	position.y -= distance * 2;
    }
    
    public void floatDown(float distance){
    	position.y += distance * 2;
    }
    
    //translates and rotate the matrix so that it looks through the camera
    //this dose basic what gluLookAt() does
    public void lookThrough()
    {
        //roatate the pitch around the X axis
        GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
        //roatate the yaw around the Y axis
        GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
        //translate to the position vector's location
        GL11.glTranslatef(position.x, position.y, position.z);
    }
    
    public boolean isKeyPressed(int keyCode) {
        // apparently, someone at decided not to use standard
 
        // keycode, so we have to map them over:
 
        switch(keyCode) {
        case KeyEvent.VK_SPACE:
            keyCode = Keyboard.KEY_SPACE;
            break;
        case KeyEvent.VK_ESCAPE:
            keyCode = Keyboard.KEY_ESCAPE;
            break;
        case KeyEvent.VK_W:
            keyCode = Keyboard.KEY_W;
            break;
        case KeyEvent.VK_A:
            keyCode = Keyboard.KEY_A;
            break;
        case KeyEvent.VK_S:
            keyCode = Keyboard.KEY_S;
            break;
        case KeyEvent.VK_D:
            keyCode = Keyboard.KEY_D;
            break;
        }
 
        return org.lwjgl.input.Keyboard.isKeyDown(keyCode);
    }
}