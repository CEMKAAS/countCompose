package com.hfad.mycountcompose.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "List",
    indices = [Index("id")]
)
data class Constanta(

    @PrimaryKey(autoGenerate = true) val id: Int,

//    val title: String, // Название описание (название счетчика)

    val count: Int, // Кол-во

    val step: Int  // Шаг счетчика

//    val lastCost: Int, // Последний счетчик
//
//    val time: String // Последнее время изменения

)
