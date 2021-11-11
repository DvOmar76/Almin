package com.example.almin.DBRoom

import androidx.room.*

@Dao
interface ShowDao {
    @Query("select * from show order by id ASC")
    fun getAll():List<Shows>
    @Insert
    fun addShow(shows: Shows)
    @Delete
    fun deleteShow(shows: Shows)

}