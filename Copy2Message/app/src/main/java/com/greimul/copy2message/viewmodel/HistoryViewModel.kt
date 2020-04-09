package com.greimul.copy2message.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.greimul.copy2message.db.History
import com.greimul.copy2message.db.HistoryDatabase
import com.greimul.copy2message.db.HistoryRepo
import kotlinx.coroutines.launch

class HistoryViewModel(application:Application):AndroidViewModel(application) {

    private val repo:HistoryRepo
    val historyList:LiveData<List<History>>

    init{
        repo = HistoryRepo(HistoryDatabase.getDatabase(application).historyDao())
        historyList = repo.historyList
    }

    fun insert(history:History) = viewModelScope.launch {
        repo.insert(history)
    }

    fun deleteAll()=viewModelScope.launch {
        repo.deleteAll()
    }


}