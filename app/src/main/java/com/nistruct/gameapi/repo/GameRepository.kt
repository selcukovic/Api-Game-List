package com.nistruct.gameapi.repo

import com.nistruct.gameapi.data.remote.GameService
import com.nistruct.gameapi.domain.Item.GameItem
import com.nistruct.gameapi.domain.Item.toGameItem
import javax.inject.Inject


class GameRepository @Inject constructor(private val gameService: GameService) {

    suspend fun getGames( ) : List<GameItem>{

        return gameService.getGames().map {
            it.toGameItem()
        }
    }
}