package com.fornary4.kt.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fornary4.kt.entity.Book

@Dao
interface BookDao {
    @Insert
    fun insertBook(book: Book): Long

    @Query("select * from Book")
    fun loadAllBooks(): List<Book>
}