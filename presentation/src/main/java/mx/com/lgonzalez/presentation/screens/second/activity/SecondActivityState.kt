package mx.com.lgonzalez.presentation.screens.second.activity

import mx.com.lgonzalez.domain.models.Pokemon


data class SecondActivityState(
    val isLoading : Boolean = false,
    val pokemons : List<Pokemon> = emptyList()
)
