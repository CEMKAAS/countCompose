package com.hfad.mycountcompose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(
    version = 1,
    entities = [
        Constanta::class
    ], exportSchema = false
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun getConstantaDao(): ConstantaDao

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "item_database")
                .build()
                .also { Instance = it }}
        }
    }
}