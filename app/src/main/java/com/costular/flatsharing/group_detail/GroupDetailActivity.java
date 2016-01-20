package com.costular.flatsharing.group_detail;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.costular.flatsharing.BaseActivity;
import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.costular.flatsharing.util.ImageUtil;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class GroupDetailActivity extends BaseActivity {

    public static final String GROUP = "group";

    @Bind(R.id.container) ViewPager viewPager;
    @Bind(R.id.tabs) TabLayout tabLayout;
    @Bind(R.id.toolbar_title) TextView toolbarTitle;
    @Bind(R.id.avatar_icon) CircleImageView avatarIcon;

    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        ButterKnife.bind(this);
        setUpToolbar(true);

        group = getIntent().getExtras().getParcelable(GROUP);
        setToolbarTitle("");
        setCustomToolbarTitle(group.getTitle());
        loadIconGroup();

        TabFragmentPageAdapter pagerAdapter = new TabFragmentPageAdapter(getApplicationContext(), getSupportFragmentManager(), group);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setCustomToolbarTitle(String title) {
        toolbarTitle.setText(title);
    }

    private void loadIconGroup() {
        Picasso.with(this)
                .load(group.getImageURL())
                .fit()
                .centerCrop()
                .into(avatarIcon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_group_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_leave_group:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
