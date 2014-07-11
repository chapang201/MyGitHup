package com.development.friendzone;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class NearbyFriendActivity  extends Activity {
	
	private ArrayAdapter<String> myArrayAdapter;
	//private MainActivity mainActivity;
	private ListView myListView;
	private Context _context=this;
	private BluetoothAdapter myBluetoothAdapter;
	
	private void addDeviceToList()
	{
        myListView=(ListView)findViewById(R.id.listView1);
        // create the arrayAdapter that contains the BTDevices, and set it to the ListView
         myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
         myListView.setAdapter(myArrayAdapter);
	}
	private void findNearbyFriends()
	{	
		Toast.makeText(getApplicationContext(), "Please wait for a moment...",Toast.LENGTH_SHORT).show();
		   myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	        // Create a BroadcastReceiver for ACTION_FOUND///////////////////////////////////////////////////////////////

	        final BroadcastReceiver myReceiver = new BroadcastReceiver() {
	            public void onReceive(Context context, Intent intent) {
	                String action = intent.getAction();
	                // When discovery finds a device
	                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
	                    // Get the BluetoothDevice object from the Intent
	                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	                    // Add the name and address to an array adapter to show in a ListView
	                    int ok=0;
	                    if(myArrayAdapter.getCount()==0)
	                    ok=1;
	                    for(int i=0;i<myArrayAdapter.getCount();i++){
		                    if(myArrayAdapter.getItem(i).equals(" New Device: "+device.getName() + "\n" + device.getAddress()))break;
		                    if(i==myArrayAdapter.getCount()-1)
		                    	ok=1;
		                    }
	                   
	                    if(Friend.friendsArray.toArray().length==0 && ok==1)
	                    	myArrayAdapter.add(" New Device: "+device.getName() + "\n" + device.getAddress());
	                   
	                  
	                    else
	                    for(int i=0;i<Friend.friendsArray.toArray().length;i++){
		                    if(Friend.friendsArray.get(i).getMacID().equals(device.getAddress()))break;
		                    if(i==Friend.friendsArray.toArray().length-1 && ok==1)
		                    	 myArrayAdapter.add(" New Device: "+device.getName() + "\n" + device.getAddress());
		                    }
	                    
	                    
	  
	                    Friend friend=new Friend();
	                 
	                    if(Friend.friendsArray.toArray().length==0){
		                    friend.setDeviceName(device.getName());
		                    friend.setMacID(device.getAddress());
		                    friend.setFriendName("Unnamed");
		                   // Friend.friendsArray.add(friend);
		                    Friend.tmpFriendsArray.add(friend);
	                    }
	                    for(int i=0; i<Friend.friendsArray.toArray().length;i++)
	                    {
	                    	
	                    	friend=Friend.friendsArray.get(i);
	                    	if(device.getAddress().equals(friend.getMacID()))
	                    		break;
	                    	if(i==Friend.friendsArray.toArray().length-1)
	                    	{
			                    friend.setDeviceName(device.getName());
			                    friend.setMacID(device.getAddress());
			                    friend.setFriendName("Unnamed");
			                 //   Friend.friendsArray.add(friend);
			                    Friend.tmpFriendsArray.add(friend);
		                    }
	                     }
	                    
	                }
	            }
	        };
	        
	        addDeviceToList();
	      
	        if (myBluetoothAdapter.isDiscovering()) {        	
	        	Toast.makeText(getApplicationContext(), "Discovering nearby devices now...", Toast.LENGTH_LONG).show();
	        	
	        }
	        else {
	        	 myArrayAdapter.clear();
	        	 myBluetoothAdapter.startDiscovery();
	                registerReceiver(myReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));     	
	        }   
	        // Register the BroadcastReceiver
	        // Don't forget to unregister during onDestroy
	      /*   IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
	         registerReceiver(myReceiver, filter); */
	}
	
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_nearbyfriend);
	        
	        findNearbyFriends();
	        
            myListView.setOnItemClickListener(new OnItemClickListener() {
	        	@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
	        		Toast.makeText(getApplicationContext(), "Please set your friend's name.!",Toast.LENGTH_SHORT).show();
	        		
	        		final Dialog dialog=new Dialog(_context);
	        		dialog.setContentView(R.layout.dialog_add_friend);
	        		dialog.setTitle("Add Friend Dialog");
	        		dialog.show();
	        		final int p=position;
	        		Button buttonAdd=(Button)dialog.findViewById(R.id.buttonAdd);
	        		buttonAdd.setOnClickListener(new OnClickListener() {
	    				
	    				@Override
	    				public void onClick(View v) {
	    					// TODO Auto-generated method stub
	    					TextView editTextName = (TextView) dialog.findViewById(R.id.editTextName_);
	    					String str= editTextName.getText().toString();
	    					Friend.tmpFriendsArray.get(p).setFriendName(str);
	    					Friend.friendsArray.add(Friend.tmpFriendsArray.get(p));
	    					
	    				   
	    					/*for(int i=0;i<Friend.friendsArray.toArray().length;i++)
	    					{
	    						if(Friend.tmpFriendsArray.get(p).getMacID().equals(Friend.friendsArray.get(i).getMacID()))
	    							break;
	    						if(i==Friend.friendsArray.toArray().length-1)	
	    						;
	    							
	    					}*/
	    				
	    					if(myArrayAdapter!=null)
	    					  for(int i=0;i<myArrayAdapter.getCount();i++){
	    		                 /*   if(myArrayAdapter.getItem(i).equals(" New Device: "+Friend.friendsArray.get(i).getDeviceName() +
	    		                    		"\n" + Friend.friendsArray.get(i).getMacID()))
	    		                    myArrayAdapter.remove(" New Device: "+Friend.friendsArray.get(i).getDeviceName() +
	    		                    		"\n" + Friend.friendsArray.get(i).getMacID());*/
	    		                    
	    		                    }
	    					addDeviceToList();
	    				
	    					dialog.dismiss();
	    					
	    				}
	    			});		
	        	}

		
			});
	        //getActionBar().setTitle("Nearby Friends"); 
	        
	    
	        
	    Button buttonRefresh=(Button)findViewById(R.id.buttonRefresh);
	    buttonRefresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				findNearbyFriends();
				
			}
		});
	    }
	   

  
}