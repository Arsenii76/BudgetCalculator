package com.e.appbudgetcalculatorv2.arrays

import com.e.appbudgetcalculatorv2.R

class ArraysWidget {
    val period = arrayListOf("День", "Неделя", "Месяц")
    val time = arrayListOf(30,7,1)

    val colors = arrayListOf(R.drawable.back_widget_pink, R.drawable.back_widget_yellow, R.drawable.back_widget_blue,)

    var title = arrayListOf("Продукты", "Отдых", "Копим")
    var percentLess30000 = arrayListOf(50.00, 10.00, 0.00)
    var percentLess40000 = arrayListOf(39.74,11.28, 6.92)
    var percentLess50000 = arrayListOf(34.62, 11.92, 7.88)
    var percentLess60000 = arrayListOf(31.54,12.31, 8.46)
    var percentLess70000 = arrayListOf(29.49, 12.56, 8.85)
    var percentLess80000 = arrayListOf(28.02, 12.56, 8.85)
    var percentLess90000 = arrayListOf(26.92, 12.56, 8.85)
    var percentLess100000 = arrayListOf(26.07, 12.56, 8.85)
    var percentLess110000 = arrayListOf(25.38, 12.56, 8.85)
    var percentLess120000 = arrayListOf(24.83, 12.56, 8.85)
    var percentLess130000 = arrayListOf(24.36, 12.56, 8.85)
    var percentLess140000 = arrayListOf(23.96, 12.56, 8.85)
    var percentLess150000 = arrayListOf(23.63, 12.56, 8.85)
    var percentLess160000 = arrayListOf(23.33, 12.56, 8.85)

    var arrPercentWidget = arrayListOf(
        percentLess30000,
        percentLess40000,
        percentLess50000,
        percentLess60000,
        percentLess70000,
        percentLess80000,
        percentLess90000,
        percentLess100000,
        percentLess110000,
        percentLess120000,
        percentLess130000,
        percentLess140000,
        percentLess150000,
        percentLess160000,
    )

}