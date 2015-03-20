/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.Binder.engine;

public class PlayerNotRegisteredException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public PlayerNotRegisteredException(){
		super("It seems that a player object was accessed, but wasn't registered correctly.");
	}
	
	public PlayerNotRegisteredException(String msg){
		super(msg);
	}
}
