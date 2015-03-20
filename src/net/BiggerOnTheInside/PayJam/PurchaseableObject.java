/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package net.BiggerOnTheInside.PayJam;

public interface PurchaseableObject {
	public void purchase();
	public int getCost();
	public boolean active();
	public String returnObject();
}
