package mx.com.lgonzalez.presentation.screens.third.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mx.com.lgonzalez.domain.usecases.GetPokemonDetailsUseCase
import mx.com.lgonzalez.domain.usecases.UpdatePokemonUseCase
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    private val updatePokemonUseCase: UpdatePokemonUseCase,
) : ViewModel() {

    private val _state = MutableLiveData(PokemonDetailsState())
    val state : LiveData<PokemonDetailsState> = _state

    fun favoritePokemonChange() = viewModelScope.launch {
        val currentPokemon = _state.value?.pokemon ?: return@launch
        val updatedPokemon = currentPokemon.copy(isFavorite = !currentPokemon.isFavorite)

        updatePokemonUseCase.invoke(updatedPokemon)
        _state.value = _state.value?.copy(pokemon = updatedPokemon)

    }

    fun getPokemonDetails(pokemonName: String) = viewModelScope.launch {

        onIsLoadingChange(true)
        val pokemonDetails = getPokemonDetailsUseCase.invoke(pokemonName)
        println(pokemonDetails.toString());
        pokemonDetails?.let { pokemon ->
            println(pokemon.toString());
            _state.value = _state.value?.copy(pokemon = pokemon)
        }
        onIsLoadingChange(false)

    }

    private fun onIsLoadingChange(isLoading: Boolean) {
        _state.value = _state.value?.copy(isLoading = isLoading)
    }


}