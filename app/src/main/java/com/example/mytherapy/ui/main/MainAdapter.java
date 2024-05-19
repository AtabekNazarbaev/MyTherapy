package com.example.mytherapy.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytherapy.R;
import com.example.mytherapy.db.User;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> { 


    private List<User> historyItems;
    private Context context;

    public MainAdapter(List<User> historyItems, Context context) {
        this.historyItems = historyItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User historyItem = historyItems.get(position);

        holder.textViewName.append(historyItem.getName());
        holder.textViewDate.append(historyItem.getDate());
        holder.textViewTimesPerDay.append(String.valueOf(historyItem.getTimesPerDay()));
        holder.textViewDosage.append(String.valueOf(historyItem.getTotalDosage()));
        holder.textViewTimings.append(historyItem.getTimings());
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        MaterialTextView textViewName, textViewDate, textViewTimesPerDay, textViewDosage, textViewTimings;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tvMedicineName);
//            textViewDate = itemView.findViewById(R.id.medicine_date_text_view_history);
            textViewTimesPerDay = itemView.findViewById(R.id.tvTime);
            textViewDosage = itemView.findViewById(R.id.dosage_text_view);
//            textViewTimings = itemView.findViewById(R.id.medicine_timings_text_view_history);
        }
    }
}
