package com.example.android.myapplication;

import android.app.Activity;
import android.content.Context;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseUser;


import java.util.List;

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {
//    private String mUserName;
//    private String mSenderName;

    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {
        super(context, resource, objects);
    }

//    public void setName(String mUserName,FriendlyMessage friendlyMessage) {
//        this.mUserName = mUserName;
//        this.mSenderName = friendlyMessage.getName();
//    }


    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }


        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.photoImageView);
        TextView messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        TextView authorTextView = (TextView) convertView.findViewById(R.id.nameTextView);
//        TextView messageTextView1 = (TextView) convertView.findViewById(R.id.messageTextView1);
//        TextView authorTextView1 = (TextView) convertView.findViewById(R.id.nameTextView1);

        FriendlyMessage message = getItem(position);

//        if (mUserName.equals(mSenderName)){
//            messageTextView1.setVisibility(View.INVISIBLE);
//            authorTextView1.setVisibility(View.INVISIBLE);
            boolean isPhoto = message.getPhotoUrl() != null;
            if (isPhoto) {
                messageTextView.setVisibility(View.GONE);
                photoImageView.setVisibility(View.VISIBLE);
                photoImageView.setBackgroundColor(Color.YELLOW);

                Glide.with(photoImageView.getContext()).load(message.getPhotoUrl())
                        .into(photoImageView);

            }
            else {
                messageTextView.setVisibility(View.VISIBLE);
//                messageTextView.setBackgroundColor(Color.YELLOW);
                photoImageView.setVisibility(View.GONE);
                messageTextView.setText(message.getText());
            }
            authorTextView.setText(message.getName());
//            authorTextView.setBackgroundColor(Color.YELLOW);
//        }
//        else{
//            messageTextView.setVisibility(View.INVISIBLE);
//            authorTextView.setVisibility(View.INVISIBLE);
//            boolean isPhoto = message.getPhotoUrl() != null;
//            if (isPhoto) {
//                messageTextView1.setVisibility(View.GONE);
//                photoImageView.setVisibility(View.VISIBLE);
//
//                Glide.with(photoImageView.getContext()).load(message.getPhotoUrl())
//                        .into(photoImageView);
//
//            }
//            else {
//                messageTextView1.setVisibility(View.VISIBLE);
//                photoImageView.setVisibility(View.GONE);
//                messageTextView1.setText(message.getText());
//            }
//            authorTextView1.setText(message.getName());
//        }
        return convertView;
    }
}
