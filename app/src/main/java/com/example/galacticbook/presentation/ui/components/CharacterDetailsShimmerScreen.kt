package com.example.galacticbook.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CharacterDetailsShimmerScreen(
    brush: Brush,
    modifier: Modifier = Modifier
) {
    Column {
        Spacer(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
                .background(brush)
        )
        Spacer(modifier = Modifier.padding(16.dp).fillMaxWidth(0.5f).height(20.dp).background(brush))
        Spacer(modifier = Modifier.padding(16.dp).fillMaxWidth(0.7f).height(20.dp).background(brush))
        Spacer(modifier = Modifier.padding(16.dp).fillMaxWidth(0.8f).height(20.dp).background(brush))
        Spacer(modifier = Modifier.padding(16.dp).fillMaxWidth(0.9f).height(20.dp).background(brush))
        Spacer(modifier = Modifier.padding(16.dp).fillMaxWidth(0.9f).height(20.dp).background(brush))

    }
}

@Preview
@Composable
fun CharacterDetailsShimmerScreenPreview() {
    CharacterDetailsShimmerScreen(
        brush = linearGradient(
            listOf(
                Color.LightGray.copy(alpha = 0.9f),
                Color.LightGray.copy(alpha = 0.4f),
                Color.LightGray.copy(alpha = 0.9f)
            )
        )
    )
}