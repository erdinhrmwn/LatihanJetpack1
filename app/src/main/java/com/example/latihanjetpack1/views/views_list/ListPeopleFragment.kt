package com.example.latihanjetpack1.views.views_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanjetpack1.R
import com.example.latihanjetpack1.data.data_model.People
import com.example.latihanjetpack1.views.views_add.AddPeopleAdapter
import com.example.latihanjetpack1.views.views_details.DetailsPeopleAdapter
import kotlinx.android.synthetic.main.fragmet_for_list_people.*

class ListPeopleFragment : Fragment(), ListPeopleAdapter.OnItemClickListener {

    private lateinit var viewModel: ListPeopleModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListPeopleModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragmet_for_list_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
            val intent = Intent(context, AddPeopleAdapter::class.java)
            startActivity(intent)
        }

        viewModel.getPeopleList().observe(this, Observer<List<People>> { peoples ->
            peoples?.let { populatePeopleList(peoples) }
        })
    }

    override fun onItemClick(people: People, itemView: View) {
        val intent = Intent(context, DetailsPeopleAdapter::class.java)
        intent.putExtra(getString(R.string.people_id), people.id)
        startActivity(intent)
    }

    private fun populatePeopleList(peopleList: List<People>) {
        peopleRecyclerView.adapter = ListPeopleAdapter(peopleList, this)
    }

/*    override fun onResume() {
        super.onResume()
//        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeople()
//        populatePeopleList(people)

        val peopleRepo = (activity?.application as StartApp).getPeopleRepo()
        peopleRepo.getAllPeople().observe(this, Observer { peopleList ->
            populatePeopleList(peopleList!!)
        })
    }*/
}
