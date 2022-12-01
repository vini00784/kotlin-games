package br.senai.sp.jandira.games.repository

import android.content.Context
import br.senai.sp.jandira.games.database.AppDb
import br.senai.sp.jandira.games.model.User
import br.senai.sp.jandira.games.model.UserWithGame

class UserRepository(context: Context) {

    private val db = AppDb.getDataBase(context).userDao()

    fun save(user: User): Long {
        return db.save(user)
    }

    fun delete(user: User): Int {
        return db.delete(user)
    }

    fun update(user: User): Int {
        return db.update(user)
    }

    fun getAll(): List<User> {
        return db.getAll()
    }

    fun getUserById(id: Int): User {
        return db.getUserById(id)
    }

    fun getUserByEmail(email: String): User {
        return db.getUserByEmail(email)
    }

    fun getUserGame(userId: Int): List<UserWithGame> {
        return db.getUserGame(userId)
    }
}