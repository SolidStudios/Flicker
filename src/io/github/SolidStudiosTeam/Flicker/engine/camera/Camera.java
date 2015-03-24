package io.github.SolidStudiosTeam.Flicker.engine.camera;

import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import io.github.SolidStudiosTeam.Flicker.engine.Constants;
import io.github.SolidStudiosTeam.Flicker.engine.entity.Entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Camera extends Entity{
    private float speed, maxU, maxD;

    /*
     * Rotation x - pitch y - yaw z - roll
     */
    public Camera(float x, float y, float z, float speed, float maxU, float maxD, int id) {
        super(x, y, z, 0, 0, 0, id);
        
        this.speed = speed;
        this.maxU = maxU;
        this.maxD = maxD;
    }

    public Camera(float x, float y, float z, float rx, float ry, float rz, float speed, float maxU, float maxD, int id) {
    	super(x, y, z, rx, ry, rz, id);
        
    	this.speed = speed;
        this.maxU = maxU;
        this.maxD = maxD;
    }

    public void updateMouse() {
        float dx = Mouse.getDX() * speed * 0.16f;
        float dy = Mouse.getDY() * speed * 0.16f;

        if (getYaw() + dx >= 360) {
            setYaw(getYaw() + dx - 360);
        } else if (getYaw() + dx < 0) {
            setYaw(360 - getYaw() + dx);
        } else {
            setYaw(getYaw() + dx);
        }
        
        if (getPitch() - dy >= maxD && getPitch() - dy <= maxU) {
            setPitch(getPitch() + -dy);
        } else if (getPitch() - dy < maxD) {
            setPitch(maxD);
        } else if (getPitch() - dy > maxU) {
            setPitch(maxU);
        }
    }

    public void updateKeyboard(float delay, float speed) {
    	boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_W);
        boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_S);
        boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_A);
        boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_D);
        boolean space = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
        boolean shift = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);

        if (keyUp && keyRight && !keyLeft && !keyDown) {
        	move(speed * delay * 0.003f, 0, -speed * delay * 0.003f);
        }
        if (keyUp && keyLeft && !keyRight && !keyDown) {
            move(-speed * delay * 0.003f, 0, -speed * delay * 0.003f);
        }
        if (keyUp && !keyLeft && !keyRight && !keyDown) {
            move(0, 0, -speed * delay * 0.003f);
        }
        if (keyDown && keyLeft && !keyRight && !keyUp) {
            move(-speed * delay * 0.003f, 0, speed * delay * 0.003f);
        }
        if (keyDown && keyRight && !keyLeft && !keyUp) {
            move(speed * delay * 0.003f, 0, speed * delay * 0.003f);
        }
        if (keyDown && !keyUp && !keyLeft && !keyRight) {
            move(0, 0, speed * delay * 0.003f);
        }
        if (keyLeft && !keyRight && !keyUp && !keyDown) {
            move(-speed * delay * 0.003f, 0, 0);
        }
        if (keyRight && !keyLeft && !keyUp && !keyDown) {
            move(speed * delay * 0.003f, 0, 0);
        }
        if (space && !shift) {
            setY(getY() + speed * delay * 0.003f);
        }
        if (shift && !space) {
            setY(getY() - speed * delay * 0.003f);
        }
    }

    public void move(float x, float y, float z) {
        setZ((float) (getZ() + (x * (float) Math.cos(Math.toRadians(getYaw() - 90)) + z * Math.cos(Math.toRadians(getYaw())))));
        setX((float) (getX() - (x * (float) Math.sin(Math.toRadians(getYaw() - 90)) + z * Math.sin(Math.toRadians(getYaw())))));
        setY((float) (getY() + (y * (float) Math.sin(Math.toRadians(getPitch() - 90)) + z * Math.sin(Math.toRadians(getPitch())))));
    }
   
    public void applyTranslations() {
    	glLoadIdentity();
        glRotatef(getPitch(), 1.0f, 0.0f, 0.0f);
        glRotatef(getYaw(), 0.0f, 1.0f, 0.0f);
        glTranslatef(-getX(), -getY(), -getZ());
    }
    
    //moves the camera forward relitive to its current rotation (yaw)
    public void walkForward(float distance)
    {
    	setX(getX() - (distance * (float)Math.sin(Math.toRadians(getYaw()))) * 2);
        setZ(getZ() + (distance * (float)Math.cos(Math.toRadians(getYaw()))) * 2);
    }
 
    //moves the camera backward relitive to its current rotation (yaw)
    public void walkBackwards(float distance)
    {       
    	setX(getX() + (distance * (float)Math.sin(Math.toRadians(getYaw()))) * 2);
        setZ(getZ() - (distance * (float)Math.cos(Math.toRadians(getYaw()))) * 2);
    }
 
    //strafes the camera left relitive to its current rotation (yaw)
    public void strafeLeft(float distance)
    {
    	setX(getX() - (distance * (float)Math.sin(Math.toRadians(getYaw()-90))) * 2);
        setZ(getZ() + (distance * (float)Math.cos(Math.toRadians(getYaw()-90))) * 2);
    }
 
    //strafes the camera right relitive to its current rotation (yaw)
    public void strafeRight(float distance)
    {
            setX(getX() - (distance * (float)Math.sin(Math.toRadians(getYaw()+90))) * 2);
            setZ(getZ() + (distance * (float)Math.cos(Math.toRadians(getYaw()+90))) * 2);
    }
 
    public void floatUp(float distance)
    {
    	setY(getY() - distance * 2);
    }
    
    public void floatDown(float distance){
    	setY(getY() + distance * 2);
    }
}