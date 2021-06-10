package com.e.appbudgetcalculatorv2.adapters.budget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.e.appbudgetcalculatorv2.R
import kotlinx.android.synthetic.main.rc_view_item_budget.view.*

class BudgetAdapter(private var listArray: ArrayList<ItemBudget>, private val onItemClickListener: (Int) -> Unit) : RecyclerView.Adapter<BudgetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.rc_view_item_budget, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArray[position]
        holder.bind(listItem, onItemClickListener)
    }

    override fun getItemCount() = listArray.size

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(listItem: ItemBudget, onItemClickListener: (Int) -> Unit) {
            view.tvNameBudged.text = listItem.name
            view.tvPercentBudget.text = listItem.percent.toString() + " %"
            view.tvCostBudged.text = listItem.cost.toString() + " ₽"

            if (listItem.cost.toDouble()<0){
                view.tvNameBudged.setTextColor(itemView.resources.getColor(R.color.pink))
                view.tvPercentBudget.setTextColor(itemView.resources.getColor(R.color.pink))
                view.tvCostBudged.setTextColor(itemView.resources.getColor(R.color.pink))
            }
            itemView.setOnClickListener {

                onItemClickListener(listItem.id)

                /*if (0==0){
                    (view.context as FragmentActivity).supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.fragmentContainer,
                            FragmentChangeCategory.newInstance(
                                listItem.name,
                                listItem.id,
                            )
                        )
                        .commit()
                }else{
                    Toast.makeText(itemView.context, "Чтобы менять категории, введите зарплату!", Toast.LENGTH_SHORT).show()
                }*/
            }
        }
    }
    fun changeData(listArray: ArrayList<ItemBudget>){
        this.listArray = listArray
        notifyDataSetChanged()
    }
}