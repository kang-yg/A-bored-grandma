package com.example.yg.A_bored_grandma;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.picture);
            textView = view.findViewById(R.id.name);
        }
    }

    private ArrayList<AppListInfo> appListInfoArrayList;

    MyAdapter(ArrayList<AppListInfo> appListInfoArrayList) {
        this.appListInfoArrayList = appListInfoArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.imageView.setImageResource(appListInfoArrayList.get(position).drawableId);
        myViewHolder.textView.setText(appListInfoArrayList.get(position).name);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                switch (position) {
                    case 0:
                        try {
                            Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                            if (intent == null) {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "com.google.android.youtube")));
                            } else {
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                            }
                        } catch (NullPointerException e) {
                            Log.d("NullPointerException", "null");
                            e.getStackTrace();
                        }
                        break;
                    case 1:
                        Log.d("click check", Integer.toString(position));
                        try {
                            Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.kakao.talk");
                            if (intent == null) {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "com.kakao.talk")));
                            } else {
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                            }
                        } catch (NullPointerException e) {
                            Log.d("NullPointerException", "null");
                            e.getStackTrace();
                        }
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return appListInfoArrayList.size();
    }
}
