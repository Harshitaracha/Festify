package com.sujakoona6gmail.appfest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sys on 13-03-2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;
    public PagerAdapter(FragmentManager fm,int numberoftabs){
        super(fm);
        this.noOfTabs=numberoftabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FestsFragment tab1 = new FestsFragment();
                return tab1;
            case 1:
                WorkshopsFragment tab2 = new WorkshopsFragment();
                return tab2;
            case 2:
                CompetitionsFragment tab3 = new CompetitionsFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
