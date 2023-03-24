package com.nistruct.gameapi.data.remote

import com.nistruct.gameapi.data.model.GameModel
import com.nistruct.gameapi.utils.Constants.GAMES_END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface GameApi {

    @GET(GAMES_END_POINT)
    suspend fun getGames(): Response<List<GameModel>>


}