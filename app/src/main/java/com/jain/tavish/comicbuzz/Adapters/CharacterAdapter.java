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

import com.jain.tavish.comicbuzz.ModelClasses.Main.Characters.CharactersResult;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Activities.DetailActivity;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    private Context context;
    private List<CharactersResult> charactersResultList;

    public CharacterAdapter(Context mContext, List<CharactersResult> mResultList){
        context = mContext;
        charactersResultList = mResultList;
    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_characters, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CharacterAdapter.ViewHolder holder, final int position) {

        if(charactersResultList.get(position).getCharactersImage() != null) {
            Picasso.get()
                    .load(charactersResultList.get(position).getCharactersImage().getSmallUrl())
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error_404)
                    .into(holder.characterCoverImage);
        }

        holder.characterName.setText(charactersResultList.get(position).getName());
        if(charactersResultList.get(position).getPublisher() != null) {
            holder.birth.setText(charactersResultList.get(position).getPublisher().getName());
        }
        switch (charactersResultList.get(position).getGender()) {
            case 1:
                holder.gender.setText("Male");
                break;
            case 2:
                holder.gender.setText("Female");
                break;
            default:
                holder.gender.setText("Other");
                break;
        }
        holder.realName.setText(charactersResultList.get(position).getRealName());
        holder.countOfAppearances.setText(Integer.toString(charactersResultList.get(position).getCountOfIssueAppearances()) + 1);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(ConstantUtils.BUNDLE_ACTIVITY_NAME, ConstantUtils.NAV_ITEM_CHARACTERS);
                intent.putExtra(ConstantUtils.BUNDLE_ID, charactersResultList.get(holder.getAdapterPosition()).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return charactersResultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_character_image) ImageView characterCoverImage;
        @BindView(R.id.tv_character_name)TextView characterName;
        @BindView(R.id.tv_birth)TextView birth;
        @BindView(R.id.tv_gender)TextView gender;
        @BindView(R.id.tv_real_name)TextView realName;
        @BindView(R.id.tv_count_of_appearances) TextView countOfAppearances;
        @BindView(R.id.card_view_layout_character) CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
