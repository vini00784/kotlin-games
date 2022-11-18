package br.senai.sp.jandira.games.dao.console

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.Console

@Database(entities = [Console::class], version = 1)
abstract class ConsoleDb: RoomDatabase() {

    abstract fun consoleDao(): ConsoleDao

    companion object {

        private lateinit var instance: ConsoleDb

        fun getDataBase(context: Context): ConsoleDb {
            if(!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(context, ConsoleDb::class.java, "db_agenda")
                    .allowMainThreadQueries().build()
            }
            return instance
        }

    }
}