package com.e.appbudgetcalculatorv2.room.budget

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BudgetEntity(
    @PrimaryKey var id: Int,
    var listName: List<String>,
    var listPercent: List<String>
)