package com.android.weemarvel.ui.feature.character.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.weemarvel.domain.model.CharacterUiModel
import com.android.weemarvel.ui.feature.character.CharacterViewModel
import com.android.weemarvel.ui.navigation.CharacterScreen


@Composable
fun CharacterList(
    mViewModel: CharacterViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navController: NavController,
    data: List<CharacterUiModel>,
    dataByName: List<CharacterUiModel>
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        val (listOne, listTwo) = createRefs()
        LazyRow(modifier = Modifier.constrainAs(listOne) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            items(items = data, key = { it.resutls.id!! }) { res ->
                CardItemMarvel(title = res.resutls.name!!,
                    image = res.resutls.thumbnail!!.marvelImage(),
                    goToDetails = {
                        val char = CharacterUiModel(
                            resutls = res.resutls
                        )
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "character",
                            value = char
                        )
                        navController.navigate(route = CharacterScreen.CharacterDetails.route)
                    })
            }
        }

        LazyRow(modifier = Modifier
            .constrainAs(listTwo) {
                top.linkTo(listOne.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            items(items = dataByName, key = { it.resutls.id!! }) { res ->
                CardItemMarvel(title = res.resutls.name!!,
                    image = res.resutls.thumbnail!!.marvelImage(),
                    goToDetails = {
                        val char = CharacterUiModel(
                            resutls = res.resutls
                        )
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "character",
                            value = char
                        )
                        navController.navigate(route = CharacterScreen.CharacterDetails.route)
                    })
            }
        }

    }
}