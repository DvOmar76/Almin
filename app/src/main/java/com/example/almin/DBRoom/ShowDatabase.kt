package com.example.almin.DBRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Shows::class],version = 1,exportSchema = false)
abstract class ShowDatabase:RoomDatabase() {
    companion object{
        var instance:ShowDatabase?=null
        fun getInstance(context: Context):ShowDatabase
        {
            if(instance!=null)
            {
                return instance as ShowDatabase
            }
            instance= Room.databaseBuilder(context,ShowDatabase::class.java,"Show").run { allowMainThreadQueries()}.build()
            return instance as ShowDatabase
        }
    }
    abstract fun ShowDao():ShowDao

}