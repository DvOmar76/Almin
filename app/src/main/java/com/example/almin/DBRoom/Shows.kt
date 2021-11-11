package com.example.almin.DBRoom
import androidx.room.*
@Entity(tableName = "Show")
data class Shows(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id")  val id:Int,
    @ColumnInfo(name="name") val name:String,
    @ColumnInfo(name="language") val language:String,
    @ColumnInfo(name="summary") val summary:String,
    @ColumnInfo(name="imageUrl") val imageUrl:String ="no Image"
)
