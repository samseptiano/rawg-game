package com.example.rawg.data.roomModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteGame")
data class RoomGameDetail(

    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var slug: String,
    var name: String,
    var released: String,
    var background_image: String,
    var originalName: String,
    var description: String,
    var website: String,
    var rating: String,
    var playtime: String,
)