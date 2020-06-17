package com.dev.hilt_demo.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
