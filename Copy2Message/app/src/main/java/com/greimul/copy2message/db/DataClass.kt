package com.greimul.copy2message.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "history_db")
data class History(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "date") var date:Date,
    @ColumnInfo(name = "text") var text:String
)