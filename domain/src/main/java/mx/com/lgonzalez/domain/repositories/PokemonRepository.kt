package mx.com.lgonzalez.domain.repositories

import mx.com.lgonzalez.domain.models.Pokemon


interface PokemonRepository {
    suspend fun getPokemons(limit: Int, offset: Int): List<Pokemon>

    suspend fun getPokemonLocal(name: String): Pokemon?
    suspend fun updatePokemon(pokemon: Pokemon)
}