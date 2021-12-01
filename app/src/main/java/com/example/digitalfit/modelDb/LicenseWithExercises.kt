package com.example.digitalfit.modelDb

import androidx.room.Embedded
import androidx.room.Relation


data class LicenseWithExercises(

    @Embedded val license: LicenseDb,
    @Relation(
        parentColumn = "licenseId",
        entityColumn = "licenseId"
    )
    val exercise: List<ExerciseDb>
)
