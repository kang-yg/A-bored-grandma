package com.example.yg.A_bored_grandma;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class YouTubeCommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public class YouTubeVeiwHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public YouTubeVeiwHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.youTube_commend_name);
        }
    }

    private ArrayList<YouTubeItem> youTubeItems;

    YouTubeCommendAdapter(ArrayList<YouTubeItem> _youTubeItems) {
        this.youTubeItems = _youTubeItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.youtube_commend_item, parent, false);

        return new YouTubeVeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        YouTubeVeiwHolder youTubeVeiwHolder = (YouTubeVeiwHolder) holder;

        youTubeVeiwHolder.textView.setText(youTubeItems.get(position).commendName);

        youTubeVeiwHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                switch (position) {
                    case 0:
                        try {
                            Intent intent = new Intent(Intent.ACTION_SEARCH);
                            intent.setPackage("com.google.android.youtube");
                            intent.putExtra("query", context.getResources().getString(R.string.superman_is_comeback));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;

                    case 1:
                        try {
                            Intent intent = new Intent(Intent.ACTION_SEARCH);
                            intent.setPackage("com.google.android.youtube");
                            intent.putExtra("query", context.getResources().getString(R.string.find_family));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            Intent intent = new Intent(Intent.ACTION_SEARCH);
                            intent.setPackage("com.google.android.youtube");
                            intent.putExtra("query", context.getResources().getString(R.string.cultwoshow));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            Intent intent = new Intent(Intent.ACTION_SEARCH);
                            intent.setPackage("com.google.android.youtube");
                            intent.putExtra("query", context.getResources().getString(R.string.deliciousguys));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return youTubeItems.size();
    }
}
