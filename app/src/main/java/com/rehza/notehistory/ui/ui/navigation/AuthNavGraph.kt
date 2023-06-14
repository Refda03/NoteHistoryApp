package com.rehza.notehistory.ui.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rehza.notehistory.ui.ui.screen.walkthrough.Walkthrough
import com.rehza.notehistory.util.DatastorePreference

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    dataStorePreference: DatastorePreference
) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = Screen.Walkthrough.route
    ) {
        composable(route = Screen.Walkthrough.route) {
            Walkthrough(navController, dataStorePreference)
        }
    }
}