package com.android.weemarvel.ui.feature.character.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.android.weemarvel.R
import com.example.merlinproject.ui.theme.lexendFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItemMarvel(
    title: String,
    image: String,
    goToDetails: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_min_material))
    ) {
        Card(
            modifier = Modifier
                .height(230.dp)
                .padding(horizontal = dimensionResource(id = R.dimen.padding_min_material))
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            onClick = { goToDetails() }
        ) {
            AsyncImage(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.card_height))
                    .width(dimensionResource(id = R.dimen.card_width)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(), contentScale = ContentScale.FillBounds,
                error = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null
            )
        }
        // Limitar la longitud del título a 50 caracteres
        Text(
            text = if (title.length > 50) title.take(15) + "..." else title,
            fontFamily = lexendFontFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .width(110.dp),
            maxLines = 1, // Limitar el texto a dos líneas
            overflow = TextOverflow.Ellipsis // Mostrar puntos suspensivos (...) si el texto es demasiado largo
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CardMarvelPrev() {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .height(230.dp)
            .width(150.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.campus_card_elevation)),
        onClick = { }) {
        Column(content = {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_launcher_background)
                        .transformations(CircleCropTransformation())
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            )
        })
    }
}