package com.example.latihanjetpack1.views.views_list

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import com.example.latihanjetpack1.StartApp
import com.example.latihanjetpack1.data.data_model.People

class ListPeopleModel(application: Application) : AndroidViewModel(application) {
    private val peopleRepo = getApplication<StartApp>().getPeopleRepo()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList(): LiveData<List<People>> {
        return peopleList
    }

    private fun getAllPeople() {
        peopleList.addSource(peopleRepo.getAllPeople()) { peoples ->
            peopleList.postValue(peoples)
        }
    }
}