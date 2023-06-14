package com.rehza.notehistory.ui.ui.navigation

import com.rehza.notehistory.NotehistoryAppState


sealed class Screen(val route: String){
    object Walkthrough: Screen(NotehistoryAppState.WALKTHROUGH_ROUTE)
    object Home: Screen(NotehistoryAppState.HOME_ROUTE)
    object Profile: Screen(NotehistoryAppState.PROFILE_ROUTE)
    object AddHistory: Screen(NotehistoryAppState.ADD_HISTORY_ROUTE)
    object Detail: Screen("detail/{historyId}") {
        fun createRoute(historyId: Int) = "detail/$historyId"
    }
}