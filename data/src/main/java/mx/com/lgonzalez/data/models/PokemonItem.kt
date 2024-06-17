package mx.com.lgonzalez.data.models

import com.google.gson.annotations.SerializedName

data class PokemonItem(
    @SerializedName("name") val name: String
)
