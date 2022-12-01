package br.senai.sp.jandira.games.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.dao.console.ConsoleDao
import br.senai.sp.jandira.games.dao.game.GameDao
import br.senai.sp.jandira.games.dao.user.UserDao
import br.senai.sp.jandira.games.model.Console
import br.senai.sp.jandira.games.model.Game
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.repository.ConsoleRepository

@Database(entities = [User::class, Game::class, Console::class], version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun consoleDao(): ConsoleDao
    abstract fun gameDao(): GameDao

    companion object {

        private lateinit var instance: AppDb
        private fun createConsoles(context: Context) {

            var console1 = Console()
            var console2 = Console()
            var console3 = Console()

            console1.consoleName = "PS5"
            console1.consoleProducer = "Sony"
            console1.consoleDescription = "Last sony console"
            console1.consoleReleaseDate = 2021


            console2.consoleName = "Xbox Series X"
            console2.consoleProducer = "Microsoft"
            console2.consoleDescription = "Last Microsoft console"
            console2.consoleReleaseDate = 2021

            console3.consoleName = "Nintendo Switch"
            console3.consoleProducer = "Nintendo"
            console3.consoleDescription = "Last Nintendo console"
            console3.consoleReleaseDate = 2021

            ConsoleRepository(context).save(console1)
            ConsoleRepository(context).save(console2)
            ConsoleRepository(context).save(console3)

        }

        fun getDataBase(context: Context): AppDb {
            if (!Companion::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(context, AppDb::class.java, "db_app")
                    .allowMainThreadQueries().build()
                if (ConsoleRepository(context).getAll().isEmpty())
                    createConsoles(context)
            }
            return instance
        }
    }
}