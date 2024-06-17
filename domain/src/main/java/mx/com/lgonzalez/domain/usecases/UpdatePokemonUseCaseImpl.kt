package mx.com.lgonzalez.domain.usecases


import mx.com.lgonzalez.domain.models.Pokemon
import mx.com.lgonzalez.domain.repositories.PokemonRepository

class UpdatePokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : UpdatePokemonUseCase {
    override suspend fun invoke(pokemon: Pokemon) {
       pokemonRepository.updatePokemon(pokemon)
    }
}