package com.e.appbudgetcalculatorv2.room.budget

import androidx.room.*
import com.e.appbudgetcalculatorv2.room.widget.WidgetDao
import com.e.appbudgetcalculatorv2.room.widget.WidgetEntity

@Dao
interface BudgetDao {

    @Insert
    fun insertBudget(budgetEntity: BudgetEntity)

    @Update
    fun updateBudget(budgetEntity: BudgetEntity)

    @Query("SELECT * FROM budgetEntity")
    fun getAllBudget() : List<BudgetEntity>

    @Delete
    fun deleteBudget(budgetEntity: BudgetEntity)

    @Query("SELECT * FROM BudgetEntity WHERE id = :id")
    fun getBudgetById(id : Int) : BudgetEntity
}