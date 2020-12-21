package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.netflix.R;

import java.util.ArrayList;
import java.util.List;

import models.HorizontalModel;

public class HRecyclerViewAdapter extends RecyclerView.Adapter<HRecyclerViewAdapter.HRVViewHolder> {

    private final Context context;
    private final ArrayList<HorizontalModel> arrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position,int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public HRecyclerViewAdapter(Context context, ArrayList<HorizontalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_layout, parent, false);
        return new HRecyclerViewAdapter.HRVViewHolder(view, mListener,arrayList);
    }

    @Override
    public void onBindViewHolder(@NonNull HRVViewHolder holder, int position) {
        HorizontalModel horizontalModel = arrayList.get(position);
        holder.imageView.setClipToOutline(true);
        Glide.with(context).load(horizontalModel.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class HRVViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public HRVViewHolder(@NonNull View itemView, OnItemClickListener listener, List<HorizontalModel> horizontalModels) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position,horizontalModels.get(position).getImage());
                    }
                }
            });
        }
    }
}

