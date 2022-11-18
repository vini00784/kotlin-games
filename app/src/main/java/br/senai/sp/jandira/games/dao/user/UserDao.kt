package br.senai.sp.jandira.games.dao.user

import androidx.room.*
import br.senai.sp.jandira.games.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    @Delete
    fun delete(user: User): Int

    @Update
    fun update(user: User): Int

    @Query("SELECT * FROM tbl_user ORDER BY user_name ASC")
    fun getAll(): List<User>
}