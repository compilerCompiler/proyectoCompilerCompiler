package com.upb.vlibrary

import androidx.room.Database
import androidx.room.RoomDatabase
import com.upb.vlibrary.databases.daos.ArticleDao

@Database(entities = [Books::class],version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun articleDao():ArticleDao
}