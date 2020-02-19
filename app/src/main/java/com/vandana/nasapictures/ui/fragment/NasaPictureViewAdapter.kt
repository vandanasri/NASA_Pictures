package com.vandana.nasapictures.ui.fragment


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vandana.nasapictures.R
import com.vandana.nasapictures.data.db.entity.NasaEntity
import kotlinx.android.synthetic.main.item_view.view.*


class NasaPictureViewAdapter(private var listOfNasa: List<NasaEntity>) :
    RecyclerView.Adapter<NasaPictureViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return listOfNasa.size
    }

    private fun getItem(position: Int): NasaEntity {
        return listOfNasa[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(value: NasaEntity) {
            itemView.tvTitle.text = value.title
            Glide.with(itemView.context).load(value.url).into(itemView.ivUrlImage)
        }

    }

}
