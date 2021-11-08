package com.example.olimpia.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.olimpia.data.db.PlayerEntity
import com.example.olimpia.data.db.RoomAppDb

class MainActivityViewModel(app: Application): AndroidViewModel(app) {
    lateinit var allplayers : MutableLiveData<List<PlayerEntity>>

    init {
        allplayers = MutableLiveData()
        getAllplayers()

    }

    fun getAllPlayersObservers():MutableLiveData<List<PlayerEntity>> {
        return allplayers
    }

    private fun getAllplayers() {
        val playerDao = RoomAppDb.getAppDatabase((getApplication()))?.playerDao()
        val list = playerDao?.getAllPlayersInfo()

        allplayers.postValue(list)
    }

    fun insertPlayerInfo (entity: PlayerEntity) {

       val playerDao = RoomAppDb.getAppDatabase(getApplication())?.playerDao()
        playerDao?.insertPlayer(entity)
        getAllplayers()
    }

    fun updatePlayerInfo (entity: PlayerEntity) {

        val playerDao = RoomAppDb.getAppDatabase(getApplication())?.playerDao()
        playerDao?.updatePlayer(entity)
        getAllplayers()

    }

    fun deletePlayerInfo (entity: PlayerEntity) {

       val playerDao = RoomAppDb.getAppDatabase(getApplication())?.playerDao()
        playerDao?.deletePlayer(entity)
        getAllplayers()
    }

}