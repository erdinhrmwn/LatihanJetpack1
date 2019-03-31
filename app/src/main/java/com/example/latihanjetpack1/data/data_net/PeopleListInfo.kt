package com.example.latihanjetpack1.data.data_net

import com.example.latihanjetpack1.data.data_model.People

class PeopleListInfo {
    companion object {
        var peopleList = initPeopleList()

        /**
         * add dummy data
         */
        private fun initPeopleList(): MutableList<People> {
            var po_peoples = mutableListOf<People>()
            po_peoples.add(People(
                "Erdin 1",
                "Tangerang",
                "089609760798",
                "erdinhermawann@gmail.com",
                "fb.me/erdinhrmwn",
                "twitter.com/erdinhrmwn",
                1
            ))
            po_peoples.add(People(
                "Erdin 2",
                "Tangerang",
                "089609760798",
                "erdinhermawann@gmail.com",
                "fb.me/erdinhrmwn",
                "twitter.com/erdinhrmwn",
                2
            ))
            po_peoples.add(People(
                "Erdin 3",
                "Tangerang",
                "089609760798",
                "erdinhermawann@gmail.com",
                "fb.me/erdinhrmwn",
                "twitter.com/erdinhrmwn",
                3
            ))
            return po_peoples
        }
    }
}