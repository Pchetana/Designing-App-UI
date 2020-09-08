package com.developer.chp.yourcaption;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private int numoftab;
    private final ArrayList<Fragment> fragmentsList = new ArrayList<>();
    private final ArrayList<String> fragTitle = new ArrayList<>();


    public PageAdapter(FragmentManager fm, int numoftab)
    {
        super(fm);
        this.numoftab = numoftab;
    }

    @Override
    public Fragment getItem(int position)
    {
       switch (position)
       {
           case 0:
               return new Moods();

           case 1:
               return new Travel();
           case 2:
               return new FestiveFragment();

               default:
                   return null;
       }

    }

    @Override
    public int getCount() {
        return numoftab;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
