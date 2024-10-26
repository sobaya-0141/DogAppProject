
package com.example.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun DogListScreen(viewModel: DogListViewModel, onDogClicked: (String) -> Unit) {
    val dogBreeds = viewModel.dogBreeds

    LazyColumn {
        items(dogBreeds) { dogImage ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onDogClicked(dogImage) },
                shape = RoundedCornerShape(16.dp),
                elevation = 4.dp
            ) {
                AsyncImage(
                    model = dogImage,
                    contentDescription = "Dog Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }
    }
}
    