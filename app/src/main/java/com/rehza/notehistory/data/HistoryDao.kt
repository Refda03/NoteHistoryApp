package com.rehza.notehistory.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rehza.notehistory.model.History

@Dao
interface HistoryDao {
    @Query("SELECT * FROM stories WHERE stories.id=:id")
    suspend fun getStoryById(id: Int): History?

    @Query("SELECT * FROM stories ORDER BY dateUpdated DESC")
    fun getStories(): LiveData<List<History>>

    @Delete
    fun deleteStory(story: History): Int

    @Insert
    fun addStory(story: History)
}