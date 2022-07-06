package com.fornary4.kt.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper(val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {



    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table Book(id integer primary key autoincrement, author text, price real, pages integer, name text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}