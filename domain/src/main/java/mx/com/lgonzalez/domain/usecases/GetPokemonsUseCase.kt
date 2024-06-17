package mx.com.lgonzalez.domain.usecases

import mx.com.lgonzalez.domain.models.Pokemon


interface GetPokemonsUseCase {

    suspend operator fun invoke(limit: Int, offset: Int): List<Pokemon>
}