package com.android.weemarvel.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.weemarvel.ui.feature.character.CharacterScreen
import com.android.weemarvel.ui.navigation.RootNavGraph
import com.android.weemarvel.ui.theme.WeeMarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeeMarvelTheme {
                // A surface container using the 'background' color from the theme
                navController = rememberNavController()
                RootNavGraph(navController)
            }
        }
    }
}
