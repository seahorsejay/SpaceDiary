package com.example.galacticbook.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.galacticbook.R
import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.model.Location
import com.example.galacticbook.model.Origin

@Composable
fun CharacterDetailsScreen(
    modifier: Modifier,
    character: CharacterDetails
) {
    Scaffold { paddingValues ->
        val padding = paddingValues
        Column {
            Image(
                painter = rememberAsyncImagePainter(
                    model = character.url
                ),
                contentDescription = "character image",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(4.dp, Color.Blue),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = "Name:")
                Text(text = character.name)
            }

        }
    }

}

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
    CharacterDetailsScreen(modifier = modifier, character)
}

