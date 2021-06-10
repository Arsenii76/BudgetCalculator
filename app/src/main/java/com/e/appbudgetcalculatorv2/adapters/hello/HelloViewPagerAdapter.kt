package com.e.appbudgetcalculatorv2.adapters.hello

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.e.appbudgetcalculatorv2.R
import com.e.appbudgetcalculatorv2.ui.BaseFragment
import kotlinx.android.synthetic.main.item_v_p_hello.view.*

class HelloViewPagerAdapter() : RecyclerView.Adapter<PagerVH>(){
    private val arrTitle = arrayListOf(
        "Поможем\n" +
                "распланировать\n" +
                "бюджет", "Просто\n" +
                "следуй нашим\n" +
                "рекомендациям", "Легко\n" +
                "планируй будущие траты"
    )
    private val arrContent = arrayListOf(
        "просто впиши свой доход", "или впиши свои расходы", "добавляй собственные категории"
    )
    private var arrImageView = arrayListOf(R.drawable.first_hello, R.drawable.second_hello, R.drawable.third_hello)
    private val arrBackground = arrayListOf(R.color.helloFirst, R.color.helloSecond, R.color.helloThird,)
    override fun getItemViewType(position: Int): Int {
        return if (position==0){
            0;
        }else{
            1;
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        return if (viewType==0){
            PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_v_p_hello_first, parent, false))
        }else{
            PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_v_p_hello, parent, false))
        }
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        if (holder.itemViewType!=0){
            holder.itemView.setBackgroundColor(holder.itemView.resources.getColor(arrBackground[position-1]))
            tv_title_view_pager.text = arrTitle[position-1]
            tv_content_view_pager.text = arrContent[position-1]
            image_view_view_pager.setImageResource(arrImageView[position-1])
        }
        val baseFragment = BaseFragment()
        skip.setOnClickListener {
            (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, baseFragment).commit()
        }
    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)