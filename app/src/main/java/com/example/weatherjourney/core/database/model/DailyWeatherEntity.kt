package com.example.weatherjourney.core.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.weatherjourney.core.database.util.FloatListHolder
import com.example.weatherjourney.core.database.util.IntListHolder
import com.example.weatherjourney.core.database.util.LongListHolder

@Entity(
    tableName = "daily_weather",
    foreignKeys = [ForeignKey(
        entity = LocationEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("locationId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class DailyWeatherEntity(
    var time: LongListHolder,
    var weatherCodes: IntListHolder,
    var maxTemperatures: FloatListHolder,
    var minTemperatures: FloatListHolder,
    @PrimaryKey
    val locationId: Long
)
