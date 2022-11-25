package br.senai.sp.jandira.games.model

import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_game")
class Game {

    @PrimaryKey(autoGenerate = true)
    var code = 0

    @ColumnInfo(name = "game_name")
    var gameName = ""

    @ColumnInfo(name = "game_developer")
    var gameDeveloper = ""

    @ColumnInfo(name = "game_description")
    var gameDescription = ""

    @ColumnInfo(name = "game_release_date")
    var gameReleaseDate = 0

    @ColumnInfo(name = "game_status")
    var gameStatus = ""

//    @ColumnInfo(name = "game_image")
//    var gameImage: Bitmap? = null
}