package com.rehza.notehistory.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rehza.notehistory.model.History


@Database(
    entities = [
    History::class], version = 1
)
abstract class HistoryDatabase : RoomDatabase() {
    abstract fun HistoryDao(): HistoryDao
}