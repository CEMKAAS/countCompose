package com.hfad.mycountcompose.data

import android.content.Context
import androidx.room.Room

class Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "myConts.db")
            .build()
    }
}