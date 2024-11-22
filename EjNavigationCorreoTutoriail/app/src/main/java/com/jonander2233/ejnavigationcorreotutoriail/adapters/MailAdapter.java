package com.jonander2233.ejnavigationcorreotutoriail.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jonander2233.ejnavigationcorreotutoriail.R;
import com.jonander2233.ejnavigationcorreotutoriail.interfaces.IOnClickListener;
import com.jonander2233.ejnavigationcorreotutoriail.models.Mail;
import com.jonander2233.ejnavigationcorreotutoriail.models.UnknownContact;

import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailHolder> {
    private final List<Mail> mails;
    private final IOnClickListener listener;
    public MailAdapter(List<Mail> mails, IOnClickListener listener) {
        this.mails = mails;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MailAdapter.MailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_mail,null);
        return new MailHolder(itemview);
    }
    public void updateData(List<Mail> newMails) {
        mails.clear();
        mails.addAll(newMails);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull MailAdapter.MailHolder holder, int position) {
        Mail mail = mails.get(position);
        holder.bindMail(mail);
    }

    @Override
    public int getItemCount() {
        return mails.size();
    }


    public class MailHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvUsername;
        TextView tvSubject;
        TextView tvContent;
        TextView tvSentOn;
        ImageView ivProfilePic;

        public MailHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvSubject = itemView.findViewById(R.id.tvSubject);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvSentOn = itemView.findViewById(R.id.tvSentOn);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
            itemView.setOnClickListener(this);
        }
        public void bindMail(Mail mail){
            if(mail.getContact().equals(UnknownContact.getUnknownContact())){
                tvUsername.setText(mail.getFrom());
                ivProfilePic.setImageResource(R.drawable.unknown);
            } else {
                tvUsername.setText(mail.getContact().getName());
                int userPhoto = mail.getContact().getFoto();
                String userPhotoString = "c" + userPhoto;
                int resourceId = itemView.getContext().getResources().getIdentifier(userPhotoString,"drawable",itemView.getContext().getPackageName());
                if (resourceId != 0) {
                    ivProfilePic.setImageResource(resourceId);
                } else {
                    ivProfilePic.setImageResource(R.drawable.unknown);
                }
            }
            tvSubject.setText(mail.getSubject());
            tvSentOn.setText(mail.getSentOn());
            String texto = "";
            if(mail.getBody().length() > 20){
                texto = mail.getBody().substring(0,20);
                tvContent.setText(texto + "...");
            }else {
                tvContent.setText(mail.getBody());
            }

        }
        @Override
        public void onClick(View view) {
            if(listener != null)
                listener.onClick(getAdapterPosition());
        }
    }

}
