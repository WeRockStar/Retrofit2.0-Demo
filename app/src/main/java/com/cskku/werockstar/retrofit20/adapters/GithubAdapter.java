package com.cskku.werockstar.retrofit20.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kotchaphan on 29/10/2558.
 */
public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder>{

    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{

        public GithubViewHolder(View itemView) {
            super(itemView);
        }
    }
}
