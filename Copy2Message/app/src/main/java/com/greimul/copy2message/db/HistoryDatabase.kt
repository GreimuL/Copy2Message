package com.greimul.copy2message.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(History::class),version = 1)
abstract class HistoryDatabase:RoomDatabase() {
    abstract fun historyDao():HistoryDao

    companion object{
        @Volatile
        private var INSTANCE:HistoryDatabase? = null

        fun getDatabase(context: Context):HistoryDatabase{
            val tempInst = INSTANCE
            if(tempInst!=null)
                return tempInst
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HistoryDatabase::class.java,
                    "history_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}