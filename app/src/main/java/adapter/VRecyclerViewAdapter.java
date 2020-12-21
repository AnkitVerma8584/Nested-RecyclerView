package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netflix.Dashboard;
import com.example.netflix.R;

import java.util.ArrayList;

import models.BottomSheet;
import models.HorizontalModel;
import models.VerticalModel;

public class VRecyclerViewAdapter extends RecyclerView.Adapter<VRecyclerViewAdapter.VRVViewHolder> {

    private final Context context;
    private final ArrayList<VerticalModel> verticalModels;
    private FragmentManager fragmentManager;

    public VRecyclerViewAdapter(Context context, ArrayList<VerticalModel> verticalModels,FragmentManager fragmentManager) {
        this.context = context;
        this.verticalModels = verticalModels;
        this.fragmentManager=fragmentManager;
    }

    @NonNull
    @Override
    public VRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout,parent,false);
        return new VRVViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull VRVViewHolder holder, int position) {

        VerticalModel verticalModel = verticalModels.get(position);
        ArrayList<HorizontalModel> horizontalModelArrayList = verticalModel.getArrayList();
        String mTitle = verticalModel.getTitle();
        holder.title.setText(mTitle);
        HRecyclerViewAdapter hRecyclerViewAdapter =new HRecyclerViewAdapter(context,horizontalModelArrayList);
        holder.recyclerView.setAdapter(hRecyclerViewAdapter);

        hRecyclerViewAdapter.setOnItemClickListener((position1, view) -> {
            BottomSheet bottomSheet = new BottomSheet(horizontalModelArrayList.get(position1).getMovieName(),horizontalModelArrayList.get(position1).getImage(),horizontalModelArrayList.get(position1).getDescription());
            bottomSheet.show(fragmentManager,"Bottom_Sheet");
        });

    }

    @Override
    public int getItemCount() {
        return verticalModels.size();
    }

    public static class VRVViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView recyclerView;

        public VRVViewHolder(@NonNull View itemView,Context context)
        {
            super(itemView);
            title = itemView.findViewById(R.id.film_title);
            recyclerView = itemView.findViewById(R.id.horizontalRecyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        }
    }
}
