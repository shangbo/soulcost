package com.loftysoul.soulcost.ui.account;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.loftysoul.soulcost.BaseActivity;
import com.loftysoul.soulcost.MainActivity;
import com.loftysoul.soulcost.R;

public class AccountFragment extends Fragment {

    private Fragment currentFragment;

    private AccountViewModel mViewModel;

    BottomNavigationView bottomNavigationView;

    private ViewPager accountViewPager;

    private AccountViewPagerAdapter viewPagerAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(MenuItem item){
            switch (item.getItemId()){
                case R.id.navigation_cash:
                    accountViewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_credit:
                    accountViewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_invest:
                    accountViewPager.setCurrentItem(2);
                    break;
            }
            return true;
        }
    };

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            bottomNavigationView.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.account_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);

        viewPagerAdapter = new AccountViewPagerAdapter(getChildFragmentManager());

        bottomNavigationView = getActivity().findViewById(R.id.account_bottom_nav);
        System.out.println(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        accountViewPager = getView().findViewById(R.id.account_viewpager);
        accountViewPager.addOnPageChangeListener(onPageChangeListener);
        accountViewPager.setAdapter(viewPagerAdapter);
    }


}
