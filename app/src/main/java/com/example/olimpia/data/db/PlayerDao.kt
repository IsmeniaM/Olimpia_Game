package com.example.olimpia.data.db

import androidx.room.*


@Dao
interface PlayerDao {


    @Query("SELECT * FROM playerinfo ORDER BY id DESC")
    fun getAllPlayersInfo(): List<PlayerEntity>?

    @Insert
    fun insertPlayer (player: PlayerEntity?)


    @Delete
    fun deletePlayer (player: PlayerEntity?)

    @Update
    fun updatePlayer (player: PlayerEntity?)

}