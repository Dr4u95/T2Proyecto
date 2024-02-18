package es.iessaladillo.com.proyecto.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserCharacter(
    val name: String,
    val email: String? = null,
    val height:Int?=null,
    val weight:Int?=null,
    val homeWorld:String?=null,
    val affiliation:String?=null,
    val weapons:List<String>?=null,
    val gender: String?=null,
    val specie:String?=null,
    val age:Int?=null,
    val photo:String?=null,
    val quote:List<String>?=null,
) : Parcelable

