package com.example.assignment11;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment11.fragments.MatchFragment;
import com.example.assignment11.fragments.PlayerFragment;
import com.example.assignment11.fragments.TeamFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TeamFragment();
            case 1:
                return new PlayerFragment();
            case 2:
                return new MatchFragment();
            default:
                return new TeamFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
