package com.nistruct.gameapi.domain

import com.nistruct.gameapi.domain.Item.GameItem
import com.nistruct.gameapi.repo.GameRepository
import javax.inject.Inject


class GetGamesUseCase @Inject constructor(private val gameRepository : GameRepository) {

    suspend operator fun invoke() : List<GameItem>{
        return gameRepository.getGames().shuffled()
    }

}