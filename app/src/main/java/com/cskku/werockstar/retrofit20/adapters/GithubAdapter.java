package com.cskku.werockstar.retrofit20.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cskku.werockstar.retrofit20.R;
import com.cskku.werockstar.retrofit20.models.Github;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {

    List<Github> githubList;

    public GithubAdapter(List<Github> list) {
        this.githubList = list;
    }

    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {
        Github github = githubList.get(position);

        Glide.with(holder.mImgUser.getContext())
                .load(github.getImage())
                .placeholder(R.mipmap.ic_account_circle_black_24dp)
                .crossFade()
                .into(holder.mImgUser);

        holder.txtFullname.setText(github.getName());
        holder.txtLocation.setText(github.getLocation());
        holder.txtCompany.setText(github.getCompany());

    }

    @Override
    public int getItemCount() {
        return githubList.size();
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImgUser;
        private TextView txtFullname;
        private TextView txtLocation;
        private TextView txtCompany;

        public GithubViewHolder(View itemView) {
            super(itemView);

            mImgUser = (ImageView) itemView.findViewById(R.id.imgUser);
            txtFullname = (TextView) itemView.findViewById(R.id.fullname);
            txtLocation = (TextView) itemView.findViewById(R.id.location);
            txtCompany = (TextView) itemView.findViewById(R.id.compary);
        }
    }
}
