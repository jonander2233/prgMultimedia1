package com.jonander2233.fragmentscontactlist.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jonander2233.fragmentscontactlist.R;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jonander2233.fragmentscontactlist.R;
import com.jonander2233.fragmentscontactlist.ui.fragments.DetailFragment;
import com.jonander2233.fragmentscontactlist.ui.fragments.ListFragment;
import com.jonander2233.fragmentscontactlist.interfaces.IOnClickListener;
import com.jonander2233.fragmentscontactlist.models.Mail;

public class MainActivity extends AppCompatActivity implements ListFragment.IOnAttachListener, IOnClickListener, DetailFragment.IOnAttachListener {
    private static final String MAILS_KEY = "com.germangascon.fragments.mails";
    private static final String SELECTED_MAIL_KEY = "com.germangascon.fragments.selectedmail";
    private DetailFragment detailFragment;
    private boolean isDetail;
    private Mail[] mails;
    private int selectedMail;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         /* Es importante hacer la comprobación antes de llamar a super.onCreate()
           para que de esta forma no se tenga que parsear el json cada vez que
           se cambia la orientación de la pantalla
         */
        if (savedInstanceState != null) {
            // Si venimos de una instancia creada previamente, recuperamos los correos
            // que habíamos guardado y el último correo que habíamos seleccionado del listado
            mails = (Mail[]) savedInstanceState.getSerializable(MAILS_KEY);
            selectedMail = savedInstanceState.getInt(SELECTED_MAIL_KEY);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

        manager = getSupportFragmentManager();
        isDetail = findViewById(R.id.fcvDetailFragment) != null;
        if (isDetail) {
            detailFragment = (DetailFragment) manager.findFragmentById(R.id.fcvDetailFragment);

            // Si el Fragment que hay cargado en el listado es el detalle lo cambiamos por el listado
            // Esto ocurre cuando giramos la pantalla estando dentro del DetailFragment
            if (!(manager.findFragmentById(R.id.fcvListFragment) instanceof ListFragment)) {
                // Evitamos que el FragmentListado se cargue dos veces
                manager.popBackStack();
                manager.beginTransaction()
                        .setReorderingAllowed(true)
                        // En este caso el addToBackStack no nos interesa ya que se acumularían
                        // dos retrocesos de pila
                        // .addToBackStack(null)
                        .replace(R.id.fcvListFragment, ListFragment.class, null)
                        .commit();
            }
        }

    }

    /**
     * Este método es llamado por Android cuando se cierra la Activity por algún cambio de configuración.
     * Por ejemplo, cuando se cambia la orientación del dispositivo y se tiene que cargar un nuevo layout,
     * la Activity se destruye y se vuelve a crear, pero en el onCreate se le pasa el bundle que guardamos
     * aquí
     * @param outState Variable Bundle donde guardamos los datos que queremos preservar
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(MAILS_KEY, mails);
        outState.putSerializable(SELECTED_MAIL_KEY, selectedMail);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(int position) {
        selectedMail = position;
        if (isDetail) {
            detailFragment.showDetail(mails[selectedMail].getText());
        } else {
            // Si estamos en móvil, reemplazamos el FragmentList por el FragmentDetail
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    // addToBackStack permite que cuando pulsemos el botón atrás volvamos al Fragment anterior
                    // De lo contrario, saldría de la app ya que es la última Activity cargada
                    .addToBackStack(null)
                    .replace(R.id.fcvListFragment, DetailFragment.class, null)
                    .commit();
        }
    }

    public void loadData() {
        selectedMail = 0;
        mails = new Mail[] {
                new Mail("johndoe@example.com", "Mail subject 1", "Mail text 1"),
                new Mail("rantamplan@lucky.com", "Mail subject 2", "Mail text 2"),
                new Mail("rockybalboa@punch.com", "Mail subject 3", "Mail text 3"),
                new Mail("whatever@random.com", "Mail subject 4", "Mail text 4"),
                new Mail("anotherone@simply.com", "Mail subject 5", "Mail text 5")
        };
    }

    @Override
    public Mail[] getMails() {
        if (mails == null) {
            loadData();
        }
        return mails;
    }

    @Override
    public int getSelectedMail() {
        return selectedMail;
    }

    @Override
    public String getMailText() {
        Mail mail = mails[selectedMail];
        setTitle(mail.getSubject());
        return mail.getText();
    }

    /**
     * Al pulsar el botón atrás ponemos como título de la Activity el nombre de la aplicación
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setTitle(R.string.app_name);
    }
}