package com.nogle.cex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nogle.cex.repository.ExchangeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ricky on 2023/8/27.
 */
class NogleViewModel : ViewModel() {
    private val exchangeRepository = ExchangeRepository()
    val exchangeData = exchangeRepository.exchangeData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            exchangeRepository.initializeData(this)
        }
    }
}