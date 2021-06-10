package com.e.appbudgetcalculatorv2.room.widget

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WidgetEntity (
    @PrimaryKey val id: Int,
     val listName : List<String>,
    val listPercent : List<String>,
    val listPeriod : List<String>,
    val listTime : List<String>
)