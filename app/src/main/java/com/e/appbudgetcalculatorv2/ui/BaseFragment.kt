package com.e.appbudgetcalculatorv2.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.e.appbudgetcalculatorv2.R
import com.e.appbudgetcalculatorv2.adapters.budget.BudgetAdapter
import com.e.appbudgetcalculatorv2.adapters.budget.ItemBudget
import com.e.appbudgetcalculatorv2.adapters.widget.ItemWidget
import com.e.appbudgetcalculatorv2.adapters.widget.WidgetAdapter
import com.e.appbudgetcalculatorv2.arrays.ArraysBudget
import com.e.appbudgetcalculatorv2.arrays.ArraysWidget
import com.e.appbudgetcalculatorv2.room.AppDatabase
import com.e.appbudgetcalculatorv2.room.budget.BudgetDao
import com.e.appbudgetcalculatorv2.room.budget.BudgetEntity
import com.e.appbudgetcalculatorv2.room.widget.WidgetDao
import com.e.appbudgetcalculatorv2.room.widget.WidgetEntity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_base.view.*
import java.text.DecimalFormat

class BaseFragment: Fragment() {

    private lateinit var adapterBudget : BudgetAdapter
    private lateinit var adapterWidget : WidgetAdapter

    private lateinit var db: AppDatabase

    private lateinit var widgetEntity: WidgetEntity
    private lateinit var widgetDao: WidgetDao

    private lateinit var budgetEntity: BudgetEntity
    private lateinit var budgetDao: BudgetDao

    private val arraysBudget = ArraysBudget()
    private val arraysWidget = ArraysWidget()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.textViewMoneyApp.text = "@MoneyPlan_app"

        db = Room.databaseBuilder(
            requireActivity(),
            AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()

        widgetDao = db.widgetDao()
        budgetDao = db.budgetDao()


        if (budgetDao.getAllBudget().size==0){
            for (i in 0 until arraysBudget.arrPercentBudget.size){
                budgetDao.insertBudget(BudgetEntity(
                    i,
                    arraysBudget.name,
                    arraysBudget.arrPercentBudget[i]))
                Log.d("id", i.toString())
                Log.d("name", arraysBudget.name.toString())
                Log.d("listPercent", arraysBudget.arrPercentBudget[i].toString())
            }

        }

        val a : BudgetEntity = budgetDao.getBudgetById(0)

        Log.d("dasd", a.listPercent.toString())

        val listBidget = budgetDao.getAllBudget()

        val listWidgetRcView = ArrayList<ItemWidget>()

        val listBudgetRcView = ArrayList<ItemBudget>()

        val decimalFormat2 = DecimalFormat("#.##")
        for (i in 0 until listBidget.get(0).listName.size){
            listBudgetRcView.add(
                ItemBudget(
                    name = listBidget[5].listName[i],
                    cost = decimalFormat2.format(30000 * listBidget[5].listPercent[i].toDouble() / 100).toInt().toString(),
                    percent = listBidget[5].listPercent[i],
                    id = listBidget[5].id
                )
            )
        }


        view.rcViewBudget.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(activity)
            adapterBudget = BudgetAdapter(listBudgetRcView) { id: Int ->
                Toast.makeText(activity, "name $id", Toast.LENGTH_SHORT).show()
                Log.d("dasdsa", id.toString())
            }
            adapter = adapterBudget
        }

        view.rcViewWidget.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(activity, 2)
            adapterWidget = WidgetAdapter(listWidgetRcView) { name: String ->
                Toast.makeText(activity, "name $name", Toast.LENGTH_SHORT).show()
                Log.d("dasdsa", name)
            }
            adapter = adapterWidget
        }

        view.textViewMoneyApp.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/MoneyPlan_app"))
            startActivity(browserIntent)
        }
        view.textViewArsenyiAntonov.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/usernames0903"))
            startActivity(browserIntent)
        }
        view.textViewElizDry.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://t.me/ElizavetaDezign")
            )
            startActivity(browserIntent)
        }

        val llBottomSheet = view.findViewById<LinearLayout>(R.id.bottomSheet)
        val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(llBottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        view.tvShowWidget.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                view.tvShowWidget.text = "Показать виджеты"

            } else if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                view.tvShowWidget.text = "Скрыть виджеты"

            }
        }
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                view.rcViewWidget.alpha = 1 - slideOffset
                if (slideOffset == 0f) {
                    view.tvShowWidget.text = "Скрыть виджеты"
                    view.textViewMoneyApp.visibility = View.VISIBLE
                    view.textViewArsenyiAntonov.visibility = View.VISIBLE
                    view.textViewElizDry.visibility = View.VISIBLE
                    view.textView8.visibility = View.VISIBLE
                    view.textViewWork.visibility = View.VISIBLE
                    view.textView10.visibility = View.VISIBLE
                } else {
                    view.tvShowWidget.text = "Показать виджеты"
                    view.textViewMoneyApp.visibility = View.GONE
                    view.textViewArsenyiAntonov.visibility = View.GONE
                    view.textViewElizDry.visibility = View.GONE
                    view.textView8.visibility = View.GONE
                    view.textViewWork.visibility = View.GONE
                    view.textView10.visibility = View.GONE
                }
            }
        })
    }
}