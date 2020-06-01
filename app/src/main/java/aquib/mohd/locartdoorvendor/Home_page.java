package aquib.mohd.locartdoorvendor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import aquib.mohd.locartdoorvendor.Fragments.Help;
import aquib.mohd.locartdoorvendor.Fragments.Home;
import aquib.mohd.locartdoorvendor.Fragments.Location;
import aquib.mohd.locartdoorvendor.Fragments.Orders;
import aquib.mohd.locartdoorvendor.Fragments.Paymentdetails;
import aquib.mohd.locartdoorvendor.Fragments.Profile;
import aquib.mohd.locartdoorvendor.Fragments.Subscription;

public class Home_page extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    long back;
    Toast backToast;
    private TextView loc_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        setupToolbar();


        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigationView = findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(listner);
        navigationView.getMenu().getItem(0).setChecked(true);
        loadFrag(new Home());
    }

    public void setupToolbar() {
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        loc_TV = toolbar.findViewById(R.id.loc_toolbar_TV);
        loc_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFrag(new Location());
            }

        });
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    private NavigationView.OnNavigationItemSelectedListener listner = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.home:
                    loadFrag(new Home());
                    return true;


                case R.id.userprofile:
                   loadFrag(new Profile());
                    return true;

                case R.id.orders:
                 loadFrag(new Orders());
                    return true;

                case R.id.subscription:
                    loadFrag(new Subscription());
                    break;


                case R.id.pay:
                    loadFrag(new Paymentdetails());
                    return true;

                case R.id.help:
                  loadFrag(new Help());
                   return true;

                case R.id.share:
                    shareTextUrl();
                    return true;


                case R.id.logout:
                    logout();
                    return true;
            }


            return false;
        }
    };

        private void loadFrag(Fragment fragment) {

            if (fragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.homepage_frame_container, fragment, "tag");
                transaction.addToBackStack("tag").commit();
                drawerLayout.closeDrawers();
            }
        }

        private void shareTextUrl(){
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

            // Add data to the intent, the receiving app will decide
            // what to do with it.
            share.putExtra(Intent.EXTRA_SUBJECT, "Share Locartdoorapp with your friends");
            share.putExtra(Intent.EXTRA_TEXT, "http://www.locartdoor.com");

            startActivity(Intent.createChooser(share, "Share link!"));
        }

        private void logout(){
        this.finish();

        }

        @Override
        public void onBackPressed() {

//            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
//
//            if (backStackEntryCount == 0) {
//                moveTaskToBack(true);
//
//            }


            if (back + 2000 > System.currentTimeMillis()) {
                backToast.cancel();
                super.onBackPressed();
                return;
            } else {
                backToast = Toast.makeText(getApplicationContext(), "please back again to exit", Toast.LENGTH_SHORT);
                backToast.show();
            }
            back = System.currentTimeMillis();
        }
    }
