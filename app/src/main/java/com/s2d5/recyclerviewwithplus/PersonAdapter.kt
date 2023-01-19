package com.s2d5.recyclerviewwithplus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.s2d5.recyclerviewwithplus.databinding.ItemPersonBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    private val datas: ArrayList<PersonData> = arrayListOf()
    fun setData(arrayList: ArrayList<PersonData>) {
        datas.clear()
        datas.addAll(arrayList)
        notifyItemRangeInserted(0, datas.size)
    }

    fun addData(data: PersonData) {
        datas.add(data)
        notifyItemInserted(datas.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class ViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PersonData) {
            Glide.with(binding.root).load(data.imageUri).into(binding.iv)
            binding.tvJob.text = data.job
        }
    }
}