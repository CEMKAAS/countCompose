package com.hfad.mycountcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(
    version = 1,
    entities = [
        Constanta::class
    ]
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getConstantaDao(): ConstantaDao
}