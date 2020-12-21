package models;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.netflix.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {
    private final String name;
    private final String description;
    private final int image;

    public BottomSheet(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet, container, false);
        ImageView imageView = v.findViewById(R.id.img);
        imageView.setImageResource(image);
        TextView textView = v.findViewById(R.id.filmName);
        textView.setText(name);
        TextView desc = v.findViewById(R.id.textView2);
        desc.setText(description);
        textView.setText(name);
        return v;
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}
