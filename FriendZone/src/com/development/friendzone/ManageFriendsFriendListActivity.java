package com.development.friendzone;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ManageFriendsFriendListActivity extends Activity {
	
//	private ArrayAdapter<String> myArrayAdapter=new ArrayAdapter<String>(this,0);
	private MainActivity myMainActivity = new MainActivity();
	
	private ListView myListView;
	private Context context=this;
	private MainActivity tmp=new MainActivity();
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_managefriendsfriendlist);
	     
	        
	        myListView=(ListView)findViewById(R.id.listView1);
	        Vector<String> friendsVector=new Vector<String>();
	        for(int i=0;i<Friend.friendsArray.toArray().length;i++){
	        	
	        		  friendsVector.add(Friend.friendsArray.toArray()[i].toString());
	        }
	        
	        
	      
	        // create the arrayAdapter that contains the BTDevices, and set it to the ListView
	        ArrayAdapter<String>  myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendsVector);
	        
	         myListView.setAdapter(myArrayAdapter);
	       
	         myListView.setOnItemClickListener(new OnItemClickListener() {
	        	@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
	        		Toast.makeText(getApplicationContext(), "Please set your friend's name.!",Toast.LENGTH_SHORT).show();
	        		
	        		final Dialog dialog=new Dialog(context);
	        		dialog.setContentView(R.layout.dialog_manage_dialog_setting);
	        		dialog.setTitle("Setting Dialog");
	        		dialog.show();
	        		final int p=position;
	        		Button buttonDone=(Button)dialog.findViewById(R.id.buttonDone);
	        		buttonDone.setOnClickListener(new OnClickListener() {
	    				
	    				@Override
	    				public void onClick(View v) {
	    					// TODO Auto-generated method stub
	    					TextView editTextName = (TextView) dialog.findViewById(R.id.editTextName);
	    					String str= editTextName.getText().toString();
	    					Friend.friendsArray.get(p).setFriendName(str);
	    					refreshList();
	    					
	    				
	    					dialog.dismiss();
	    					
	    				}
	    			});		
	        	}

		
			});
	     	
	    }
	   
	private void refreshList()
	{
		 myListView=(ListView)findViewById(R.id.listView1);
	        Vector<String> friendsVector=new Vector<String>();
	        for(int i=0;i<Friend.friendsArray.toArray().length;i++){
	        	
	        		  friendsVector.add(Friend.friendsArray.toArray()[i].toString());
	        }
	        // create the arrayAdapter that contains the BTDevices, and set it to the ListView
	        ArrayAdapter<String>  myArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendsVector);
	        
	         myListView.setAdapter(myArrayAdapter);
	}
	
}