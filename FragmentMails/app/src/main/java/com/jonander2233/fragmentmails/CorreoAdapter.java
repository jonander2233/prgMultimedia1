package com.jonander2233.fragmentmails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CorreoAdapter extends RecyclerView.Adapter<CorreoAdapter.CorreoViewHolder>{
    private final List<Correo> correos;
    private final IOnClickListener listener;

    public CorreoAdapter(List<Correo> correos, IOnClickListener listener) {
        this.correos = correos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CorreoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_mail,null);
        return new CorreoViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull CorreoViewHolder holder, int position) {
        Correo correo = correos.get(position);
        holder.bindMail(correo);
    }

    @Override
    public int getItemCount() {
        return correos.size();
    }

    protected class CorreoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView tvFrom;
        private final TextView tvSubject;

        public CorreoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvFrom = itemView.findViewById(R.id.tvFrom);
            this.tvSubject = itemView.findViewById(R.id.tvSubject);
            itemView.setOnClickListener(this);

        }
        public void bindMail(Correo correo){
            tvFrom.setText(correo.getText());
            tvSubject.setText(correo.getSubject());
        }

        @Override
        public void onClick(View view) {
            if(listener !=null){
                listener.onClick(getAdapterPosition());
            }
        }
    }

}
