package com.greimul.copy2message.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history_db")
    fun getAll():LiveData<List<History>>

    @Query("DELETE FROM history_db")
    suspend fun deleteAll()

    @Insert
    suspend fun insert(history:History)
}