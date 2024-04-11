package com.hfad.mycountcompose.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConstantaDao {
    @Insert
    suspend fun insertConstantaData(constanta: Constanta)

    @Query("DELETE FROM List WHERE id = :id")
    fun deleteStatisticDataById(id: Long)
}