package com.example.digitalfit.modelApi

import androidx.recyclerview.widget.DiffUtil
import com.example.digitalfit.modelDb.ExerciseDb
import com.example.digitalfit.modelDb.ExerciseWithImages
import com.example.digitalfit.modelDb.ImageDb


data class ResultInfo(
    val id: Int,
    val category: Category,
    val comments: List<Comment>,
    val creation_date: String,
    var description: String,
    val equipment: List<Equipment>,
    val images: List<Image>,
    val language: Language,
    val license: License,
    val license_author: String,
    val muscles: List<Muscle>,
    val muscles_secondary: List<Muscle>,
    val name: String,
    val uuid: String
) {
    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<ResultInfo> =
            object : DiffUtil.ItemCallback<ResultInfo>() {
                override fun areItemsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }
}

fun ResultInfo.toExerciseDb(): ExerciseDb {
    return ExerciseDb(
        exerciseId = this.id,
        //ForeignKey
        categoryId = this.category.id,
        creation_date = this.creation_date,
        description = this.description,
        //ForeignKey
        languageId = this.language.id,
        //ForeignKey
        licenseId = this.license.id,
        license_author = this.license_author,
        name = this.name,
        uuid = this.uuid
    )
}

fun ResultInfo.toExerciseWithImages(): ExerciseWithImages {
    val imageList: MutableList<ImageDb> = mutableListOf()
    this.images.forEach {
        imageList.add(it.toImageDb(this.id))
    }

    return ExerciseWithImages(
        exercise = this.toExerciseDb(),
        //ForeignKey
        image = imageList
    )
}

