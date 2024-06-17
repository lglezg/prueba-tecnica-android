package mx.com.lgonzalez.domain.usecases

import mx.com.lgonzalez.domain.models.Pokemon


interface UpdatePokemonUseCase {
    suspend operator fun invoke(pokemon: Pokemon)
}