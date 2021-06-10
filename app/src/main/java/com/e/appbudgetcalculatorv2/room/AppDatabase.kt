package com.e.appbudgetcalculatorv2.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.e.appbudgetcalculatorv2.room.budget.BudgetDao
import com.e.appbudgetcalculatorv2.room.budget.BudgetEntity
import com.e.appbudgetcalculatorv2.room.widget.WidgetDao
import com.e.appbudgetcalculatorv2.room.widget.WidgetEntity

@Database(entities = [BudgetEntity::class, WidgetEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun budgetDao() : BudgetDao
    abstract fun widgetDao() : WidgetDao
}