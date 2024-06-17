package mx.com.lgonzalez.domain.usecases

import mx.com.lgonzalez.domain.models.Pokemon


interface GetPokemonDetailsUseCase {
    suspend operator fun invoke(name: String): Pokemon?
}