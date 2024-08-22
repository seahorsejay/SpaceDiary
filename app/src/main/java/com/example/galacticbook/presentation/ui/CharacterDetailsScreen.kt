package com.example.galacticbook.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.galacticbook.domain.CharacterState
import com.example.galacticbook.domain.GalacticViewModel
import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.model.Location
import com.example.galacticbook.model.Origin
import com.example.galacticbook.presentation.ui.components.CharacterDetailsShimmerScreen
import com.example.galacticbook.presentation.ui.components.LoadingShimmerEffect

typealias CharacterId = Int

@Composable
fun CharacterDetailsScreen(
    modifier: Modifier,
    id: CharacterId,
    viewModel: GalacticViewModel,
    onBack: () -> Unit = {}
) {

    LaunchedEffect(key1 = true) {
        viewModel.alienDetails(id)
    }
    when (val state = viewModel.characterState) {
        is CharacterState.Content -> {
            val character = state.content
            Scaffold { innerpadding ->
                val innerPadding = innerpadding
                Column {
                    SubcomposeAsyncImage(
                        model = character.image,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clip(
                                RoundedCornerShape(12.dp)
                            ),
                        loading = {
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.primary, // You can set the color here
                                strokeWidth = 4.dp // Adjust the thickness of the indicator
                            )
                        }
                    )
                    DetailsRow(details = Details(title = "Status", value = character.status))
                    DetailsRow(details = Details(title = "Name", value = character.name))
                    DetailsRow(details = Details(title = "Species", value = character.species))
                    if (character.type?.isNotBlank() == true) DetailsRow(
                        details = Details(
                            title = "type",
                            value = character.type ?: "-"
                        )
                    )
                    DetailsRow(details = Details(title = "Gender", value = character.gender))
                }
            }
        }

        is CharacterState.Error -> {

        }

        CharacterState.Loading -> {
            LoadingShimmerEffect(
                layout = { brush ->
                    CharacterDetailsShimmerScreen(brush)
                })
        }
    }
}


@Composable
fun DetailsRow(
    modifier: Modifier = Modifier,
    details: Details
) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${details.title}: ",
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary

        )

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = details.value,
            fontStyle = FontStyle.Normal,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )

    }
}

@Preview
@Composable
fun DetailsRowPreview() {
    DetailsRow(details = Details("Species", "Alien"))
}

data class Details(
    val title: String,
    val value: String
)

@Preview
@Composable
fun CharacterDetailsPreview(
    modifier: Modifier = Modifier,
    character: CharacterDetails = CharacterDetails(
        id = 62,
        name = "Canklanker Thom",
        status = "Dead",
        species = "Alien",
        type = "Gromflomite",
        gender = "Male",
        origin = Origin(
            name = "Gromflom Prime",
            url = "https://rickandmortyapi.com/api/location/19"
        ),
        location = Location(name = "unknown", url = ""),
        image = "https://rickandmortyapi.com/api/character/avatar/62.jpeg",
        episode = listOf(
            "https://rickandmortyapi.com/api/episode/1"
        ),
        url = "https://rickandmortyapi.com/api/character/62",
        created = "2017-11-05T12:06:23.217Z"
    )
) {
//    CharacterDetailsScreen(modifier = modifier, character)
}

