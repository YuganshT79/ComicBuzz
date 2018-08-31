package com.jain.tavish.comicbuzz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jain.tavish.comicbuzz.ModelClasses.Details.Issue.Issue;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Activities.DetailActivity;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFavsAdapter extends RecyclerView.Adapter<MyFavsAdapter.ViewHolder> {

    private Context context;
    private List<Issue> issuesResultList;

    public MyFavsAdapter(Context mContext, List<Issue> resultList){
        context = mContext;
        issuesResultList = resultList;
    }

    @NonNull
    @Override
    public MyFavsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_my_favs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyFavsAdapter.ViewHolder holder, final int position) {

        Picasso.get()
                .load(issuesResultList.get(position).getResults().getImage().getThumbUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error_404)
                .into(holder.issueCoverImage);

        holder.issueName.setText(issuesResultList.get(position).getResults().getName());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(ConstantUtils.BUNDLE_ACTIVITY_NAME, ConstantUtils.NAV_ITEM_ISSUES);
                intent.putExtra(ConstantUtils.BUNDLE_ID, issuesResultList.get(holder.getAdapterPosition()).getResults().getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return issuesResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_my_favs_issue_image) ImageView issueCoverImage;
        @BindView(R.id.tv_my_favs_issue_name)TextView issueName;
        @BindView(R.id.fl_my_favs_main_layout)ConstraintLayout constraintLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
