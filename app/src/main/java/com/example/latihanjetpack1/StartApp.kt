package com.example.latihanjetpack1

import android.app.Application
import com.example.latihanjetpack1.data.ContactRepo

class StartApp : Application() {
    fun getPeopleRepo()= ContactRepo(this)
}