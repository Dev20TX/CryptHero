package com.dev20tx.android.cryptohero.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dev20tx.android.cryptohero.R;

public class LoadViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;
    public LoadViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById (R.id.progress_bar);
    }
}
