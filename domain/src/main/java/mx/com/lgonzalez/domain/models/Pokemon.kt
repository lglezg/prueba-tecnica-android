package mx.com.lgonzalez.domain.models


data class Pokemon(
    val height: Int,
    val id: Int,
    val name: String,
    val urlImage: String,
    val types: List<String>,
    val weight: Int,
    val isFavorite: Boolean
)
