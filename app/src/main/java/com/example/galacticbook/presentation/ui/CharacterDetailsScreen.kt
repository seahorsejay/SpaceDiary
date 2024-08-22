package com.example.galacticbook.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
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
            SubcomposeAsyncImage(
                model = character.url,
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(
                        RoundedCornerShape(12.dp)
                    ),
                loading = {

                })
            DetailsRow(details = Details(title = "Status", value = character.status))
            DetailsRow(details = Details(title = "Name", value = character.name))
            DetailsRow(details = Details(title = "Species", value = character.species))
            DetailsRow(details = Details(title = "type", value = character.type ?: "-"))
            DetailsRow(details = Details(title = "Gender", value = character.gender))
        }
    }

}

@Composable
fun DetailsRow(
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
    CharacterDetailsScreen(modifier = modifier, character)
}

