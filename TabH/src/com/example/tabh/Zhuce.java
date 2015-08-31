package com.example.tabh;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Zhuce extends Activity {  
	protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.myself);
   
    	final SQLiteDatabase db;
    	Button bn = null;
    		// ����������ݿ⣨�˴���Ҫʹ�þ���·����
    		db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/my.db3", null); // ��	
    		bn = (Button) findViewById(R.id.button1);
    		bn.setOnClickListener(new OnClickListener()
    		{
    			@Override
    			public void onClick(View source)
    			{
    				// ��ȡ�û�����
    				String title = ((EditText) findViewById(
    					R.id.editText1)).getText().toString();
    				String content = ((EditText) findViewById(R.id.editText2))
    					.getText().toString();
    				String content1=((EditText)findViewById(R.id.editText3)).getText().toString();
    				if(!content.equals(content1)){
    					Toast.makeText(Zhuce.this, "�����������벻һ��", Toast.LENGTH_SHORT).show();
    				}else{
    				try
    				{
    					insertData(db, title, content);	
    				}
    				catch (SQLiteException se)
    				{
    					// ִ��DDL�������ݱ�
    					db.execSQL("create table news_inf(_id integer"
    						+ " primary key autoincrement,"
    						+ " news_title varchar(50),"
    						+ " news_content varchar(255))");
    					// ִ��insert����������
    					insertData(db, title, content);
    				}
    				Toast.makeText(Zhuce.this, "ע��ɹ�", Toast.LENGTH_SHORT).show();	
    				}
    			}});		
	}
private void insertData(SQLiteDatabase db
    		, String title, String content) 
    	{
    		// ִ�в������
    		db.execSQL("insert into news_inf values(null , ? , ?)"
    			, new String[] {title, content });
    	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

}