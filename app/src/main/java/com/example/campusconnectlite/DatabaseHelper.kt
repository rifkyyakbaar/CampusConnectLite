package com.example.campusconnectlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "CampusConnect.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "events"
        private const val COL_ID = "id"
        private const val COL_NAME = "name"
        private const val COL_DESC = "description"
        private const val COL_LOCATION = "location"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COL_NAME TEXT, "
                + "$COL_DESC TEXT, "
                + "$COL_LOCATION TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertEvent(event: EventModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, event.name)
        contentValues.put(COL_DESC, event.description)
        contentValues.put(COL_LOCATION, event.location)

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success
    }

    fun getAllEvents(): ArrayList<EventModel> {
        val eventList = ArrayList<EventModel>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var desc: String
        var location: String

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID))
                name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME))
                desc = cursor.getString(cursor.getColumnIndexOrThrow(COL_DESC))
                location = cursor.getString(cursor.getColumnIndexOrThrow(COL_LOCATION))
                val event = EventModel(id = id, name = name, description = desc, location = location)
                eventList.add(event)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return eventList
    }
    fun deleteEvent(id: Int): Boolean {
        val db = this.writableDatabase
        val success = db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(id.toString()))
        db.close()
        return success > 0
    }

}