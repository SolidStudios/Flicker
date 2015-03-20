/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.PayJam;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@SuppressWarnings({ "unused", "rawtypes" })
public class PaymentManager {
	public static int GENERAL_ERROR = -1;
	public static int PAYMENT_PROCESS_ERROR = -2;
	public static int DATABASE_CONNECT_ERROR = -3;
	public static int NULL_OBJECT_ERROR = -4;
	
	private static PaymentManager instance = new PaymentManager();
	
	private PaymentManager(){
		
	}
	
	public static PaymentManager getInstance(){
		return instance;
	}
	
	/**
	 * Scans all classes accessible from the context class loader which belong
	 * to the given package and subpackages.
	 * 
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private Iterable<Class> getClasses(String packageName) throws ClassNotFoundException, IOException
	{
	    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    String path = packageName.replace('.', '/');
	    Enumeration<URL> resources = classLoader.getResources(path);
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements())
	    {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    
	    List<Class> classes = new ArrayList<Class>();
	    for (File directory : dirs)
	    {
	        classes.addAll(findClasses(directory, packageName));
	    }

	    return classes;
	}
	
	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 * 
	 * @param directory The base directory
	 * @param packageName The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException
	{
	    List<Class> classes = new ArrayList<Class>();
	    if (!directory.exists())
	    {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files)
	    {
	        if (file.isDirectory())
	        {
	            classes.addAll(findClasses(file, packageName + "." + file.getName()));
	        }
	        else if (file.getName().endsWith(".class"))
	        {
	            classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
	        }
	    }
	    return classes;
	}
	
	public int processPurchase(PurchaseableObject object){
		if(object == null){
			return PaymentManager.NULL_OBJECT_ERROR;
		}
		
		int cost = object.getCost();
		
		
		return PaymentManager.GENERAL_ERROR;
	}
}