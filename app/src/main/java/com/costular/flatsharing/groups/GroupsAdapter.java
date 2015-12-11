package com.costular.flatsharing.groups;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.costular.flatsharing.data.Group;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by diego on 11/12/15.
 */
public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupsViewHolder>{

    private List<Group> groupList;
    private GroupActionListener groupActionListener;

    public GroupsAdapter(List<Group> groupList, GroupActionListener listener) {
        setListData(groupList);
        this.groupActionListener = listener;
    }

    @Override
    public GroupsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GroupsViewHolder holder, int position) {

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

        //@Bind();
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
