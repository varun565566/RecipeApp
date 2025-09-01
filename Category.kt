package eu.tutorials.jsonbasicelogic

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize

data class Category( val idcategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String):Parcelable


data class Categorieslist(val categories: List<Category>)
