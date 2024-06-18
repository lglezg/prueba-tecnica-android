package mx.com.lgonzalez.presentation.screens.third.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;
import mx.com.lgonzalez.domain.models.Pokemon;
import mx.com.lgonzalez.presentation.R;
import mx.com.lgonzalez.presentation.databinding.ActivityPokemonDetailsBinding;
import mx.com.lgonzalez.pruebatecnica.presentation.composables.CustomImageKt;

@AndroidEntryPoint
public class PokemonDetailsActivity extends AppCompatActivity {

    private PokemonDetailsViewModel viewModel;

    private ImageButton ibIsFavorite;
    private ImageButton ibBack;
    private TextView textViewName;
    private TextView textViewWeight;
    private TextView textViewHeight;

    private TextView textViewTypes;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initUi();

        viewModel =new ViewModelProvider(this).get(PokemonDetailsViewModel.class);

        viewModel.getPokemonDetails(getIntent().getStringExtra("NAME"));



        viewModel.getState().observe(this, pokemonDetailsState -> {
            if (pokemonDetailsState.getPokemon() != null){
                loadPokemon(pokemonDetailsState.getPokemon());
            }

        });
    }

    private void initUi(){
        ibIsFavorite = findViewById(R.id.btnFavorite);
        ibBack = findViewById(R.id.btnBack);
        textViewName = findViewById(R.id.textViewName);
        textViewWeight = findViewById(R.id.textViewWeight);
        textViewHeight = findViewById(R.id.textViewHeight);
        textViewTypes = findViewById(R.id.textViewTypes);
        imageView = findViewById(R.id.imageView);


        ibIsFavorite.setOnClickListener(v -> viewModel.favoritePokemonChange());
        ibBack.setOnClickListener(v -> finish());
    }

    private void loadPokemon(Pokemon pokemon){
        ibIsFavorite.setImageResource( pokemon.isFavorite() ? R.drawable.baseline_favorite : R.drawable.baseline_favorite_border);
        textViewName.setText(pokemon.getName());
        textViewWeight.setText("PESO: " + pokemon.getWeight()  );
        textViewHeight.setText("ALTURA: " + pokemon.getHeight() );
        StringBuilder types = new StringBuilder();
        List<String> typeList = pokemon.getTypes();
        for (int i = 0; i < typeList.size(); i++) {
            types.append(typeList.get(i)).append(" ");
        }
        textViewTypes.setText(types);
        Glide.with(this).load(pokemon.getUrlImage()).into(imageView);

    }
}