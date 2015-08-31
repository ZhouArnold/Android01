package com.example.tabh;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Baocai extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baocai);
		TextView tv = (TextView)findViewById(R.id.textb);   
        TextPaint tp = tv.getPaint();   
        tp.setFakeBoldText(true); 
        TextView jiesuan=(TextView)findViewById(R.id.jiesuan);
        TextView jiarugouwuche=(TextView)findViewById(R.id.jiarugouwuche);
        jiarugouwuche.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
			}
		});
    
        jiesuan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	               AlertDialog.Builder dialog=new AlertDialog.Builder(Baocai.this);  
	               LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            	   View view=inflater.inflate(R.layout.toastlogin, null);
            	   
                   dialog.setView(view).setTitle("登陆").setPositiveButton("确定", new DialogInterface.OnClickListener() {  
                	  
                    @Override  
                    public void onClick(DialogInterface dialog, int which) {  
                        //转跳到另外一个Activity  
                        // TODO Auto-generated method stub  
                     
                    }  
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {  
                      
                      
                    public void onClick(DialogInterface dialog, int which) {  
                        // TODO Auto-generated method stub  
                        dialog.cancel();//取消弹出框  
                    }  
                }).create().show();
			}
			});
        }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
