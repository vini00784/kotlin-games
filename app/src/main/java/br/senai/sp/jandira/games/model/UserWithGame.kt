package br.senai.sp.jandira.games.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithGame(
    @Embedded val user: User,
    @Relation(
        parentColumn = "code",
        entityColumn = "userId"
    )
    val games: List<Game>
)
