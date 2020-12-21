package com.example.netflix;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import adapter.SliderAdapter;
import adapter.VRecyclerViewAdapter;
import models.HorizontalModel;
import models.SliderModel;
import models.VerticalModel;

public class Dashboard extends AppCompatActivity {

    private RecyclerView vRecyclerView;
    private ViewPager2 viewPager2;
    private final Handler slideHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Objects.requireNonNull(getSupportActionBar()).hide();
        viewPager2 = findViewById(R.id.image_slider);
        vRecyclerView = findViewById(R.id.verticalRecyclerView);
        vRecyclerView.setHasFixedSize(true);
        vRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        showData();

        List<SliderModel> sliderModels = new ArrayList<>();
        sliderModels.add(new SliderModel(R.drawable.vp1));
        sliderModels.add(new SliderModel(R.drawable.vp2));
        sliderModels.add(new SliderModel(R.drawable.vp3));
        sliderModels.add(new SliderModel(R.drawable.vp4));
        sliderModels.add(new SliderModel(R.drawable.vp5));
        sliderModels.add(new SliderModel(R.drawable.vp6));

        viewPager2.setAdapter(new SliderAdapter(sliderModels,viewPager2));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,3000);
            }
        });

    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

    private void showData() {

        ArrayList<HorizontalModel> hArrayList1 = new ArrayList<>();
        ArrayList<HorizontalModel> hArrayList2 = new ArrayList<>();
        ArrayList<HorizontalModel> hArrayList3 = new ArrayList<>();
        ArrayList<HorizontalModel> hArrayList4 = new ArrayList<>();
        ArrayList<HorizontalModel> hArrayList5 = new ArrayList<>();
        ArrayList<VerticalModel> vArrayList = new ArrayList<>();

        hArrayList1.add(new HorizontalModel(R.drawable.your_name,"Your Name", "A romantic comedy about a teen girl and boy who exchange their body and experience their lives."));
        hArrayList1.add(new HorizontalModel(R.drawable.mirai, "Mirai","A random anime movie"));
        hArrayList1.add(new HorizontalModel(R.drawable.whisker_away,"Whiskers Away", "NETFLIX KHAREED khudka aur dekle"));
        hArrayList1.add(new HorizontalModel(R.drawable.book,"Horse", "A random picture of a story book"));
        hArrayList1.add(new HorizontalModel(R.drawable.silent_voice,"Silent Voice", ""));
        vArrayList.add(new VerticalModel("Anime", hArrayList1));

        hArrayList2.add(new HorizontalModel(R.drawable.extraction,"Extraction", "Thor becomes a soldier and extracts an indian boy from bangladeshi gundas"));
        hArrayList2.add(new HorizontalModel(R.drawable.haunting,"Haunting", "Horror stuff idk"));
        hArrayList2.add(new HorizontalModel(R.drawable.barry_2016,"Barry", "No clue"));
        hArrayList2.add(new HorizontalModel(R.drawable.d_lies,"Dangerous lies", "Meyeta sundor but mithebaadi"));
        hArrayList2.add(new HorizontalModel(R.drawable.stranger_things,"Stranger Things", "Eleven and her friends explores the mystery of the other world"));
        vArrayList.add(new VerticalModel("Fiction", hArrayList2));

        hArrayList3.add(new HorizontalModel(R.drawable.whisker_away,"Whiskers Away", ""));
        hArrayList3.add(new HorizontalModel(R.drawable.d_lies,"Dangerous lies", "Meyeta sundor but mithebaadi"));
        hArrayList3.add(new HorizontalModel(R.drawable.mirai,"Mirai", "A random anime movie"));
        hArrayList3.add(new HorizontalModel(R.drawable.barry_2016,"Barry", "NETFLIX KHAREED khudka aur dekle"));
        hArrayList3.add(new HorizontalModel(R.drawable.haunting,"Haunting", "Horror stuff idk"));
        vArrayList.add(new VerticalModel("Fantasy", hArrayList3));

        hArrayList4.add(new HorizontalModel(R.drawable.extraction,"Extraction", "Thor becomes a soldier and extracts an indian boy from bangladeshi gundas"));
        hArrayList4.add(new HorizontalModel(R.drawable.silent_voice,"Silen Voice", "No idea about this movie"));
        hArrayList4.add(new HorizontalModel(R.drawable.haunting,"Haunting", "Horror stuff idk"));
        hArrayList4.add(new HorizontalModel(R.drawable.book,"Book", "A random picture of a story book"));
        hArrayList4.add(new HorizontalModel(R.drawable.stranger_things,"Stranger Things", "Eleven and her friends explores the mystery of the other world"));
        vArrayList.add(new VerticalModel("Action", hArrayList4));

        hArrayList5.add(new HorizontalModel(R.drawable.your_name,"Your Name", "A romantic comedy about a teen girl and boy who exchange their body and experience their lives."));
        hArrayList5.add(new HorizontalModel(R.drawable.stranger_things,"Stranger Things", "Eleven and her friends explores the mystery of the other world"));
        hArrayList5.add(new HorizontalModel(R.drawable.haunting,"Haunting", "Horror stuff idk"));
        hArrayList5.add(new HorizontalModel(R.drawable.barry_2016, "Barry","No clue"));
        hArrayList5.add(new HorizontalModel(R.drawable.mirai,"Mirai", "A random anime movie"));
        vArrayList.add(new VerticalModel("Comedy", hArrayList5));

        VRecyclerViewAdapter vRecyclerViewAdapter = new VRecyclerViewAdapter(getApplicationContext(), vArrayList,getSupportFragmentManager());
        vRecyclerView.setAdapter(vRecyclerViewAdapter);
    }
}