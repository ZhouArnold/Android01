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
	private String[] names=new String[]{"�����߲�","��Ʒˮ��","������Ʒ","���͸�ʳ","������ζ","Ӫ����ʳ","ˮ������","������ʳ","��ˮ����",};
	private String[] descs = new String[]{"�óԵ��߲�","�óԵ�ˮ��","�óԵ���Ʒ","�óԵĸ�ʳ","�óԵ���ζ","�óԵ���ʳ","�óԵĺ���","�óԵ���ʳ","�úȵ�����",};
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
				// �������Ϣ�Ǳ����������͵�
				if (msg.what == 0x1233)
				{
					// ��̬���޸�����ʾ��ͼƬ
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
        //����һ������
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
        //����һ��ListView
        ListView list=(ListView)findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        //����TabHost
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
        //ListView����¼�
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
        //��½��ť
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
    		gouwumap.put("title1","����");
    		gouwumap.put("title2","���ۣ�3.8");
    		gouwumap.put("title3","�ϼ�ʱ�䣺2013-12-4");
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
