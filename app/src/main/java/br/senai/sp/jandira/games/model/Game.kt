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

    var developer = ""
    var description = ""
    var image: Drawable? = null
}