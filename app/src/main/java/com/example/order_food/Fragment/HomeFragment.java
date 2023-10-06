package com.example.order_food.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.order_food.Card.PopularFoodCard;
import com.example.order_food.R;
import com.example.order_food.adapter.PopularAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList imageList = new ArrayList<SlideModel>();
        imageList.add(new SlideModel(R.drawable.discount,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.discoun1,ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.discount2, ScaleTypes.FIT));

        ImageSlider imageSlider = view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);

        PopularFoodCard food1 = new PopularFoodCard(1,R.drawable.discoun1,"Food 1",12);
        PopularFoodCard food2 = new PopularFoodCard(1,R.drawable.discount,"Food 2",15);
        PopularFoodCard food3 = new PopularFoodCard(1,R.drawable.discount2,"Food 3",20);

        List<PopularFoodCard> foods = new ArrayList<>();

        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        RecyclerView recView = view.findViewById(R.id.rec_popular_food);
        recView.setLayoutManager(new LinearLayoutManager(requireContext()));

        recView.setAdapter(new PopularAdapter(foods));

        return view;
    }
}