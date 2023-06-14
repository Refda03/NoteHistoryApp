package com.rehza.notehistory.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rehza.notehistory.data.HistoryDao
import com.rehza.notehistory.model.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val historyDao: HistoryDao,
) : ViewModel() {

    val history: LiveData<List<History>> = historyDao.getStories()


    fun deleteStory(history: History) {
        viewModelScope.launch(Dispatchers.IO){
            historyDao.deleteStory(history)
        }
    }

    fun addStory(title: String, note: String, image: String? = null) {
        viewModelScope.launch(Dispatchers.IO){
            historyDao.addStory(History(title = title, note = note, imageUri = image))
        }
    }

    fun addStoryDummy(history: History) {
        viewModelScope.launch(Dispatchers.IO){
            historyDao.addStory(history)
        }
    }

    suspend fun getStory(historyId : Int) : History? {
        return historyDao.getStoryById(historyId)
    }

}

class ViewModelFactory(
    private val db: HistoryDao,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  HistoryViewModel(
            historyDao = db,
        ) as T
    }

}