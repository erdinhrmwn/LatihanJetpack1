package com.example.latihanjetpack1.data

import android.app.Application
import com.example.latihanjetpack1.data.data_model.People
import com.example.latihanjetpack1.data.data_net.PeopleListInfo

class ContactRepo(application: Application) {
    fun getAllPeople() : List<People>{
        return PeopleListInfo.peopleList
    }

    fun insertPeople(people: People) {
        PeopleListInfo.peopleList.add(people)
    }

    fun findPeople(id: Int): People?{
        for (people in PeopleListInfo.peopleList){
            if (people.id == id){
                return people
            }
        }
        return null
    }
}