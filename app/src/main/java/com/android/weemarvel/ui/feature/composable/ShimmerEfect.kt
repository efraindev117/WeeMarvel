package com.android.weemarvel.ui.feature.composable

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.android.weemarvel.R


@Composable
fun CardShimmerEffect() {
    val shimmerAlpha = rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 600),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    ).value

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.card_height))
                            .width(dimensionResource(id = R.dimen.card_width))
                            .background(Color.LightGray.copy(alpha = shimmerAlpha))
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_max_material))
                            .width(dimensionResource(id = R.dimen.shimmer_width))
                            .height(dimensionResource(id = R.dimen.shimmer_height))
                            .background(Color.LightGray.copy(alpha = shimmerAlpha))
                    )
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.height_min_material)))
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.card_height))
                            .width(dimensionResource(id = R.dimen.card_width))
                            .background(Color.LightGray.copy(alpha = shimmerAlpha))
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.padding_max_material))
                            .width(dimensionResource(id = R.dimen.shimmer_width))
                            .height(dimensionResource(id = R.dimen.shimmer_height))
                            .background(Color.LightGray.copy(alpha = shimmerAlpha))
                    )
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.height_min_material)))
            }
        }

    }

}

