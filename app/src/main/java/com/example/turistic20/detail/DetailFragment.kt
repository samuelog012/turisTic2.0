package com.example.turistic20.detail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.navigation.fragment.navArgs
import com.example.turistic20.databinding.FragmentBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {


    private lateinit var detailBinding: FragmentBinding
    private val args: DetailFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        detailBinding = FragmentBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spots = args.spot


    with(detailBinding){
        nameTextView.text = spots.name
        direccionTextView.text = spots.direccion
        cityTextView.text = spots.city
        tempTextView.text = spots.temp
        //heightTextView.text = spots.height.toString()
        //facebookTextView.text = spots.facebook
        descripcionTextView.text = spots.descripcion
        Picasso.get().load(spots.urlPicture).into(pictureImageView)



    //     .into(pictureImageView)
        //spots.urlPicture
    }}


}