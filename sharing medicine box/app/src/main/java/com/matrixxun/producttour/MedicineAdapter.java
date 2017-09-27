package com.matrixxun.producttour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by swaggymiller on 2017/7/22.
 */

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

    private Context mContext;
    private List<Medicine> mMedicineList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView medicineImage;
        TextView medicineName;

        public ViewHolder(View view) {

            super(view);
            cardView = (CardView) view;
            medicineImage = (ImageView) view.findViewById(R.id.medicine_image);
            medicineName = (TextView) view.findViewById(R.id.medicine_name);
        }
    }

    public MedicineAdapter(List<Medicine> medicineList) {

        mMedicineList = medicineList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.medicine_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Medicine medicine = mMedicineList.get(position);
                Intent intent = new Intent(mContext, MedicineActivity.class);
                intent.putExtra(MedicineActivity.MEDICINE_NAME, medicine.getName());
                intent.putExtra(MedicineActivity.MEDICINE_IMAGE_ID, medicine.getImageID());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Medicine medicine = mMedicineList.get(position);
        holder.medicineName.setText(medicine.getName());
        Glide.with(mContext).load(medicine.getImageID()).into(holder.medicineImage);
    }

    @Override
    public int getItemCount() {
        return mMedicineList.size();
    }
}
