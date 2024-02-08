package com.example.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.palette.graphics.Palette;

import com.example.palette.databinding.ActivityCardExpandedBinding;

public class CardExpandedActivity extends AppCompatActivity {

    private ActivityCardExpandedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardExpandedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int imagen = getIntent().getExtras().getInt("imagen");
        binding.imageView.setImageResource(imagen);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imagen);
        // Extrae la paleta de colores de la imagen
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // Obtiene los colores de la paleta
                binding.toolbar.setBackgroundColor(palette.getVibrantColor(0));
                binding.LightVibrant.setBackgroundColor(palette.getLightVibrantColor(0));
                binding.Muted.setBackgroundColor(palette.getMutedColor(0));
                binding.DarkMuted.setBackgroundColor(palette.getDarkMutedColor(0));
                binding.LightMuted.setBackgroundColor(palette.getLightMutedColor(0));
            }
        });
    }
}