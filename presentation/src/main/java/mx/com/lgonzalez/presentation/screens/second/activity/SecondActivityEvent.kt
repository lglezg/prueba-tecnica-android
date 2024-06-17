package mx.com.lgonzalez.presentation.screens.second.activity

import mx.com.lgonzalez.domain.models.Pokemon


sealed interface SecondActivityEvent {
    data object LoadMore : SecondActivityEvent

    data class FavoritePokemonChange(val pokemon: Pokemon): SecondActivityEvent
}