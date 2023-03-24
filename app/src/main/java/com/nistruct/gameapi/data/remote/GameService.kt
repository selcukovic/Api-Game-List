package com.nistruct.gameapi.data.remote

import com.nistruct.gameapi.data.model.GameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameService @Inject constructor(private val gameApi : GameApi) {

    suspend fun getGames(): List<GameModel>{
        return withContext(Dispatchers.IO){
            val games = gameApi.getGames()
            games.body() ?: emptyList()
        }
    }
}