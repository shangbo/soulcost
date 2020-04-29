package com.loftysoul.soulcost.ui.account;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.loftysoul.soulcost.ui.account.Invest.InvestAccountFragment;
import com.loftysoul.soulcost.ui.account.cash.CashAccountFragment;
import com.loftysoul.soulcost.ui.account.credit.CreditAccountFragment;

import java.util.ArrayList;

public class AccountViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;


    public AccountViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.clear();
        fragments.add(CashAccountFragment.newInstance("1","2"));
        fragments.add(CreditAccountFragment.newInstance("1","2"));
        fragments.add(InvestAccountFragment.newInstance("1","2"));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
