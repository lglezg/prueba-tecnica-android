package mx.com.lgonzalez.domain.usecases


import mx.com.lgonzalez.domain.models.Pokemon
import mx.com.lgonzalez.domain.repositories.PokemonRepository

class GetPokemonDetailsUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : GetPokemonDetailsUseCase {
    override suspend fun invoke(name: String): Pokemon? {
        return pokemonRepository.getPokemonLocal(name)
    }
}