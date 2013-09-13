package net.yscs.android.square_progressbar_example;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    private static final int[] COLOR_ARRAY = { Color.RED, Color.BLUE,
            Color.GREEN, Color.YELLOW, Color.CYAN, Color.MAGENTA };
    private static final String[] COLOR_NAMES = { "red", "blue", " green",
            "yellow", "cyan", "magenta" };
    private static final int[] IMAGE_IDS = { R.drawable.city,
            R.drawable.millennium_stadium, R.drawable.edinburgh,
            R.drawable.holyroodpark };
    private static final String[] IMAGE_DESC = { "sunrise at the city",
            "the millennium stadium", "carlton hill", "holyrood park" };

    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    private ActionBarDrawerToggle drawerToggle;
    private CustomAdapter mAdapter;

    private CharSequence drawerTitle;
    private CharSequence title;
    private SquareFragment squareFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (getSupportFragmentManager().findFragmentByTag("test_frag") == null) {
            squareFragment = new SquareFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, squareFragment, "test_frag")
                    .commit();
        }
        title = drawerTitle = getTitle();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.left_drawer);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START);
        mAdapter = new CustomAdapter(this, COLOR_ARRAY, COLOR_NAMES, IMAGE_IDS,
                IMAGE_DESC);
        drawerListView.setAdapter(mAdapter);
        drawerListView.setOnItemClickListener(new DrawerItemClickListener());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(title);
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                supportInvalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        this.title = title;
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    void changeTarget(int position, boolean clear) {
        drawerListView.setItemChecked(position, true);
        switch (position) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
            squareFragment.squareProgressBar
                    .setColor(COLOR_ARRAY[position - 1]);
            break;
        case 8:
        case 9:
        case 10:
        case 11:
            squareFragment.squareProgressBar.setImage(IMAGE_IDS[position - 8]);
            break;
        case 13:
            squareFragment.squareProgressBar.clearProgressAtEnd(clear);
            break;
        case 15:
            Intent siteIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.signer.pro"));
            startActivity(siteIntent);
            break;
        case 16:
            Intent githubIntent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/mrwonderman/android-square-progressbar"));
            startActivity(githubIntent);
            break;
        }
        drawerLayout.closeDrawers();
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            changeTarget(position, false);
        }
    }
}
