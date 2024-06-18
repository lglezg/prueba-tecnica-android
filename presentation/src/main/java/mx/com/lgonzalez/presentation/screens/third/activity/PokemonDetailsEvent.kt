package mx.com.lgonzalez.presentation.screens.third.activity

sealed interface PokemonDetailsEvent {
    public data object FavoritePokemonChange: PokemonDetailsEvent
}