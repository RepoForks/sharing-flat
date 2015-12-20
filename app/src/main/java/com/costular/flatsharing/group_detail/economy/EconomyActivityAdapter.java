package com.costular.flatsharing.group_detail.economy;

import android.content.Context;
import android.net.TrafficStats;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.costular.flatsharing.R;
import com.costular.flatsharing.data.Transaction;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by diego on 19/12/15.
 */
public class EconomyActivityAdapter extends RecyclerView.Adapter<EconomyActivityAdapter.EconomyActivityViewHolder>{

    private List<Transaction> transactionList;
    private Context context;

    public EconomyActivityAdapter() {
        transactionList = new ArrayList<>();
    }

    public EconomyActivityAdapter(List<Transaction> transactions) {
        this.transactionList = transactions;
    }

    public void replaceData(List<Transaction> transactions) {
        this.transactionList = transactions;
    }

    public void replaceAndUpdateData(List<Transaction> transactions) {
        replaceData(transactions);
        notifyDataSetChanged();
    }

    public Transaction getItem(int position) {
        return transactionList.get(position);
    }

    @Override
    public EconomyActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_economy_activity, parent, false);
        return new EconomyActivityViewHolder(root);
    }

    @Override
    public void onBindViewHolder(EconomyActivityViewHolder holder, int position) {
        Transaction transaction = getItem(position);

        if(transaction != null) {
            Picasso.with(context)
                    .load(transaction.getPayer()[0].getAvatarURL())
                    .fit()
                    .centerCrop()
                    .into(holder.userAvatar);

            holder.title.setText(transaction.getTitleOfTransaction(context));
            holder.description.setText(transaction.getDescriptionOfTransaction(context));
            holder.dateTime.setText(transaction.getDateTime());
        }
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public class EconomyActivityViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.economy_activity_user_avatar) CircleImageView userAvatar;
        @Bind(R.id.economy_activity_title) TextView title;
        @Bind(R.id.economy_activity_description) TextView description;
        @Bind(R.id.economy_activity_datetime) TextView dateTime;

        public EconomyActivityViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
