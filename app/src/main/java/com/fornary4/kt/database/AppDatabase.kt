package com.fornary4.kt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fornary4.kt.dao.BookDao
import com.fornary4.kt.dao.UserDao
import com.fornary4.kt.entity.Book
import com.fornary4.kt.entity.User

@Database(version = 1, entities = [User::class, Book::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao
    companion object {
        private var instance: AppDatabase? = null
        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                .build().apply {
                    instance = this
                }
        }
    }
}