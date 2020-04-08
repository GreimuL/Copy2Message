package com.greimul.copy2message.db

import androidx.lifecycle.LiveData

class HistoryRepo(private val historyDao: HistoryDao) {
    val historyList:LiveData<List<History>> = historyDao.getAll()

    suspend fun insert(history: History){
        historyDao.insert(history)
    }

    suspend fun delete(){
        historyDao.deleteAll()
    }
}