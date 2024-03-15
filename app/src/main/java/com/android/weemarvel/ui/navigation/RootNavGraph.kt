package com.android.weemarvel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.HOME
    ) {
        characterNavGraph(navController)
    }
}

object Graph {

    const val ROOT = "root_graph"
    const val HOME = "characters_graph"
    const val DETAILS = "details_graph"
}