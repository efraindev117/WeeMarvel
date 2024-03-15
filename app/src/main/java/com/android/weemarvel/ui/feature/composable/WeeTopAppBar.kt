package com.android.weemarvel.ui.feature.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.android.weemarvel.R
import com.example.merlinproject.ui.theme.lexendFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.title_character_list_screen),
                fontFamily = lexendFontFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.LocalMovies,
                tint = MaterialTheme.colorScheme.tertiary,
                contentDescription = stringResource(id = R.string.default_icon_description)
            )
        }
    )
}