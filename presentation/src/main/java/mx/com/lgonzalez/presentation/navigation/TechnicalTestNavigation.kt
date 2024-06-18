package mx.com.lgonzalez.presentation.navigation

import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.com.lgonzalez.presentation.screens.first.activity.FirstActivityScreen
import mx.com.lgonzalez.presentation.screens.second.activity.SecondActivityScreen
import mx.com.lgonzalez.presentation.screens.third.activity.PokemonDetailsActivity

@Composable
fun TechnicalTestNavigation() {
    val navController = rememberNavController()
    val destination = listOf(
        Destination.FistActivity,
        Destination.SecondActivity
    )
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            BottomAppBar {
                destination.forEach {
                    NavigationBarItem(
                        selected = navController.currentDestination?.route == it.route,
                        onClick = {
                            navController.navigate(it.route){
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = rememberVectorPainter(image = it.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = it.label)
                        }
                    )
                }
            }
        }
    ) {

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screens.SecondActivity.route
        ) {
            composable(Screens.FirstActivity.route) {
                FirstActivityScreen(viewModel = hiltViewModel())
            }
            composable(Screens.SecondActivity.route) {
                SecondActivityScreen(viewModel = hiltViewModel()) { name ->
                    context.startActivity(
                        Intent(context, PokemonDetailsActivity::class.java).apply {
                            putExtra("NAME", name)
                        }
                    )
                }
            }

        }
    }
}