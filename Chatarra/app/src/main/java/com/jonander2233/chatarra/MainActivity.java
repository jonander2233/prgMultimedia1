package com.jonander2233.chatarra;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jonander2233.chatarra.model.Contact;
import com.jonander2233.chatarra.parser.ContactParser;
import com.jonander2233.chatarra.ui.fragments.FragmentDetail;
import com.jonander2233.chatarra.ui.fragments.FragmentList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentList.IOnAttachListener,FragmentDetail.IOnAttachListener, IOnClickListener {
    private List<Contact> persons = new ArrayList<>();
    private final String PERSON_KEY = "persons";
    private final String SELECTED_PERSON_KEY = "selectedPerson";
    private FragmentManager fragmentManager;
    private FragmentDetail fragmentDetail;
    boolean detail;
    private int selectedPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            loadDataList();
        }
        else {
            persons = (List<Contact>) savedInstanceState.getSerializable(PERSON_KEY);
            selectedPerson = savedInstanceState.getInt(SELECTED_PERSON_KEY);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detail = findViewById(R.id.fcvDetail) != null;
        if (detail){
            fragmentDetail = (FragmentDetail) fragmentManager.findFragmentById(R.id.fcvDetail);
            if(!(fragmentManager.findFragmentById(R.id.fcvList) instanceof FragmentList)){
                fragmentManager.popBackStack();
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(PERSON_KEY, (Serializable) persons);
        outState.putInt(SELECTED_PERSON_KEY, selectedPerson);
    }

    public void loadDataList(){
        selectedPerson = -1;
        persons = ContactParser.parseContacts(this);
        if (!persons.isEmpty()) {
            selectedPerson = 0;
        }
    }

    @Override
    public List<Contact> getData() {
        return persons;
    }

    @Override
    public void onClick(int position) {
        Contact person = persons.get(position);
        selectedPerson = position;
        if (detail) {
            fragmentDetail.updateContact(person);
        }
        else {
            fragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .replace(R.id.fcvList, FragmentDetail.class, null)
                    .commit();
        }

    }

    @Override
    public Contact getSelectedContact() {
        return persons.get(selectedPerson);
    }
}