package com.nistruct.gameapi.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.nistruct.gameapi.domain.Item.GameItem

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val games by viewModel.games.collectAsState()

    LazyColumn {
        items(games) { game: GameItem ->
            GameCard(game = game)
        }
    }
}

@Composable
fun GameCard(game: GameItem) {

    val img = rememberImagePainter(data = game.thumbnail)

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(10),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .fillMaxHeight()
    ) {
        Column {
            Image(
                painter = img, contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding()) {
                Text(text = game.title, fontWeight = FontWeight.Bold,)
                Text(text = game.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }

        }
    }
}
