package com.epiclancers.app.anmio;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BoxerViewHolder extends RecyclerView.ViewHolder {

    public TextView boxerName;
    public TextView boxerAge;
    ConstraintLayout constraintLayout;

    public BoxerViewHolder(View itemView) {
        super(itemView);

        boxerName = itemView.findViewById(R.id.boxerName);
        boxerAge = itemView.findViewById(R.id.boxerAge);
        constraintLayout = itemView.findViewById(R.id.con);

    }
}
