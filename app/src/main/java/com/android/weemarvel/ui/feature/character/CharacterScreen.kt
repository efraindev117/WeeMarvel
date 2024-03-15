package com.android.weemarvel.ui.feature.character

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.weemarvel.R
import com.android.weemarvel.ui.feature.character.composable.CharacterList
import com.android.weemarvel.ui.feature.composable.CardShimmerEffect
import com.android.weemarvel.ui.feature.composable.WeeTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen(
    navController: NavController,
    mViewModel: CharacterViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(topBar = {
            WeeTopAppBar()
        }) { paddingValues ->
            val response = mViewModel.characterResponse.value
            val responseByName = mViewModel.characterResponseByName.value
            if (response.data?.isNotEmpty()!! && responseByName.data?.isNotEmpty()!!) {
                CharacterList(
                    data = response.data,
                    dataByName = responseByName.data,
                    paddingValues = paddingValues,
                    navController = navController
                )
            }
            if (response.error.isNotEmpty()) {
                Toast.makeText(
                    LocalContext.current,
                    stringResource(id = R.string.toast_error_msj),
                    Toast.LENGTH_SHORT
                ).show()
            }
            if (response.isLoading) {
                CardShimmerEffect()
            }
        }
    }
}

@Preview
@Composable
fun ShimmerPrev() {
    CardShimmerEffect()
}
