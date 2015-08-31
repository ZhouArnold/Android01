package com.example.tabh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {
	private String[] names=new String[]{"新鲜蔬菜","精品水果","豆蛋乳品","粮油副食","调料美味","营养肉食","水产海鲜","休闲零食","酒水饮料",};
	private String[] descs = new String[]{"好吃的蔬菜","好吃的水果","好吃的乳品","好吃的副食","好吃的美味","好吃的肉食","好吃的海鲜","好吃的零食","好喝的饮料",};
	private int[] imageIds=new int[]{R.drawable.shucai,R.drawable.shuiguo,R.drawable.rupin,R.drawable.fushi,R.drawable.tiaoliao,R.drawable.roulei,R.drawable.haixian,R.drawable.lingshi,R.drawable.yinliao,};
	int[] imagelunbo=new int[]{R.drawable.lunbo1,R.drawable.lunbo2,R.drawable.lunbo3,R.drawable.lunbo4,};
	int lunbo=0;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar1);
        final  ImageView J=(ImageView)findViewById(R.id.jinrituijian);
        J.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent j1=new Intent(MainActivity.this,Baocai.class);
    			startActivity(j1);
			}
		});
        final ImageView show=(ImageView)findViewById(R.id.show);
		final Handler myHandler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// 如果该消息是本程序所发送的
				if (msg.what == 0x1233)
				{
					// 动态地修改所显示的图片
					show.setImageResource(imagelunbo[lunbo++
						% imagelunbo.length]);
				}
			}
		};
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run(){
				myHandler.sendEmptyMessage(0x1233);
			}
		},0,2000);
		TextView tv = (TextView)findViewById(R.id.textb);   
        TextPaint tp = tv.getPaint();   
        tp.setFakeBoldText(true);
        //定义一个集合
        List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
        	Map<String,Object> listItem=new HashMap<String,Object>();
        	listItem.put("header",imageIds[i]);
        	listItem.put("personName",names[i]);
        	listItem.put("desc",descs[i]);
        	listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"personName","header","desc"},
        		new int[]{ R.id.name,R.id.header,R.id.desc});
        //定义一个ListView
        ListView list=(ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        //导入TabHost
        View niTab = (View) LayoutInflater.from(this).inflate(R.layout.tabmini, null);
        View woTab = (View) LayoutInflater.from(this).inflate(R.layout.sec, null); 
        View taTab = (View) LayoutInflater.from(this).inflate(R.layout.thr, null);
        View weTab = (View) LayoutInflater.from(this).inflate(R.layout.fou, null); 
        
        TabHost tabHost = (TabHost)findViewById(R.id.tabhost);  
        tabHost.setup(); 
       
        tabHost.addTab(tabHost.newTabSpec("nitab").setIndicator(niTab).setContent(R.id.tab1));  
        tabHost.addTab(tabHost.newTabSpec("wotab").setIndicator(woTab).setContent(R.id.tab2));  
        tabHost.addTab(tabHost.newTabSpec("tatab").setIndicator(taTab).setContent(R.id.tab3));  
        tabHost.addTab(tabHost.newTabSpec("wetab").setIndicator(weTab).setContent(R.id.tab4)); 
        //ListView点击事件
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
        		if(arg2==0){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==1){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==2){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==3){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==4){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==5){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==6){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==7){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        		if(arg2==8){
        			Intent i1=new Intent(MainActivity.this,Shucai.class);
        			startActivity(i1);
        		}
        	} 	
        });
        //登陆按钮
        Button b=(Button)findViewById(R.id.Button01);
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity.this,Zhuce.class);
			startActivity(i);
			}
		});
        
        
        ListView gouwulist=(ListView)findViewById(R.id.listViewgouwuche);
    	List<Map<String,Object>> gouwulistItems=new ArrayList<Map<String,Object>>();
    		Map<String,Object> gouwumap=new HashMap<String,Object>();
    		gouwumap.put("image",R.drawable.a1);
    		gouwumap.put("title1","包菜");
    		gouwumap.put("title2","单价：3.8");
    		gouwumap.put("title3","上架时间：2013-12-4");
    		gouwulistItems.add(gouwumap);
    	
    	SimpleAdapter adapter=new SimpleAdapter(MainActivity.this,gouwulistItems,R.layout.shucaib,
    			new String[]{"title1","title2","title3","image"},new int[]{R.id.title1,R.id.title2,R.id.title3,R.id.image});
    	gouwulist.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
