package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.database.AppDb
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game

class ConsoleRepository(context: Context) {

    private val db = AppDb.getDataBase(context).consoleDao()

    fun save(console: Console): Long {
        return db.save(console)
    }

    fun delete(console: Console): Int {
        return db.delete(console)
    }

    fun update(console: Console): Int {
        return db.update(console)
    }

    fun getAll(): List<Console> {
        return db.getAll()
    }

    fun getConsoleByName(consoleName: String): Console {
        return db.getConsoleByName(consoleName)
    }
}