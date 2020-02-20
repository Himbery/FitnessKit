package com.ttfh21.testlifehack

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_fit.view.*


class CompanyAdapter(private val context: Context, private val fitList: List<Company>)
    :RecyclerView.Adapter<PostViewHolder>() {


    lateinit var mClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(company: Company)
    }

    fun setOnItemClickListener(aClickListener: OnItemClickListener) {
        mClickListener = aClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fit, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return fitList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int)
    {
        (holder as PostViewHolder).bind(fitList[position], mClickListener)

        holder.fitWeekDay.text = fitList[position].weekDay.toString()
        holder.fitName.text = fitList[position].name
        holder.fitTeacher.text = fitList[position].teacher
        holder.description.text = fitList[position].description
        holder.fitPlace.text = fitList[position].place
        holder.startTime.text = fitList[position].startTime + " - " + fitList[position].endTime
    }
}
class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    var fitWeekDay = itemView.weekday
    var fitName = itemView.name_fit
    var fitTeacher = itemView.teacher_fit
    var startTime = itemView.time_fit
    var fitPlace = itemView.place_fit
    var description = itemView.desciption_fit

    fun bind(company: Company,  mClickListener: CompanyAdapter.OnItemClickListener) {
        itemView.setOnClickListener {
            mClickListener.onItemClick(company)
        }
    }
}