package com.example.latihanjetpack1.views.views_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihanjetpack1.R
import com.example.latihanjetpack1.data.data_model.People
import kotlinx.android.synthetic.main.fragment_details_people.*

class DetailsPeopleFragment : Fragment() {
    private lateinit var viewModel: DetailsPeopleModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailsPeopleModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val peopleId = activity?.intent?.getIntExtra(getString(R.string.people_id), 0)
        val peopleId = arguments?.getInt(getString(R.string.people_id))
        peopleId?.let {
            viewModel.getPeopleDetails(peopleId).observe(this, Observer { peopleDetails ->
                populatePeopleDetails(peopleDetails)
            })
        }
    }

    private fun populatePeopleDetails(people: People?) {
        textViewName.text = people?.name
        textViewMeetAt.text = people?.meetAt
        buttonContact.text = people?.contact
        textViewEmail.text = people?.email
        textViewFacebook.text = people?.facebook
        textViewTwitter.text = people?.twitter
    }
}