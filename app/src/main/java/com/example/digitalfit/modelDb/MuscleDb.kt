package com.example.digitalfit.modelDb

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "muscle")
@Parcelize
data class MuscleDb(
    @PrimaryKey
    val muscleId: Int?,
    val image_url_main: String?,
    val image_url_secondary: String?,
    val is_front: Boolean?,
    val name: String?
):Parcelable{

}