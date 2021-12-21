package com.example.turistic20.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpotsItem(
    @SerializedName("direccion")
    val direccion: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("temp")
    val temp: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable