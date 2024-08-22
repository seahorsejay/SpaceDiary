package com.example.galacticbook.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.galacticbook.domain.GalacticViewModel
import com.example.galacticbook.domain.GalaxyState
import com.example.galacticbook.presentation.ui.components.CharacterCard
import com.example.galacticbook.presentation.ui.components.HomeScreenShimmer
import com.example.galacticbook.presentation.ui.components.LoadingShimmerEffect


@Composable
fun HomeScreen(
    modifier: Modifier,
    viewModel: GalacticViewModel,
    onCharacterClick: (Int) -> Unit = {}
) {
    LaunchedEffect(key1 = true) {
        viewModel.fetchAliens()
    }
    when (val state = viewModel.galaxyState) {
        is GalaxyState.Content -> {
            val data = state.content
            Scaffold { innerpadding ->
                val innerPadding = innerpadding

                LazyColumn {
                    itemsIndexed(data.results) { index, item ->
                        CharacterCard(character = item, onCharacterClick = onCharacterClick)
                        Spacer(modifier = Modifier.size(4.dp))
                    }
                }
            }
        }

        is GalaxyState.Error -> {

        }

        is GalaxyState.Loading -> {
            LoadingShimmerEffect(
                layout = { brush ->
                    HomeScreenShimmer(brush)
                })
        }
    }
}