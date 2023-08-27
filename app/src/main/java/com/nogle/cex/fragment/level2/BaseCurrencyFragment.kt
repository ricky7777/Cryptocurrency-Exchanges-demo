package com.nogle.cex.fragment.level2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nogle.cex.NogleViewModel
import com.nogle.cex.adapter.CurrencyAdapter
import com.nogle.cex.databinding.FragmentBaseCurrencyBinding

/**
 * Created by Ricky on 2023/8/28.
 */
abstract class BaseCurrencyFragment : Fragment() {
    private val nogleViewModel: NogleViewModel by viewModels()
    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBaseCurrencyBinding.inflate(layoutInflater)
        currencyAdapter = CurrencyAdapter(emptyMap())
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = currencyAdapter
        nogleViewModel.exchangeData.observe(viewLifecycleOwner) { pair ->
            currencyAdapter.updateData(getDataMap(pair))
        }
        return binding.root
    }

    abstract fun getDataMap(dataPair: Pair<Map<String, Float>, Map<String, Float>>): Map<String, Float>

}