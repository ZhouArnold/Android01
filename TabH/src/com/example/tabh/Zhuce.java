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
    		// 创建或打开数据库（此处需要使用绝对路径）
    		db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/my.db3", null); // ①	
    		bn = (Button) findViewById(R.id.button1);
    		bn.setOnClickListener(new OnClickListener()
    		{
    			@Override
    			public void onClick(View source)
    			{
    				// 获取用户输入
    				String title = ((EditText) findViewById(
    					R.id.editText1)).getText().toString();
    				String content = ((EditText) findViewById(R.id.editText2))
    					.getText().toString();
    				String content1=((EditText)findViewById(R.id.editText3)).getText().toString();
    				if(!content.equals(content1)){
    					Toast.makeText(Zhuce.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
    				}else{
    				try
    				{
    					insertData(db, title, content);	
    				}
    				catch (SQLiteException se)
    				{
    					// 执行DDL创建数据表
    					db.execSQL("create table news_inf(_id integer"
    						+ " primary key autoincrement,"
    						+ " news_title varchar(50),"
    						+ " news_content varchar(255))");
    					// 执行insert语句插入数据
    					insertData(db, title, content);
    				}
    				Toast.makeText(Zhuce.this, "注册成功", Toast.LENGTH_SHORT).show();	
    				}
    			}});		
	}
private void insertData(SQLiteDatabase db
    		, String title, String content) 
    	{
    		// 执行插入语句
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