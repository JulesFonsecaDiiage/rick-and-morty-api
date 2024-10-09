package org.mathieu.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mathieu.domain.models.location.Location
import org.mathieu.domain.models.location.LocationBase
import org.mathieu.domain.models.location.LocationPreview

@Composable
fun LocationCard(
    location: LocationBase,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name : " + location.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Type : " + location.type)

            if (location is Location) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Dimension : " + location.dimension)

                if (location.residents.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Residents :")
                    location.residents.forEach {
                        CharacterCard(
                            character = it,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}



@Preview
@Composable
private fun LocationCardPreview() = PreviewContent {
    LocationCard(location = LocationPreview(
        id = 0,
        name = "Earth",
        type = "Planet",
        dimension = "Dimension C-137",
    ))
}