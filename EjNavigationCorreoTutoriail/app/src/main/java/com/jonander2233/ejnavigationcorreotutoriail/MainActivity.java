package com.jonander2233.ejnavigationcorreotutoriail;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.DragAndDropPermissionsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.jonander2233.ejnavigationcorreotutoriail.interfaces.IOnClickListener;
import com.jonander2233.ejnavigationcorreotutoriail.models.Account;
import com.jonander2233.ejnavigationcorreotutoriail.models.Mail;
import com.jonander2233.ejnavigationcorreotutoriail.parsers.ContactParser;
import com.jonander2233.ejnavigationcorreotutoriail.ui.fragments.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,ListFragment.IOnAttachListener, IOnClickListener {
    private DrawerLayout drawerLayout;
    private Account account;
    private static final String ACCOUNT_KEY = "account key for saved instance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(account == null){
            loadData();
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View viewHeader = navigationView.getHeaderView(0);
        TextView tvUsername = viewHeader.findViewById(R.id.nav_header_name);
        tvUsername.setText(account.getName());
        TextView tvEmail = viewHeader.findViewById(R.id.nav_header_email);
        tvEmail.setText(account.getEmail());
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ListFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_sent);
        }

    }

    public List<Mail> getMails(){
        return account.getSentMails();
    }

    public void loadData(){
        ContactParser parser = new ContactParser(this);
        if(parser.parse()){
            account =  parser.getAccount();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        List<Mail> mails = new ArrayList<>();
        if (item.getItemId() == R.id.nav_recived) {
            mails = account.getRecivedMails();
        } else if (item.getItemId() == R.id.nav_sent) {
            mails = account.getSentMails();
        } else if (item.getItemId() == R.id.nav_unread) {
            mails = account.getUnreadMails();
        } else if (item.getItemId() == R.id.nav_spam) {
            mails = account.getSpamMails();
        } else if (item.getItemId() == R.id.nav_trash) {
            mails = account.getDeletedMails();
        }
        updateFragmentWithMails(mails);
        drawerLayout.closeDrawers();
        return true;
    }
    public void updateFragmentWithMails(List<Mail> mails){
        ListFragment fragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if(fragment!= null)
            fragment.updateMailList(mails);
    }
    @Override
    public void onClick(int position) {

    }
}