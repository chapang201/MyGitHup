/**
 * 
 */
package com.development.friendzone;

/**
 * @author MyWorld
 *
 */

import java.io.Serializable; 
import java.util.Vector;

 public  class Friend implements Serializable { 
    private static final long serialVersionUID = -7060210544600464481L;  
	private  String friendName;
	private  String deviceName;
	private  String macID; 
	
	public static Vector<Friend> friendsArray= new Vector<Friend>();  
	public static Vector<Friend> tmpFriendsArray= new Vector<Friend>();
	
	public String getFriendName(){
		return friendName;
	}
	public String getDeviceName(){
		return deviceName;
	}
	public String getMacID(){
		return macID;
	}
	public void setFriendName(String name){
		friendName=name;
	}
	public void setDeviceName(String name){
		deviceName=name;
	}
	public void setMacID(String name){
		macID=name;
	}
		
	public Vector<Friend> getFriendsArray()
	{
		return friendsArray;
	}
	public Vector<Friend> getTmpFriendsArray()
	{
		return tmpFriendsArray;
	}

	/*public Friend(String deviceName, String macID, String friendName) {
		//super();
		
		this.deviceName=deviceName;
		this.macID=macID;
		this.friendName=friendName;
	}*/
		@Override
	    public  String toString() {
			if(friendName.equals(""))friendName="Unnamed";
	        return friendName + ": " + " Device name: "+ deviceName + ", MAC: "+macID;
	    }
}


