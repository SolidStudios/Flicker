/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker;

import java.io.InputStream;
import java.net.URL;

public class ResourceLoader {
	/**
	 * @param s Location of file, relative to /resource
	 * @return new URL from the location
	 */
	public static URL getResourceURL(String s){
		return ResourceLoader.class.getClass().getResource("resources" + s);
	}
	
	/**
	 *
	 */
	public static String getResourceString(String s){
		return ResourceLoader.class.getClass().getResource("resources" + s).toString();
	}
	
	public static InputStream getResourceAsStream(String s){
		return ResourceLoader.class.getClass().getResourceAsStream("resources" + s);
	}
}
