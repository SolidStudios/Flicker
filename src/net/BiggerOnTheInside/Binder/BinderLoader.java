/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder;

import java.util.logging.Logger;

import org.lwjgl.opengl.DisplayMode;

public class BinderLoader {
	public static int WINDOW_FULLSCREEN_ARGUMENT = 1;
	public static int WINDOW_RESIZEABLE_ARGUMENT = 2;
	
	private static GameLoop gameLoop;
	private static Logger binderLogger = Logger.getLogger("Binder");
	private static String[] arg;
	private static Player player;
	
	public static void main(String[] args){
		//player = new Player(args[0]);
		
		arg = args;
		gameLoop = new GameLoop(binderLogger);
		
		start();
	}
	
	public static void setGameLoop(GameLoop loop){
		if(loop != null){
			gameLoop = loop;
		}
		
		restart();
	}
	
	public static void start(){
		gameLoop.start();
	}
	
	public static void stop(){
		gameLoop.stop();
	}
	
	public static void restart(){
		gameLoop.stop();
		gameLoop.start();
	}
	
	public static DisplayMode getDisplayMode(){
		return gameLoop.getDisplayMode();
	}
	
	public static String[] getArgs(){
		return arg;
	}
	
	public static Logger getLogger(){
		return binderLogger;
	}
	
	public static Player getPlayer(){
		return player;
	}
}
