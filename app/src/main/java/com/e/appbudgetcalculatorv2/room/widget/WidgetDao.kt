package com.e.appbudgetcalculatorv2.room.widget

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WidgetDao {

    @Insert
    fun insertWidget(widgetEntity: WidgetEntity)

    @Update
    fun updateWidget(widgetEntity: WidgetEntity)

    @Query("SELECT * FROM widgetEntity")
    fun getAllWidget() : List<WidgetEntity>
}