package mx.com.lgonzalez.data.models

import com.google.gson.annotations.SerializedName
import mx.com.lgonzalez.data.models.PokemonItem

data class PokemonList(
    @SerializedName("results") val results : List<PokemonItem>
)
