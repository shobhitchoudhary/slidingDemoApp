package com.shobhit.main;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shobhit.main.adap.ProductImagePagerAdapter;
import com.shobhit.main.adap.ViewPagerAdapter;
import com.shobhit.main.frag.FirstImageFrag;
import com.shobhit.main.frag.FourthImageFrag;
import com.shobhit.main.frag.ImageFrag;
import com.shobhit.main.frag.MilestoneFrag;
import com.shobhit.main.frag.SecondImageFrag;
import com.shobhit.main.frag.ThirdImageFrag;
import com.shobhit.main.frag.VideoFrag;
import com.shobhit.main.utility.CirclePageIndicator;

public class MainActivity extends AppCompatActivity
{
    private Activity mActivity;
    private int[] mTabsIcons;
    private int[] images;
    private ViewPager view_pager_images;
    private CirclePageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity=MainActivity.this;
        view_pager_images= (ViewPager) findViewById(R.id.view_pager_images);

        indicator = (CirclePageIndicator) findViewById(R.id.circle_indicator);
        //images=new int[]{R.drawable.occasion,R.drawable.aclema,R.drawable.everest,R.drawable.girovo_shop};
        //ProductImagePagerAdapter productImagePagerAdapter = new ProductImagePagerAdapter(this, images);
        ViewPager view_pager_images = (ViewPager) findViewById(R.id.view_pager_images);
        //view_pager_images.setAdapter(productImagePagerAdapter);
        //indicator.setViewPager(view_pager_images);
        setupViewPager(view_pager_images);

        mTabsIcons =new int[]{R.drawable.selector_tabbar_video,R.drawable.selector_tabbar_image,R.drawable.selector_tabbar_milestone};

        // Setup the viewPager
        setViewPagerAdapter();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstImageFrag());
        adapter.addFragment(new SecondImageFrag());
        adapter.addFragment(new ThirdImageFrag());
        adapter.addFragment(new FourthImageFrag());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(view_pager_images);
    }

    /**
     * <h>SetViewPagerAdapter</h>
     * <p>
     *     In this method we used to set viewpager and the tablayout.
     * </p>
     */
    private void setViewPagerAdapter()
    {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        if (viewPager != null)
        {
            viewPager.setAdapter(pagerAdapter);
        }

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);
        if (mTabLayout != null)
        {
            mTabLayout.setupWithViewPager(viewPager);

            for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(pagerAdapter.getTabView(i));
            }

            mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter
    {
        final int PAGE_COUNT = 3;

        private final String[] mTabsTitle = {getResources().getString(R.string.video), getResources().getString(R.string.images), getResources().getString(R.string.milestone)};

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        View getTabView(int position) {
            // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
            View view = LayoutInflater.from(mActivity).inflate(R.layout.custom_tab, null);
            ImageView icon = (ImageView) view.findViewById(R.id.icon);
            icon.setImageResource(mTabsIcons[position]);
            TextView tV_tab_bar_text= (TextView) view.findViewById(R.id.tV_tab_bar_text);
            tV_tab_bar_text.setText(mTabsTitle[position]);
            return view;
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return new VideoFrag();

                case 1:
                    return new VideoFrag();

                case 2:
                    return new VideoFrag();

            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabsTitle[position];
        }
    }
}
