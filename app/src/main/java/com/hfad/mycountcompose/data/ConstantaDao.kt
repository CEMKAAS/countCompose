package com.hfad.mycountcompose.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConstantaDao {
    @Insert(entity = Constanta::class)
    fun insertConstantaData(constanta: Constanta)

    @Query("DELETE FROM List WHERE id = :id")
    fun deleteStatisticDataById(id: Long)
}