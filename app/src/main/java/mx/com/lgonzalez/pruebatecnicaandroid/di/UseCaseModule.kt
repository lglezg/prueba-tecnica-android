package mx.com.lgonzalez.pruebatecnicaandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import mx.com.lgonzalez.domain.repositories.PokemonRepository
import mx.com.lgonzalez.domain.usecases.GetPokemonDetailsUseCase
import mx.com.lgonzalez.domain.usecases.GetPokemonDetailsUseCaseImpl
import mx.com.lgonzalez.domain.usecases.GetPokemonsUseCase
import mx.com.lgonzalez.domain.usecases.GetPokemonsUseCaseImpl
import mx.com.lgonzalez.domain.usecases.UpdatePokemonUseCase
import mx.com.lgonzalez.domain.usecases.UpdatePokemonUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {


    @Provides
    @ViewModelScoped
    fun provideGetPokemonsUseCase(
        pokemonRepository: PokemonRepository
    ): GetPokemonsUseCase {
        return GetPokemonsUseCaseImpl(pokemonRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPokemonDetailsUseCase(
        pokemonRepository: PokemonRepository
    ): GetPokemonDetailsUseCase {
        return GetPokemonDetailsUseCaseImpl(pokemonRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideUpdatePokemonUseCase(
        pokemonRepository: PokemonRepository
    ): UpdatePokemonUseCase {
        return UpdatePokemonUseCaseImpl(pokemonRepository)
    }

}