package com.example.galacticbook.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.galacticbook.model.CharacterDetails
import com.example.galacticbook.presentation.ui.Details
import com.example.galacticbook.presentation.ui.DetailsRow

@Composable
fun CharacterCard(
    character: CharacterDetails,
    onCharacterClick: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .fillMaxWidth()
            .clickable {
                onCharacterClick(character.id)
            },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SubcomposeAsyncImage(
                model = character.image,
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .size(120.dp)
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

            Column {
                Details(
                    details = Details(
                        title = "Status",
                        value = character.status
                    )
                )
                Details(
                    details = Details(
                        title = "Name",
                        value = character.name
                    )
                )
                Details(
                    details = Details(
                        title = "Species",
                        value = character.species
                    )
                )
                Details(
                    details = Details(
                        title = "Gender",
                        value = character.gender
                    )
                )


            }
            Spacer(modifier = Modifier.weight(1f))
            Image(imageVector = Icons.Filled.MoreVert,
                modifier = Modifier.padding(end = 8.dp).size(24.dp),
                contentDescription = "More")
        }
    }
}

@Composable
fun Details(
    modifier: Modifier = Modifier,
    details: Details
) {
    Row(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${details.title}: ",
            fontStyle = FontStyle.Normal,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary

        )

        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = details.value,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary
        )

    }
}