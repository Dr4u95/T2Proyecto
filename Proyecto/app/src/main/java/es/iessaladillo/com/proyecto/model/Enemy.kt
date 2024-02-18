package es.iessaladillo.com.proyecto.model

data class Enemy(
    val name: String,
    val height:Int?=null,
    val weight:Int?=null,
    val homeWorld:String?=null,
    val affiliation:String?=null,
    val weapons:List<String>?=null,
    val gender: String?=null,
    val specie:String?=null,
    val age:Int?=null,
    val photo:String,
    val quote:List<String>?=null,
)