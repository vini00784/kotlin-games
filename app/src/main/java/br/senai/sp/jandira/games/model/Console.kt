package br.senai.sp.jandira.games.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_console")
class Console {
    @PrimaryKey(autoGenerate = true)
    var code = 0

    @ColumnInfo(name = "console_name")
    var consoleName = ""

    @ColumnInfo(name = "console_producer")
    var consoleProducer = ""

    @ColumnInfo(name = "console_description")
    var consoleDescription = ""

    @ColumnInfo(name = "console_image")
    var consoleImage: Bitmap? = null

    @ColumnInfo(name = "console_release_date")
    var releaseDate = 0
}