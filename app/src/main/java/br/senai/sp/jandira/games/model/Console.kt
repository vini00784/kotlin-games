package br.senai.sp.jandira.games.model

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

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
    var consoleImage: Drawable? = null

    @ColumnInfo(name = "console_release_date")
    var releaseDate: Int? = null
}