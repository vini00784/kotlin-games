package br.senai.sp.jandira.games.dao.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.games.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDb: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private lateinit var instance: UserDb

        fun getDataBase(context: Context): UserDb {
            if(!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(context, UserDb::class.java, "db_user")
                    .allowMainThreadQueries().build()
            }
            return instance
        }
    }
}