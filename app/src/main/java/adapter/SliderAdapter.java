package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.netflix.R;

import java.util.List;

import models.SliderModel;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder> {
private final List<SliderModel> sliderModels;
private final ViewPager2 viewPager2;

    public SliderAdapter(List<SliderModel> sliderModels, ViewPager2 viewPager2) {
        this.sliderModels = sliderModels;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImageView(sliderModels.get(position));
        if(position == sliderModels.size()-2)
        viewPager2.post(runnable);
    }

    @Override
    public int getItemCount() {
        return sliderModels.size();
    }

    public static class SliderViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
        }
        void setImageView(SliderModel sliderModel){
            imageView.setImageResource(sliderModel.getImage());
        }
    }
    private final Runnable runnable = new Runnable() {
        @SuppressWarnings("CollectionAddedToSelf")
        @Override
        public void run() {
            sliderModels.addAll(sliderModels);
            notifyDataSetChanged();
        }
    };
}
