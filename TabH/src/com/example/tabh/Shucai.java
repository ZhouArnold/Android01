package com.example.tabh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Shucai extends Activity { 
	protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.shucai);
    ListView listview=(ListView)findViewById(R.id.shucai);
	int[] imageId=new int[]{
			R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,
			R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8
	};
	String[] title1=new String[]{
			"包菜","大白菜","娃娃菜","空心菜",
			"韭菜","油麦菜","黄瓜","西红柿"
	};
	String[] title2=new String[]{
			"单价：¥3.8","单价：¥2.8","单价：¥4.6","单价：¥5.1",
			"单价：¥2.1","单价：¥4.8","单价：¥3.9","单价：¥3.3"
	};
	String[] title3=new String[]{
		"上架时间：2013-12-4","上架时间：2013-12-4","上架时间：2013-12-4","上架时间：2013-12-4",
		"上架时间：2013-12-4","上架时间：2013-12-4","上架时间：2013-12-4","上架时间：2013-12-4"
	};
	List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
	for(int i=0;i<imageId.length;i++){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("image",imageId[i]);
		map.put("title1",title1[i]);
		map.put("title2",title2[i]);
		map.put("title3",title3[i]);
		listItems.add(map);
	}
	SimpleAdapter adapter=new SimpleAdapter(Shucai.this,listItems,R.layout.shucaib,
			new String[]{"title1","title2","title3","image"},new int[]{R.id.title1,R.id.title2,R.id.title3,R.id.image});
	listview.setAdapter(adapter);
	listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
    		if(arg2==0){
    		Intent i1 =new Intent(Shucai.this,Baocai.class);
    		startActivity(i1);}
    		if(arg2==1){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		if(arg2==2){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		if(arg2==3){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		if(arg2==4){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		if(arg2==5){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		if(arg2==6){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		if(arg2==7){
        		Intent i1 =new Intent(Shucai.this,Baocai.class);
        		startActivity(i1);}
    		
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