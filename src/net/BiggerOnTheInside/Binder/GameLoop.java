/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.util.ArrayList;
import java.util.logging.Logger;

import net.BiggerOnTheInside.Binder.engine.UniverseEntity;
import net.BiggerOnTheInside.Binder.engine.world.World;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GameLoop implements UniverseEntity{
	private ArrayList<UniverseEntity> entities = new ArrayList<UniverseEntity>();
	private boolean running;
	private DisplayMode displayMode;
	private Logger logger;
	private World world;
	
	public GameLoop(Logger log){
		this.logger = log;
	}
	
	@Override
	public void addEntities(){
	}
	
	@Override
	public void initGL() {
		/* Enable 2D textures. */
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		/* Make all models smoothly textured. */
        GL11.glShadeModel(GL11.GL_SMOOTH);
        
        /* Set the background color to that signature blue. */
        GL11.glClearColor(0.9f, 1.0f, 1.0f, 0.0f); 
        
        /* Set the clear depth to all-the-way */
        GL11.glClearDepth(1.0); 
        
        /* Enable the depth system. */
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        
        /* Set the function for depth to GL_LEQUAL. */
        GL11.glDepthFunc(GL11.GL_LEQUAL); 

      //  GL11.glEnable(GL11.GL_BLEND);
        //GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        /* Enable face culling, basically don't render this face relative to the camera's position. */
       // GL11.glEnable(GL11.GL_CULL_FACE);
        
        /* Set OpenGL to cull the back face of our spatials. */
       // GL11.glCullFace(GL11.GL_BACK);
        
        /* Set the matrix mode to projection. */
        GL11.glMatrixMode(GL11.GL_PROJECTION); 
        
        /* Reset the OpenGL configuration, loading our above prefrences. */
        GL11.glLoadIdentity();

        /* Set the perspective. */
        GLU.gluPerspective(45.0f, (float)displayMode.getWidth()/(float)displayMode.getHeight(),0.1f,100.0f);

        /* Set the matrix mode to be model view. */
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
        /* Set the perspective correction hint to finest quality. */
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}

	@Override
	public void init() {
		world = new World();
	}
	
	public void start(){
		logger.info("Starting Binder...");
		
		running = true;
		
		try {
			addEntities();
			logger.info("Creating window...");
			createWindow();
			logger.info("Setting up graphics...");
			initGL();
			logger.info("Setting up game...");
			init();
			logger.info("Starting game...");
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		Mouse.setGrabbed(true);
		
		while(this.running && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			update();
			render();
			
			Display.update();
			//Display.sync(30);
		}
		
		dispose();
	}
	
	@Override
	public void create() {
	}

	@Override
	public void rebuild() {
	}

	@Override
	public void render() {
		world.render();
	}

	@Override
	public void update() {
		world.update();
	}


	@Override
	public void dispose() {
		logger.info("Shutting down game...");
		
		world.dispose();
		
		logger.info("Goodbye!");
		Display.destroy();
	}
	
	public void createWindow() throws LWJGLException{
		Display.setFullscreen(true);
		Display.setResizable(Boolean.parseBoolean(BinderLoader.getArgs()[BinderLoader.WINDOW_RESIZEABLE_ARGUMENT]));
	    DisplayMode d[] = Display.getAvailableDisplayModes();
	    
	    for (int i = 0; i < d.length; i++) {
	        if (d[i].getWidth() == 640
	            && d[i].getHeight() == 480
	            && d[i].getBitsPerPixel() == 32) {
	            displayMode = d[i];
	            break;
	        }
	    }
	    Display.setDisplayMode(displayMode);
	    Display.setTitle("LWJGL Voxel engine [Binder]");
	    Display.create();
	}
	
	public DisplayMode getDisplayMode(){
		return displayMode;
	}
}
