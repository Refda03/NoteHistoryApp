package com.rehza.notehistory

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rehza.notehistory.ui.ui.navigation.RootNavigationGraph
import com.rehza.notehistory.ui.ui.theme.NotehistoryTheme
import com.rehza.notehistory.util.DatastorePreference

class MainActivity : ComponentActivity() {

    private lateinit var dataStorePreference: DatastorePreference

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataStorePreference = DatastorePreference.getInstance(this)

        setContent {
            NotehistoryTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavigationGraph(navController = navController, dataStorePreference = dataStorePreference)
                }
            }
        }
    }
}