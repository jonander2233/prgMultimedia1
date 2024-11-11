package com.jonander2233.fragmenttemario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailViewHolder> {
    private final Mail[] mails;
    private final IOnClickListener listener;

    public MailAdapter(Mail[] mails, IOnClickListener listener) {
        this.mails = mails;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* Cargamos el layout preparado para la visualización en formato lista */
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_mail, parent, false);
        /* Creamos el ViewHolder personalizado y lo devolvemos */
        return new MailViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MailViewHolder holder, int position) {
        /* Obtenemos el correo de la posición solicitada */
        Mail mail = mails[position];
        /* Llamamos a nuestro método personalizado que asigna los valores a los componentes del layout */
        holder.bindMail(mail);
    }

    @Override
    public int getItemCount() {
        return mails.length;
    }
    public class MailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvFrom;
        private final TextView tvSubject;

        public MailViewHolder(View itemView) {
            super(itemView);
            tvFrom = itemView.findViewById(R.id.tvFrom);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            itemView.setOnClickListener(this);
        }
        public void bindMail(Mail mail) {
            tvFrom.setText(mail.getFrom());
            tvSubject.setText(mail.getSubject());
        }
        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(getAdapterPosition());
            }
        }
    }
}
