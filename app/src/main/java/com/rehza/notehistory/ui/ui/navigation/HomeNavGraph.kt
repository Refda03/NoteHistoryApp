package com.rehza.notehistory.ui.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.rehza.notehistory.ui.ui.screen.addhistory.AddHistory
import com.rehza.notehistory.ui.ui.screen.detail.Detail
import com.rehza.notehistory.ui.ui.screen.home.Home
import com.rehza.notehistory.ui.ui.screen.profile.Profile


@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        route = Graph.HOME,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            Home(navController)
        }
        composable(route = Screen.AddHistory.route) {
            AddHistory(navController)
        }
        composable(route = Screen.Profile.route) {
            Profile(navController)
        }
        composable(
            route = "detail/{historyId}",
            arguments = listOf(navArgument("historyId") { type = NavType.IntType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val historyId = arguments.getInt("historyId")
            Detail(navController, historyId)
        }
    }
}