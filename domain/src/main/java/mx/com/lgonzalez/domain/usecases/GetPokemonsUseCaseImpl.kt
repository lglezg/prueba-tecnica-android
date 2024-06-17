package mx.com.lgonzalez.domain.usecases

import mx.com.lgonzalez.domain.models.Pokemon
import mx.com.lgonzalez.domain.repositories.PokemonRepository

class GetPokemonsUseCaseImpl(
    private val pokemonRepository: PokemonRepository
)
    : GetPokemonsUseCase {
    override suspend fun invoke(limit: Int, offset: Int): List<Pokemon> {
        return pokemonRepository.getPokemons(limit, offset)
    }
}