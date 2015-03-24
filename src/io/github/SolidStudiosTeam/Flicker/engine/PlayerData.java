/***************************************************************************************************************/
/** Copyright 2015 BiggerOnTheInside (development), all rights reserved.                                       */
/** Released under the Binder License (https://github.com/BiggerOnTheInside/Licenses/blob/master/Binder.txt)   */
/***************************************************************************************************************/

package io.github.SolidStudiosTeam.Flicker.engine;


public class PlayerData {
	/*private ArrayList<String> permissions;
	private static HashMap<String, PlayerData> metaTable;
	
	private PlayerData(){
		this.permissions = new ArrayList<String>();
	}
	
	private PlayerData(ArrayList<String> permissions){
		this.permissions = permissions;
	}
	
	public static PlayerData getData(String uuid){
		if(!metaTable.containsKey(uuid)){
			return PlayerData.metaTable.put(uuid, new PlayerData());
		}
		
		return metaTable.get(uuid);
	}
	
	public static PlayerData getData(Player p) throws PlayerNoUUIDException{
		return getData(p.getUuid().toString());
	}
	
	public boolean playerHasPermission(String perm){
		return permissions.contains(perm);
	}
	
	public boolean takePermission(String perm){
		if(permissions.contains(perm)){
			return permissions.remove(perm);
		}
		
		return false;
	}
	
	public void grantPermission(String perm){
		permissions.add(perm);
	}*/
}
