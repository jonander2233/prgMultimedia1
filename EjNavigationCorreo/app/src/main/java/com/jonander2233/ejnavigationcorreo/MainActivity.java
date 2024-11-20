package com.jonander2233.ejnavigationcorreo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.navigation.NavigationView;
import com.jonander2233.ejnavigationcorreo.ui.fragments.HomeFragment;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Cargar el primer fragmento por defecto
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment selectedFragment = null;

        // Determinar qué opción se seleccionó
        switch (item.getItemId()) {
            case R.id.nav_home:
//                selectedFragment = new HomeFragment();
                break;
            case R.id.nav_gallery:
//                selectedFragment = new GalleryFragment();
                break;
            case R.id.nav_slideshow:
//                selectedFragment = new SlideshowFragment();
                break;
        }

        // Reemplazar el fragmento actual
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
