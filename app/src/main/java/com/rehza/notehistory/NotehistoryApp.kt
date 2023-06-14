package com.rehza.notehistory

import android.app.Application
import androidx.room.Room
import com.rehza.notehistory.data.HistoryDao
import com.rehza.notehistory.data.HistoryDatabase
import com.rehza.notehistory.util.Constants

class NotehistoryApp : Application()  {
    private var db: HistoryDatabase? = null

    companion object {
        private var instance: NotehistoryApp? = null

        fun getDao(): HistoryDao {
            return instance?.getDb()?.HistoryDao()
                ?: throw IllegalStateException("Note history App instance is not initialized")
        }

        fun getInstance(): NotehistoryApp {
            return instance ?: throw IllegalStateException("Note history App instance is not initialized")
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getDb(): HistoryDatabase {
        return db ?: synchronized(this) {
            db ?: Room.databaseBuilder(
                applicationContext,
                HistoryDatabase::class.java,
                Constants.DATABASE_NAME
            ).fallbackToDestructiveMigration() // remove in prod
                .build().also { db = it }
        }
    }
}