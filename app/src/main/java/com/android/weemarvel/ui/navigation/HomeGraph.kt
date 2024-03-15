package com.android.weemarvel.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.weemarvel.ui.feature.character.CharacterScreen
import com.android.weemarvel.ui.feature.character.detail.CharacterDetail


fun NavGraphBuilder.characterNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.HOME,
        startDestination = CharacterScreen.CharacterScreenList.route
    ) {
        composable(route = CharacterScreen.CharacterScreenList.route) {
            CharacterScreen(
                navController = navController)
        }
        composable(route = CharacterScreen.CharacterDetails.route) {
            CharacterDetail(
                navController = navController
            )
        }
    }
}
sealed class CharacterScreen(val route: String) {
    object CharacterScreenList : CharacterScreen("character_route")
    object CharacterDetails : CharacterScreen("details_route")
}
