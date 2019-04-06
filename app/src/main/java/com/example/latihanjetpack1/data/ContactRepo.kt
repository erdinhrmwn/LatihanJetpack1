package com.example.latihanjetpack1.data

import android.app.Application
import android.arch.lifecycle.LiveData
import com.example.latihanjetpack1.data.data_model.People
import com.example.latihanjetpack1.data.db_only.PeopleDAO
import com.example.latihanjetpack1.data.db_only.PeopleDb

class ContactRepo(application: Application) {

    private val peopleDAO: PeopleDAO

    init {
        val peopleDatabase = PeopleDb.getInstance(application)
        peopleDAO = peopleDatabase.peopleDao()
    }

    fun getAllPeople(): LiveData<List<People>> {
//        return PeopleListInfo.peopleList
        return peopleDAO.getAll()
    }

    fun insertPeople(people: People) {
//        PeopleListInfo.peopleList.add(people)
        return peopleDAO.insert(people)
    }

    fun findPeople(id: Int): LiveData<People> {
//        for (people in PeopleListInfo.peopleList) {
//            if (people.id == id) {
//                return people
//            }
//        }
//        return null
        return peopleDAO.find(id)
    }
}