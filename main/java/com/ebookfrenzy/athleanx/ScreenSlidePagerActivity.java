package com.ebookfrenzy.athleanx;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.telephony.mbms.FileServiceInfo;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chabbal.slidingdotsplash.SlidingSplashView;
import com.chabbal.slidingdotsplash.ViewPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;


import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

import static javax.xml.xpath.XPathFactory.newInstance;

public class ScreenSlidePagerActivity  extends FragmentActivity  {

    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ax1);


        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPagerAdapter.startUpdate(mPager);
        MyFragment tab1 = (MyFragment)  mPagerAdapter.instantiateItem(mPager, 0);
        second tab2 = (second)  mPagerAdapter.instantiateItem(mPager, 1);
        mPagerAdapter.finishUpdate(mPager);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("selected page is :" + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Button leftNav = (Button) findViewById(R.id.left_nav);
        Button rightNav = (Button) findViewById(R.id.right_nav);

        // Images left navigation
        leftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = mPager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    mPager.setCurrentItem(tab);
                } else if (tab == 0) {
                    mPager.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = mPager.getCurrentItem();
                tab++;
                mPager.setCurrentItem(tab);
            }
        });



        CirclePageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;
        mIndicator.setRadius(7 * density);
        mIndicator.setPageColor(0x00000000);
        mIndicator.setFillColor(0xFFC40000);
        mIndicator.setStrokeColor(0xFFA00000);
        mIndicator.setStrokeWidth(1 * density);



    }


    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) return new MyFragment();
            if (position == 1) return new second();
            return null;  // or throw some exception
        }
    }












}


