package com.example.turistic20.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turistic20.R
import com.example.turistic20.databinding.FragmentListBinding
import com.example.turistic20.model.Spots
import com.example.turistic20.model.SpotsItem
import com.google.gson.Gson


class ListFragment : Fragment() {


    private lateinit var listBinding: FragmentListBinding
    private lateinit var spotsAdapter: SpotsAdapter
    private lateinit var listSpots: ArrayList<SpotsItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listSpots = loadMockSpotsFromJson()
        spotsAdapter = SpotsAdapter(listSpots, onItemClicked = {onSpotsClicked(it)})

        listBinding.spotsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = spotsAdapter
            setHasFixedSize(false)

            }}

    private fun onSpotsClicked(spots: SpotsItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(spot = spots))
        //findNavController().navigate(ListFragmentDirections.actionNavigationListToSettingsFragment())


    }


    private fun loadMockSpotsFromJson(): ArrayList<SpotsItem> {
        val spotsString: String =
            context?.assets?.open("spots.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val spotsList = gson.fromJson(spotsString, Spots::class.java)
        return spotsList
    }



}