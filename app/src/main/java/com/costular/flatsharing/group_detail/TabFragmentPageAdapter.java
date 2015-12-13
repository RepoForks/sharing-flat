package com.costular.flatsharing.group_detail;

import android.app.ListFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.group_detail.economy.EconomyFragment;
import com.costular.flatsharing.group_detail.lists.ListsFragment;
import com.costular.flatsharing.group_detail.tasks.TasksFragment;

/**
 * Created by diego on 13/12/15.
 */
public class TabFragmentPageAdapter extends FragmentPagerAdapter{

    public static final String[] sections = new String[3];
    public static final int SECTION_ECONOMY = 0;
    public static final int SECTION_TASKS = 1;
    public static final int SECTION_LIST = 2;

    private Group group;

    public TabFragmentPageAdapter(Context context, FragmentManager fm, Group group) {
        super(fm);
        sections[SECTION_ECONOMY] = context.getString(R.string.detail_tab_section_economy);
        sections[SECTION_TASKS] = context.getString(R.string.detail_tab_section_tasks);
        sections[SECTION_LIST] = context.getString(R.string.detail_tab_section_list);
        this.group = group;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case SECTION_ECONOMY:
                return EconomyFragment.newInstance(group);
            case SECTION_TASKS:
                return TasksFragment.newInstance(group);
            case SECTION_LIST:
                return ListsFragment.newInstance(group);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return sections.length;
    }

    @Override
    public String getPageTitle(int position) {
        return sections[position];
    }
}
