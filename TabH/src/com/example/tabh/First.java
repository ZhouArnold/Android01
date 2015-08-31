package com.example.tabh;

import java.util.Timer;

import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

public class First extends Activity {  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.first_xml);
    final Handler handler=new Handler(){
    	public void handleMessage(Message msg){
    		if(msg.what==0x1233){
    			Intent intent=new Intent(First.this,MainActivity.class);
    			startActivity(intent);
    			First.this.finish();
    		}
    		
    	}
    	
    };
    new Timer().schedule(new TimerTask(){
    	public void run(){
    		handler.sendEmptyMessage(0x1233);
    	}
    },3000);
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

}