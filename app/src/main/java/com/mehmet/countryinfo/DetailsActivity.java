package com.mehmet.countryinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mehmet.countryinfo.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

      //  Intent intent = getIntent();
                                    //Casting
       // LandMark selectedLandMark = (LandMark) intent.getSerializableExtra("landmark");

        SingletonLearn singletonLearn = SingletonLearn.getInstance();
        LandMark selectedLandMark = singletonLearn.getLandMark();

        binding.Name.setText(selectedLandMark.name);
        binding.countryText.setText(selectedLandMark.Country);
        binding.imageView.setImageResource(selectedLandMark.image);
    }
}