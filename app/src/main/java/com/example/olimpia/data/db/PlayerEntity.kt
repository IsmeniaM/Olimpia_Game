package com.example.olimpia.data.db

import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "playerinfo")
data class PlayerEntity (

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0 ,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "score") val score: String



    )