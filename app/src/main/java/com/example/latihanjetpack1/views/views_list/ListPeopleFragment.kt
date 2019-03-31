package com.example.latihanjetpack1.views.views_list

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.latihanjetpack1.R
import com.example.latihanjetpack1.StartApp
import com.example.latihanjetpack1.data.data_model.People
import com.example.latihanjetpack1.views.views_add.AddPeopleAdapter
import kotlinx.android.synthetic.main.fragmet_for_list_people.*

class ListPeopleFragment : Fragment(), ListPeopleAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragmet_for_list_people, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
//            Toast.makeText(activity.applicationContext, "Test Click FAB", Toast.LENGTH_SHORT).show()
            val intent = Intent(activity.applicationContext, AddPeopleAdapter::class.java)
            startActivity(intent)
        }
    }

    override fun onItemClick(people: People, itemView: View) {
        Toast.makeText(activity.applicationContext, "Test Click Contact List", Toast.LENGTH_SHORT).show()
    }

    private fun  populatePeopleList(peopleList : List<People>){
        peopleRecyclerView.adapter = ListPeopleAdapter(peopleList, this)
    }

    override fun onResume() {
        super.onResume()
        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeople()
        populatePeopleList(people)
    }

}