package com.android.weemarvel.ui.feature.character.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.weemarvel.R
import com.android.weemarvel.domain.model.CharacterUiModel
import com.android.weemarvel.ui.feature.composable.WeeTopAppBar
import com.example.merlinproject.ui.theme.lexendFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetail(
    navController: NavController,
) {
    val char = remember {
        navController.previousBackStackEntry?.savedStateHandle?.get<CharacterUiModel>("character")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(topBar = {
            WeeTopAppBar()
        }) { paddingValues ->
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                val (img, name, description, comic) = createRefs()
                Card(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_medium_material))
                        .constrainAs(img) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        }
                        .height(dimensionResource(id = R.dimen.card_height))
                        .width(dimensionResource(id = R.dimen.card_width)),
                    shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.card_height))
                            .width(dimensionResource(id = R.dimen.card_width)),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(char?.resutls?.thumbnail!!.marvelImage())
                            .crossfade(true)
                            .build(), contentScale = ContentScale.FillBounds,
                        error = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = stringResource(id = R.string.image_default_description)
                    )
                }

                Text(text = char?.resutls?.name!!,
                    maxLines = 2,
                    fontFamily = lexendFontFamily,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.text_width))
                        .padding(dimensionResource(id = R.dimen.padding_medium_material))
                        .constrainAs(name) {
                            top.linkTo(img.top)
                            start.linkTo(img.end)
                            end.linkTo(parent.end)
                            bottom.linkTo(img.bottom)
                        })

                ElevatedCard(modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.card_description_height))
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium_material),
                        end = dimensionResource(id = R.dimen.padding_medium_material)
                    )
                    .constrainAs(description) {
                        top.linkTo(img.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    }) {
                    Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium_material)),
                        content = {
                            Row(verticalAlignment = Alignment.CenterVertically, content = {
                                Text(
                                    modifier = Modifier
                                        .weight(1f),
                                    text = stringResource(id = R.string.card_titl_description),
                                    fontFamily = lexendFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            }
                            )
                            Row(
                                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_min_material)),
                                verticalAlignment = Alignment.CenterVertically,
                                content = {
                                    Text(
                                        text = if (char.resutls.description.isNullOrEmpty()) {
                                            stringResource(id = R.string.card_titl_no_description)
                                        } else {
                                            char.resutls.description
                                        }, textAlign = TextAlign.Center,
                                        fontFamily = lexendFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier
                                    )
                                })
                        }
                    )
                }

                ElevatedCard(modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium_material),
                        end = dimensionResource(id = R.dimen.padding_medium_material)
                    )
                    .constrainAs(comic) {
                        top.linkTo(description.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }) {
                    Column(modifier = Modifier,
                        content = {
                            Row(verticalAlignment = Alignment.CenterVertically, content = {
                                Text(
                                    modifier = Modifier
                                        .padding(dimensionResource(id = R.dimen.padding_medium_material))
                                        .weight(1f),
                                    text = stringResource(id = R.string.card_titl_comics),
                                    fontFamily = lexendFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            }
                            )
                            Row(verticalAlignment = Alignment.CenterVertically, content = {
                                LazyRow(
                                    modifier = Modifier
                                ) {
                                    items(items = char.resutls.comics?.items!!) {
                                        ComicItems(title = it?.name!!)
                                    }
                                }
                            })
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComicItems(title: String) {
    AssistChip(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_min_material)),
        onClick = { },
        label = {
            Text(
                title, fontFamily = lexendFontFamily,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall,
            )
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.size(AssistChipDefaults.IconSize),
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.default_icon_description)
            )
        }
    )
}
