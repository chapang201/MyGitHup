package com.development.friendzone;

import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.Set;
import java.util.Vector;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int REQUEST_ENABLE_BT = 1;

	private BluetoothAdapter myBluetoothAdapter;
	
//	private Set<BluetoothDevice> pairedDevices;

	private ListView myListView;

	private ArrayAdapter<String> myArrayAdapter;
	
	
	public void on()
	{
		///////////////////////Bluetooth device Enabling//////////////////////////////////////////////////////////
		if (!myBluetoothAdapter.isEnabled()) {        	
		       Intent turnOnIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);      	
		       startActivityForResult(turnOnIntent, REQUEST_ENABLE_BT);    	
		       Toast.makeText(getApplicationContext(),"Bluetooth turned on" ,
		               Toast.LENGTH_LONG).show();
		    }     	
		    else{  	
		       Toast.makeText(getApplicationContext(),"Bluetooth is already on",   	
		              Toast.LENGTH_LONG).show();   	
		    }
		
		///////////////////////////////////////End///////////////////////////////////////////////////////////////
	}
	public  void refreshFriendList()
	{
        myListView=(ListView)findViewById(R.id.listViewNearbyDevices);
        Vector<String> friendsVector=new Vector<String>();
        for(int i=0;i<Friend.friendsArray.toArray().length;i++){
        	if(!Friend.friendsArray.get(i).getFriendName().equals("Unnamed"))
        		  friendsVector.add(Friend.friendsArray.toArray()[i].toString());
        		
        }
        // create the arrayAdapter that contains the BTDevices, and set it to the ListView
        ArrayAdapter<String>  myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendsVector);
        
         myListView.setAdapter(myArrayAdapter);
	}
	
	    @Override
	    public void onStart()
	    {
	        super.onStart();
	        refreshFriendList();
	      //  Toast.makeText(getApplicationContext(),"3. onStart()", Toast.LENGTH_SHORT).show();
	    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        on();
        
      //  Friend.friendsArray.clear();
        Friend.tmpFriendsArray.clear();
        refreshFriendList();

      //  Friend.friendsArray.clear();
  
 /*       
     // Create a BroadcastReceiver for ACTION_FOUND///////////////////////////////////////////////////////////////
        final BroadcastReceiver myReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                // When discovery finds a device
                if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                    // Get the BluetoothDevice object from the Intent
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    // Add the name and address to an array adapter to show in a ListView
                    
                    myArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                   
                     Friend.deviceName=(device.getName());
                     Friend.macID=(device.getAddress());
                     Friend.friendName=("Unnamed");
                     Friend.friendsArray.add(Friend._toString());
                }
            }
        };
       
   	 Friend.deviceName=("DeviceName");
     Friend.macID=("MacID");
     Friend.friendName=("Unnamed");
     Friend.friendsArray.add(Friend._toString());
     Friend.friendsArray.add(Friend._toString());
        myListView=(ListView)findViewById(R.id.listNearbyDevices);
        // create the arrayAdapter that contains the BTDevices, and set it to the ListView
         myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
         myListView.setAdapter(myArrayAdapter);
      
        if (myBluetoothAdapter.isDiscovering()) {        	
        
        }
        else {
        	 myArrayAdapter.clear();
               myBluetoothAdapter.startDiscovery();
                registerReceiver(myReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));     	
        }   
        // Register the BroadcastReceiver
        // Don't forget to unregister during onDestroy
         IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
         registerReceiver(myReceiver, filter); 
        
    ///////////////////////////////////////end///////////////////////////////
     */

        
        ImageButton imageButtonNearbyFriend;
        imageButtonNearbyFriend = (ImageButton)findViewById(R.id.imageButtonNearbyFriend);
        imageButtonNearbyFriend.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		Intent i=new Intent(MainActivity.this,NearbyFriendActivity.class);
        		startActivity(i);
        	}
        });
          
        ImageButton imageButtonManageFriends;
        imageButtonManageFriends = (ImageButton)findViewById(R.id.imageButtonManageFriends);
        imageButtonManageFriends.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		Intent i=new Intent(MainActivity.this,ManageFriendsFriendListActivity.class);
        		startActivity(i);
        		;
        	}
        });
        
ImageButton imageButtonOption;
imageButtonOption = (ImageButton)findViewById(R.id.imageButtonOption);
imageButtonOption.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(MainActivity.this,OptionActivity.class);
		startActivity(i);
	}
});

ImageButton imageButtonHelp;
imageButtonHelp = (ImageButton)findViewById(R.id.imageButtonHelp);
imageButtonHelp.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(MainActivity.this,HelpActivity.class);
		startActivity(i);
	}
});  
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
  /*  
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
           // TODO Auto-generated method stub

       if(requestCode == REQUEST_ENABLE_BT){
          if(myBluetoothAdapter.isEnabled()) {
                 // text.setText("Status: Enabled");
          }
          else {  
             //  text.setText("Status: Disabled");
          }
       }  
    }*/
    /*
void serialize()
{
 
	 Friend.deviceName=("DeviceName");
     Friend.macID=("MacID");
     Friend.friendName=("Unnamed");
     //friendsArray.add(myFriend);
     Intent mIntent = new Intent(MainActivity.this,ManageFriendsFriendListActivity.class); 
     
             Bundle mBundle = new Bundle(); 
     
             mBundle.putSerializable("sendFriend",myFriend); 
     
             mIntent.putExtras(mBundle);
             startActivity(mIntent); 
}
    */
}
