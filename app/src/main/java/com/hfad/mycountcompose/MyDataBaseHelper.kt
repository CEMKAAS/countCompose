package com.hfad.mycountcompose

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.util.Calendar
import android.util.Log

class MyDataBaseHelper (context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(
    context,
    name, factory, version
) {

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL(myConstanta.TABLE_STRUCTURE_PROJECT)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        Log.w(
            MyDataBaseHelper::class.java.name,
            "Upgrading database from version " + p1 + " to "
                    + p2 + ", which will destroy all old data"
        )
        p0?.execSQL("DROP TABLE IF EXISTS MyConstanta.DROP_TABLE_PROJECT")
        onCreate(p0)
    }

    fun lastReadProject(): Cursor {
        val query = "SELECT * FROM $tableName Where $lastCount =?"
        val db: SQLiteDatabase = this.readableDatabase
        return db.rawQuery(query, arrayOf("1"))
    }

    fun insertToDB(titleIn: String, countIn: Int, stepIn: Int, lastCountIn: Int, timeIn: String) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(title, titleIn)
        cv.put(count, countIn)
        cv.put(step, stepIn)
        cv.put(lastCount, lastCountIn)
        cv.put(time, timeIn)
        db.insert(tableName, null, cv)
    }

    fun updateToCount(idCountIn: Int, countIn: Int, lastCountIn: Int){
        val db = this.writableDatabase
        val cv = ContentValues()

        val calendar = Calendar.getInstance()
        val timeIn =
            calendar[Calendar.DAY_OF_MONTH].toString() + "." + (calendar[Calendar.MONTH] + 1) + "." + calendar[Calendar.YEAR]

        cv.put(count, countIn)
        cv.put(lastCount, lastCountIn)
        cv.put(time, timeIn)

        var id = db.update(tableName,cv,"id=?", arrayOf(idCountIn.toString()))

    }

    companion object {
        val myConstanta = MyConstanta()
        private val name = myConstanta.DB_NAME
        private val version = myConstanta.DB_VERSION
        val tableName = myConstanta.TABLE_NAME
        val lastCount = myConstanta.LASTCOUNT
        val title = myConstanta.TITLE
        val count = myConstanta.COUNT
        val step = myConstanta.STEP
        val time = myConstanta.TIME
    }

}