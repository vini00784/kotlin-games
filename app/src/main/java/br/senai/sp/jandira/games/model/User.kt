package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_user")
class User {

    @PrimaryKey(autoGenerate = true)
    var code = 0

    @ColumnInfo(name = "user_name")
    var userName = ""

    var gender: Char = 'U'

    @ColumnInfo(name = "user_city")
    var userCity = ""

    @ColumnInfo(name = "user_email")
    var userEmail = ""

    @ColumnInfo(name = "user_password")
    var userPassword = ""

//    @ColumnInfo(name = "birth_date")
//    var birthDate: LocalDate? = null

//    @ColumnInfo(name = "user_image")
//    var userImage: Bitmap? = null

//    var console: Console? = null

    @ColumnInfo(name = "user_level")
    var userLevel = LevelsEnum.BEGGINER
}