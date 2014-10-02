package com.example.clothingtrackr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

	public PagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public Fragment getItem(int i) {
		switch(i) {
		case 0:
			return new WhatToWearFragment();
		case 1:
			return new ClosetFragment();
		case 2:
			return new SettingsFragment();
		}
		return null;
	}

	public int getCount() {
		return 3;
	}
	
	public CharSequence getPageTitle(int position){
		return "OBJECT " + (position + 1);
	}

}
