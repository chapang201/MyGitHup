package com.development.friendzone;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;

public class OptionActivity extends Activity {
	
	final Context context=this;
	private Button editPriorityButton;
	private Button editAutoResponderButton;
	
	private Spinner spinnerDistance;
	private String distance[];
	private Spinner spinnerInterval;
	private String interval[];
	private Spinner spinnerNotification;
	private String notification[];
	
	
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_option);
	        
	        spinnerDistance=(Spinner)findViewById(R.id.editText1);
	        distance=new String[]{"6 ft","12 ft"};
	        ArrayAdapter<String> adapterDistance=new ArrayAdapter<String>(OptionActivity.this,android.R.layout.simple_spinner_item,distance);
	        adapterDistance.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	        spinnerDistance.setAdapter(adapterDistance);
	       
	        spinnerDistance.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> arg0, View view,
						int pos, long arg3) {
					// TODO Auto-generated method stub
					final int loc;
					loc=pos;
					switch(loc)
					{
						case 0:
							Log.i("tag", "case 0");
							//6 ft
							break;
						case 1:
							//12 ft
							Log.i("tag","case 1");
							break;
						default:
							Log.i("tag","case default");
							break;
					}
				}
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					Log.i("tag","case nothingSel");
				}	        
	        });
	        spinnerInterval=(Spinner)findViewById(R.id.editText2);
	        interval=new String[]{"60","30","120","300","600"};
	        ArrayAdapter <String> adapterInterval=new ArrayAdapter<String>(OptionActivity.this,android.R.layout.simple_spinner_item,interval);
	        adapterInterval.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
			spinnerInterval.setAdapter(adapterInterval);
			spinnerInterval.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> arg0, View view,
							int pos, long arg3) {
						// TODO Auto-generated method stub
						 int loc;
						loc=pos;
						switch(loc)
						{
							case 0:
								Log.i("tag", "case 0");
								//60 s
								break;
							case 1:
								//30 s
								Log.i("tag","case 1");
								break;
							case 2:
								//120 s
								Log.i("tag","case 2");
								break;
							case 3:
								//300 s
								Log.i("tag","case 3");
								break;
							case 4:
								//600 s
								Log.i("tag","case 4");
								break;	
							
							default:
								Log.i("tag","case default");
								break;
						}
					}
					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						Log.i("tag","case nothingSel");
					}	        
		        });
			
			spinnerNotification=(Spinner)findViewById(R.id.editText3);
	        notification=new String[]{"10","5","20","30","60"};
	        ArrayAdapter <String> adapterNotification=new ArrayAdapter<String>(OptionActivity.this,android.R.layout.simple_spinner_item,notification);
	        adapterNotification.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	        spinnerNotification.setAdapter(adapterNotification);
	        spinnerNotification.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> arg0, View view,
							int pos, long arg3) {
						// TODO Auto-generated method stub
						final int loc;
						loc=pos;
						switch(loc)
						{
							case 0:
								Log.i("tag", "case 0");
								//10 min
								break;
							case 1:
								//5 min
								Log.i("tag","case 1");
								break;
							case 2:
								//20 min
								Log.i("tag","case 2");
								break;
							case 3:
								//30 min
								Log.i("tag","case 3");
								break;
							case 4:
								//60 min
								Log.i("tag","case 4");
								break;	
							
							default:
								Log.i("tag","case default");
								break;
						}
					}
					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						Log.i("tag","case nothingSel");
					}	        
		        });
	       // getActionBar().setTitle("Options");
	      //  Spinner spinner=(Spinner) findViewById(R.id.editText1);
	     //   ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.distance_array, android.R.layout.simple_spinner_dropdown_item);
	        editPriorityButton=(Button)findViewById(R.id.button1 );
	        editPriorityButton.setOnClickListener(new OnClickListener() {
	        	  
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					final Dialog dialog=new Dialog(context);
					dialog.setContentView(R.layout.activity_priorityfriendlist);
					dialog.setTitle("Edit Priority Friend List");
					/*TextView text = (TextView) dialog.findViewById(R.id.text);
					text.setText("Android custom dialog example!");
					ImageView image = (ImageView) dialog.findViewById(R.id.image);
					image.setImageResource(R.drawable.ic_launcher);*/
					
					Button doneButton=(Button)dialog.findViewById(R.id.button_priority_done);
					doneButton.setOnClickListener(new OnClickListener() {
						  
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
					dialog.show();
					
				}
			});
	        
	        editAutoResponderButton=(Button)findViewById(R.id.button2);
	        editAutoResponderButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					final Dialog dialog=new Dialog(context);
					dialog.setContentView(R.layout.dialog_auto_responder);
					dialog.setTitle("Edit Auto-Responder");
					dialog.show();
					
					Button doneButton=(Button)dialog.findViewById(R.id. button_auto_responder_done);
					doneButton.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
				}
			});
	       
	    }
	   
	   private void showSettingDialog() {
			// TODO Auto-generated method stub
			final Dialog dialog=new Dialog(context);
   		dialog.setContentView(R.layout.dialog_manage_dialog_setting);
   		dialog.setTitle("Setting Dialog");
   		dialog.show();
   		
   		Button buttonDone=(Button)dialog.findViewById(R.id.buttonDone);
   		buttonDone.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					dialog.dismiss();
				}
			});
		}
	  public void onClickApplication(View view)
	  {
		  ToggleButton appToggleButton=(ToggleButton)findViewById(R.id.toggleButtonApplication);
		  if(appToggleButton.isChecked())
			  Toast.makeText(getApplicationContext(), "Application is on.", Toast.LENGTH_SHORT).show();
		  else  Toast.makeText(getApplicationContext(), "Application is off.", Toast.LENGTH_SHORT).show();
	  }
	  
	  public void onClickRepeatCallOverrie(View view)
	  {
		  ToggleButton appToggleButton=(ToggleButton)findViewById(R.id.tootleButton2);
		  if(appToggleButton.isChecked())
			  Toast.makeText(getApplicationContext(), "Repeat call override is on.", Toast.LENGTH_SHORT).show();
		  else  Toast.makeText(getApplicationContext(), "Repeat call override is off.", Toast.LENGTH_SHORT).show();
	  }
	  public void onClickAutoResponder(View view)
	  {
		  ToggleButton appToggleButton=(ToggleButton)findViewById(R.id.tootleButton3);
		  if(appToggleButton.isChecked())
			  Toast.makeText(getApplicationContext(), "Auto responder is on.", Toast.LENGTH_SHORT).show();
		  else  Toast.makeText(getApplicationContext(), "Auto responder is off.", Toast.LENGTH_SHORT).show();
	  }
	  public void onClickTravelEnabler(View view)
	  {
		  ToggleButton appToggleButton=(ToggleButton)findViewById(R.id.editText6);
		  if(appToggleButton.isChecked())
			  Toast.makeText(getApplicationContext(), "Travel enabler is on.", Toast.LENGTH_SHORT).show();
		  else  Toast.makeText(getApplicationContext(), "Travel enable is off.", Toast.LENGTH_SHORT).show();
	  }
	  public void onClickShareLocation(View view)
	  {
		  ToggleButton appToggleButton=(ToggleButton)findViewById(R.id.tootleButton4);
		  if(appToggleButton.isChecked())
			  Toast.makeText(getApplicationContext(), "Share location is on.", Toast.LENGTH_SHORT).show();
		  else  Toast.makeText(getApplicationContext(), "Share location is off.", Toast.LENGTH_SHORT).show();
	  }
	  public void onClickShareFriends(View view)
	  {
		  ToggleButton appToggleButton=(ToggleButton)findViewById(R.id.tootleButton5);
		  if(appToggleButton.isChecked())
			  Toast.makeText(getApplicationContext(), "Share friends is on.", Toast.LENGTH_SHORT).show();
		  else  Toast.makeText(getApplicationContext(), "Share friends is off.", Toast.LENGTH_SHORT).show();
	  }
}
