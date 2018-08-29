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

import com.jain.tavish.comicbuzz.ModelClasses.Main.Volumes.VolumesResult;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Activities.DetailActivity;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.jain.tavish.comicbuzz.Utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolumeAdapter extends RecyclerView.Adapter<VolumeAdapter.ViewHolder>{

    private Context context;
    private List<VolumesResult> volumesResultList;

    public VolumeAdapter(Context mContext, List<VolumesResult> mResultList){
        context = mContext;
        volumesResultList = mResultList;
    }

    @NonNull
    @Override
    public VolumeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_volumes, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumeAdapter.ViewHolder holder, final int position) {

        Picasso.get()
                .load(volumesResultList.get(position).getImage().getSmallUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error_404)
                .into(holder.volumeCoverImage);

        holder.volumeName.setText(volumesResultList.get(position).getName());
        holder.countOfIssues.setText(Integer.toString(volumesResultList.get(position).getCountOfIssues()) + 1);
        holder.startYear.setText(volumesResultList.get(position).getStartYear());

        if(volumesResultList.get(position).getPublisher() != null) {
            holder.publisher.setText(volumesResultList.get(position).getPublisher().getName());
        }else {
            holder.publisher.setText("Not Available");
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(ConstantUtils.BUNDLE_ACTIVITY_NAME, ConstantUtils.NAV_ITEM_VOLUMES);
                intent.putExtra(ConstantUtils.BUNDLE_ID, volumesResultList.get(position).getId());
                context.startActivity(intent);
            }
        });

        holder.datePublished.setText(DateUtils.parseDateToddMMyyyy(volumesResultList.get(position).getDateAdded()));
    }

    @Override
    public int getItemCount() {
        return volumesResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_volume_image) ImageView volumeCoverImage;
        @BindView(R.id.tv_volume_name)TextView volumeName;
        @BindView(R.id.tv_count_of_issues)TextView countOfIssues;
        @BindView(R.id.tv_start_year)TextView startYear;
        @BindView(R.id.tv_publisher_name)TextView publisher;
        @BindView(R.id.tv_date_published) TextView datePublished;
        @BindView(R.id.card_view_layout_volumes) CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
