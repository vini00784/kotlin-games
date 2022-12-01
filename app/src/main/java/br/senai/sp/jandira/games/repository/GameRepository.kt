package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.database.AppDb
import br.senai.sp.jandira.games.model.Game

class GameRepository(context: Context) {

    private val db = AppDb.getDataBase(context).gameDao()

    fun save(game: Game): Long {
        return db.save(game)
    }

    fun delete(game: Game): Int {
        return db.delete(game)
    }

    fun update(game: Game): Int {
        return db.update(game)
    }

    fun getAll(): List<Game> {
        return db.getAll()
    }

    fun getUserById(id: Int): Game {
        return db.getGameById(id)
    }
}