
package com.example.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(startDestination: String = "dog_list") {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("dog_list") {
            DogListScreen(viewModel = viewModel()) { dogImage ->
                navController.navigate("dog_detail/$dogImage")
            }
        }
        composable("dog_detail/{dogImage}") { backStackEntry ->
            val dogImage = backStackEntry.arguments?.getString("dogImage")
            DogDetailScreen(dogImage ?: "")
        }
    }
}
    