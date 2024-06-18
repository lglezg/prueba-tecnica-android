package mx.com.lgonzalez.presentation.screens.third.activity

import mx.com.lgonzalez.domain.models.Pokemon

data class PokemonDetailsState(
    val pokemon: Pokemon? = null,
    val isLoading : Boolean = false
)
