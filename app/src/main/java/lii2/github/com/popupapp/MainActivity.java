package lii2.github.com.popupapp;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    RelativeLayout mainLayout;

    ViewGroup.LayoutParams layoutParams;

    PopupWindow popUp;

    Button button;

    boolean clicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FragmentPagerAdapter adapterViewPager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = new RelativeLayout(this);
        viewPager = new ViewPager(this);

        layoutParams = new ViewGroup.LayoutParams(-2, -2);//wrap content

        popUp = new PopupWindow(this);

        button = new Button(this);

        button.setText("Click Me");
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (clicked) {
                    popUp.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);
                    clicked = false;
                } else {
                    popUp.dismiss();
                    clicked = true;
                }
            }
        });

        popUp.setContentView(viewPager);

        mainLayout.addView(button);

        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        // Attach the page change listener inside the activity
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

        setContentView(mainLayout);

    }//end of oncreate


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FirstFragment.newInstance();
                case 1:
                    return SecondFragment.newInstance();
                case 2:
                    return ThirdFragment.newInstance();
                case 3:
                    return FourthFragment.newInstance();
                default:
                    return null;
            }
        }

    }

}
