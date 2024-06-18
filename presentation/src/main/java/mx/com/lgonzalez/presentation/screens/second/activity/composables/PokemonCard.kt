package mx.com.lgonzalez.presentation.screens.second.activity.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import mx.com.lgonzalez.domain.models.Pokemon
import mx.com.lgonzalez.presentation.R
import mx.com.lgonzalez.presentation.screens.second.activity.SecondActivityEvent
import mx.com.lgonzalez.presentation.ui.theme.LocalSpacing
import mx.com.lgonzalez.pruebatecnica.presentation.composables.CustomImage

@Composable
fun PokemonCard(
    modifier: Modifier,
    pokemonDetails: Pokemon,
    onEvent: (SecondActivityEvent) -> Unit,
    onClick: (String) -> Unit,
) {
    val localSpacing = LocalSpacing.current

    var showImage by rememberSaveable {
        mutableStateOf(false)
    }

    if (showImage)
        Dialog(onDismissRequest = { showImage = !showImage }) {
            CustomImage(
                modifier = Modifier
                    .padding(end = localSpacing.spaceSmall)
                    .size(300.dp),
                url = pokemonDetails.urlImage,
                initials = pokemonDetails.name,
                uri = null
            )
        }
    Card(
        modifier = modifier
            .wrapContentHeight()
            .clickable { onClick(pokemonDetails.name) },
        shape = MaterialTheme.shapes.small
    ) {
        Column {
            IconButton(
                modifier = Modifier.align(Alignment.End),
                onClick = { onEvent(SecondActivityEvent.FavoritePokemonChange(pokemonDetails)) }
            ) {
                Icon(
                    painter = painterResource(
                        id = if (pokemonDetails.isFavorite)
                            R.drawable.baseline_favorite
                        else
                            R.drawable.baseline_favorite_border
                    ),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
            Row(
                modifier = Modifier
                    .padding(bottom = localSpacing.spaceMedium)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                CustomImage(
                    modifier = Modifier
                        .padding(end = localSpacing.spaceSmall)
                        .size(100.dp)
                        .clickable {
                            showImage = !showImage
                        },
                    url = pokemonDetails.urlImage,
                    initials = pokemonDetails.name,
                    uri = null
                )
                Text(
                    text = pokemonDetails.name,
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }

}