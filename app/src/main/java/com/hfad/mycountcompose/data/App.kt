package com.hfad.mycountcompose.data
import android.app.Application


class App() : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
}