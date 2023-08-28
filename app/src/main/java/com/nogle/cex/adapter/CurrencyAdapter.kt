package com.nogle.cex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nogle.cex.databinding.CurrencyItemBinding

/**
 * Created by Ricky on 2023/8/28.
 * Currency adapter, adapter currency symbol and price
 * this adapter use DiffUtil to optimize data process performance
 * SpotFragment and FutureFragment will to share
 */
class CurrencyAdapter(private var currencyData: Map<String, Float>) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    fun updateData(newData: Map<String, Float>) {
        val diffCallback = CurrencyDiffCallback(currencyData, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        currencyData = newData
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding: CurrencyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entry: Map.Entry<String, Float>) {
            binding.symbolName.text = entry.key
            binding.price.text = entry.value.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = currencyData.entries.elementAt(position)
        holder.bind(entry)
    }

    override fun getItemCount() = currencyData.size

}

class CurrencyDiffCallback(
    private val oldData: Map<String, Float>,
    private val newData: Map<String, Float>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData.keys.elementAt(oldItemPosition) == newData.keys.elementAt(newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldKey = oldData.keys.elementAt(oldItemPosition)
        val newKey = newData.keys.elementAt(newItemPosition)
        return oldData[oldKey] == newData[newKey]
    }
}