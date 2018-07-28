package com.dgdev.mbtms;

import android.arch.persistence.room.Room;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.dgdev.mbtms.local.preferences.PreferencesConfig;
import com.dgdev.mbtms.local.preferences.data.AppLocalDB;
import com.dgdev.mbtms.remote.ModelEfficiencyResponse;

public class MainActivity extends AppCompatActivity implements Userscreen.OnLoginFragmentActivityListener, Welcome.onWelcomeFragmentActivityLienster, Dashboard.OnDashboardFragmentActivityListener, Reports.OnReportsFragmentActvityListener, Visits.OnVisitFragmentActivityListener, Tools.OnToolsFragmentActivityListener {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    public static PreferencesConfig preferencesConfig;
    public static AppLocalDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesConfig = new PreferencesConfig(this);

        // Set a Toolbar to replace the ActionBar.
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);


        //adding first fragment to container, if the user logged in once the Dashboard wills showup,
        // and if user first time login to the app then login page will come first.

        if (findViewById(R.id.flContent) != null) {
            if (savedInstanceState != null) {
                return;
            }
            if (preferencesConfig.ReadLoggedUser() != "None") {
                Dashboard dashboard = new Dashboard();
                getSupportFragmentManager().beginTransaction().add(R.id.flContent, dashboard).commit();
            } else {
                Userscreen userscreen = new Userscreen();
                getSupportFragmentManager().beginTransaction().add(R.id.flContent, userscreen).commit();
            }
        }

        db = Room.databaseBuilder(getApplicationContext(), AppLocalDB.class, "applocaldb").build();

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);

    }

    private void setupDrawerContent(NavigationView nvDrawer) {

        nvDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });

    }

    private void selectDrawerItem(MenuItem menuItem) {

        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.nav_dash_fragment:
                fragmentClass = Dashboard.class;
                break;
            case R.id.nav_visit_fragment:
                fragmentClass = Visits.class;
                break;
            case R.id.nav_report_fragment:
                fragmentClass = Reports.class;
                break;
            case R.id.nav_user_fragment:
                fragmentClass = Userscreen.class;
                break;
            case R.id.nav_tools_fragment:
                fragmentClass = Tools.class;
                break;
            default:
                fragmentClass = Dashboard.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void performRegistration() {
        Registration registration = new Registration();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, registration).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String Ucode) {
        preferencesConfig.WriteLoggedUser(Ucode);
        Dashboard dashboard = new Dashboard();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, dashboard).addToBackStack(null).commit();
    }

    @Override
    public void performLoginCheck() {
        if (preferencesConfig.ReadLoggedUser() != "None") {
            Welcome welcome = new Welcome();
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, welcome).addToBackStack(null).commit();
        }
    }

    @Override
    public void logout() {
        preferencesConfig.RemoveLoggedUser();
        Userscreen userscreen = new Userscreen();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, userscreen).addToBackStack(null).commit();
    }

    @Override
    public void checkDashboard() {
        if (preferencesConfig.ReadLoggedUser() == "None") {
            Userscreen userscreen = new Userscreen();
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, userscreen).addToBackStack(null).commit();
        }
    }

    @Override
    public void checkRepors() {
        if (preferencesConfig.ReadLoggedUser() == "None") {
            Userscreen userscreen = new Userscreen();
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, userscreen).addToBackStack(null).commit();
        }
    }

    @Override
    public void checkvisits() {
        if (preferencesConfig.ReadLoggedUser() == "None") {
            Userscreen userscreen = new Userscreen();
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, userscreen).addToBackStack(null).commit();
        }
    }

    @Override
    public void checktools() {
        if (preferencesConfig.ReadLoggedUser() == "None") {
            Userscreen userscreen = new Userscreen();
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent, userscreen).addToBackStack(null).commit();
        }
    }

    @Override
    public void backToDash() {
        Dashboard dashboard = new Dashboard();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, dashboard).addToBackStack(null).commit();
    }

    @Override
    public void navigate2Fragment(ImageView imageView) {

        Fragment fragment = null;
        Class fragmentClass;
        switch (imageView.getId()) {
            case R.id.img_visit:
                fragmentClass = Visits.class;
                break;
            case R.id.img_upload:
                fragmentClass = Tools.class;
                break;
            case R.id.img_download:
                fragmentClass = Tools.class;
                break;
            case R.id.img_logout:
                fragmentClass = Userscreen.class;
                break;
            default:
                fragmentClass = Dashboard.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).addToBackStack(null).commit();
    }

    @Override
    public void refreshEfficiencyReport(ModelEfficiencyResponse mer) {
        preferencesConfig.saveEffiData(mer);
    }
}
