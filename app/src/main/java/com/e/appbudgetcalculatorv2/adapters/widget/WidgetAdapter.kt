package com.e.appbudgetcalculatorv2.adapters.widget

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.e.appbudgetcalculatorv2.R
import com.e.appbudgetcalculatorv2.ui.BaseFragment
import kotlinx.android.synthetic.main.item_rc_view_widget.view.*

class WidgetAdapter (private var listArray: ArrayList<ItemWidget>, private val onItemClickListener: (String) -> Unit): RecyclerView.Adapter<WidgetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_rc_view_widget, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArray[position]
        holder.bind(listItem, onItemClickListener)
    }

    override fun getItemCount(): Int = listArray.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun bind(listWidget: ItemWidget, onItemClickListener: (String) -> Unit) {
            view.tvTitleWidget.text = listWidget.title
            view.tvPriceWidget.text = listWidget.prise + " ₽ / " + listWidget.period
            itemView.setBackgroundResource(listWidget.color)
            itemView.setOnClickListener {
                onItemClickListener(listWidget.title)
            }
        }
    }
    fun changeData(listArray: ArrayList<ItemWidget>){
        this.listArray = listArray
        notifyDataSetChanged()
    }
}