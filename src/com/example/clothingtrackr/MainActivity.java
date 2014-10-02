package com.example.clothingtrackr;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.PopupMenu;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener{
	private PagerAdapter pagerAdapter;
	private ViewPager viewPager;
	private ActionBar actionBar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Action bar + tabs
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);
        
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
       	 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        
        Tab tab = actionBar.newTab().setText(R.string.tab_what_to_wear).setTabListener(this);;
        System.out.println("ONE1");

        System.out.println("ONE2");
        actionBar.addTab(tab);
        System.out.println("ONE3");
        tab = actionBar.newTab().setText(R.string.tab_closet);
        tab.setTabListener(this);
        actionBar.addTab(tab);
        tab = actionBar.newTab().setText(R.string.tab_settings);
        tab.setTabListener(this);
        actionBar.addTab(tab);
        System.out.println("TWO");
        // Swipe View
    }
    
    public void showPopup(View v){
    	PopupMenu popup = new PopupMenu(this, v);
    	MenuInflater inflater = popup.getMenuInflater();
    	inflater.inflate(R.menu.sort_menu, popup.getMenu());
    	popup.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_sort) {
        	View sortView = findViewById(R.id.action_sort);
        	showPopup(sortView);
        	System.out.println("SORT CLICKED");
        	return true;
        }
        else if(id == R.id.action_search) {
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());
		
	}


	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
