package br.senai.sp.jandira.games.dao

import android.content.Context
import br.senai.sp.jandira.games.R
import br.senai.sp.jandira.games.model.Game

class GamesDao {

    companion object {

        fun getGames(context: Context): List<Game> {

            val game1 = Game()
            game1.code = 1
            game1.gameName = "Street Fighter"
            game1.developer = "Capcom"
            game1.description = "Street Fighter, popularmente abreviado para SF, é uma popular série de jogos de luta."
            game1.image = context.getDrawable(R.drawable.street_fighter)

            val game2 = Game()
            game2.code = 2
            game2.gameName = "Ninja Turtles II"
            game2.developer = "Konami"
            game2.description = "Teenage Mutant Ninja Turtles: Shredder's Revenge é um jogo eletrônico beat 'em up desenvolvido pela Tribute Games."
            game2.image = context.getDrawable(R.drawable.ninja_turtles)

            val game3 = Game()
            game3.code = 3
            game3.gameName = "FIFA 23"
            game3.developer = "EA Sports"
            game3.description = "FIFA 23 traz o maior jogo do mundo aos gramados com a tecnologia HyperMotion2, entregando ainda mais realismo nas partidas, a FIFA World Cup™ masculina e feminina, a inclusão de clubes femininos, recursos de crossplay e muito mais."
            game3.image = context.getDrawable(R.drawable.fifa)

            val gamesList = listOf<Game>(game1, game2, game3)

            return gamesList
        }

    }

}