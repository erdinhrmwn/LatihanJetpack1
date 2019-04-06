package com.example.latihanjetpack1.views.views_add

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.latihanjetpack1.StartApp
import com.example.latihanjetpack1.data.data_model.People

class AddPeopleModel(application: Application) : AndroidViewModel(application) {
    private val peopleRepository = getApplication<StartApp>().getPeopleRepo()

    fun addPeople(people: People) {
        peopleRepository.insertPeople(people)
    }
}