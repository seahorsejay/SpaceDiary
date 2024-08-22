package com.example.galacticbook.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenShimmer(
    brush: Brush,
    modifier: Modifier = Modifier
) {
    Column {
        repeat(8) { CharacterCardShimmer(brush = brush) }
    }
}

@Composable
fun CharacterCardShimmer(
    brush: Brush
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp), verticalAlignment = Alignment.Top
    ) {

        Spacer(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(brush)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.5f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.7f)
                    .background(brush)
            )

            Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.9f)
                    .background(brush)
            )
            Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(fraction = 0.9f)
                    .background(brush)
            )

        }
    }
}

@Preview
@Composable
fun CharacterCardShimmerPreview() {
    CharacterCardShimmer(
        brush = linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.9f),
                Color.LightGray.copy(alpha = 0.4f),
                Color.LightGray.copy(alpha = 0.9f)
            )
        )
    )
}