package com.nistruct.gameapi.domain.Item

import com.nistruct.gameapi.data.model.GameModel

data class GameItem(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String
)

fun GameModel.toGameItem() = GameItem(id,title,thumbnail,short_description)

