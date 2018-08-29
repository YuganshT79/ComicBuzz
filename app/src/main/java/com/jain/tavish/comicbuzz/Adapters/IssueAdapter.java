package com.jain.tavish.comicbuzz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jain.tavish.comicbuzz.ModelClasses.Main.Issues.IssuesResult;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Activities.DetailActivity;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.jain.tavish.comicbuzz.Utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IssueAdapter extends RecyclerView.Adapter<IssueAdapter.ViewHolder> {

    private Context context;
    private List<IssuesResult> issuesResultList;

    public IssueAdapter(Context mContext, List<IssuesResult> resultList){
        context = mContext;
        issuesResultList = resultList;
    }

    @NonNull
    @Override
    public IssueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_issues, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueAdapter.ViewHolder holder, final int position) {

        Picasso.get()
                .load(issuesResultList.get(position).getImage().getSmallUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error_404)
                .into(holder.issueCoverImage);

        holder.issueName.setText(issuesResultList.get(position).getName());
        holder.publishedOnDate.setText(DateUtils.parseDateToddMMyyyy(issuesResultList.get(position).getDateAdded()));
        holder.volumeName.setText(issuesResultList.get(position).getVolume().getName());
        holder.issueNumber.setText("#" + issuesResultList.get(position).getIssueNumber());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(ConstantUtils.BUNDLE_ACTIVITY_NAME, ConstantUtils.NAV_ITEM_ISSUES);
                intent.putExtra(ConstantUtils.BUNDLE_ID, issuesResultList.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return issuesResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_issue_image) ImageView issueCoverImage;
        @BindView(R.id.tv_issue_name)TextView issueName;
        @BindView(R.id.tv_published_on_date)TextView publishedOnDate;
        @BindView(R.id.tv_contained_in_volume_name)TextView volumeName;
        @BindView(R.id.tv_issue_number)TextView issueNumber;
        @BindView(R.id.card_view_layout_issues) CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
