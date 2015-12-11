package com.costular.flatsharing.groups;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Group;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by diego on 11/12/15.
 */
public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupsViewHolder>{

    private Context context;
    private List<Group> groupList;
    private GroupActionListener groupActionListener;

    public GroupsAdapter(List<Group> groupList, GroupActionListener listener) {
        setListData(groupList);
        this.groupActionListener = listener;
    }

    @Override
    public GroupsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_group, parent, false);
        return new GroupsViewHolder(root, groupActionListener);
    }

    @Override
    public void onBindViewHolder(final GroupsViewHolder holder, int position) {
        Group group = getItem(position);

        if(group != null) {
            holder.groupTitle.setText(group.getTitle());
            holder.groupDescription.setText(group.getDescription());

            Picasso.with(context)
                    .load(group.getImageURL())
                    .placeholder(R.drawable.group_placeholder)
                    .fit()
                    .centerCrop()
                    .into(holder.groupImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            Bitmap bitmap = ((BitmapDrawable) holder.groupImage.getDrawable()).getBitmap();
                            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                                @Override
                                public void onGenerated(Palette palette) {
                                    Palette.Swatch lightVibrant = palette.getLightVibrantSwatch();
                                    if(lightVibrant != null) {
                                        holder.dataContainer.setBackgroundColor(lightVibrant.getRgb());
                                        holder.groupTitle.setTextColor(lightVibrant.getTitleTextColor());
                                        holder.groupDescription.setTextColor(lightVibrant.getBodyTextColor());
                                    }
                                }
                            });
                        }

                        @Override
                        public void onError() {

                        }
                    });
        }
    }

    public void setListData(List<Group> list) {
        groupList = list;
    }

    public void replaceListData(List<Group> list) {
        setListData(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public Group getItem(int position) {
        return groupList.get(position);
    }

    public class GroupsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.group_image) ImageView groupImage;
        @Bind(R.id.group_data_container) ViewGroup dataContainer;
        @Bind(R.id.group_title) TextView groupTitle;
        @Bind(R.id.group_description) TextView groupDescription;

        private GroupActionListener listener;

        public GroupsViewHolder(View itemView, GroupActionListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Group group = getItem(position);
            listener.groupClicked(group);
        }
    }

    public interface GroupActionListener {
        void groupClicked(Group group);
    }
}
