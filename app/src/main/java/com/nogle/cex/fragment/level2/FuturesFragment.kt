package com.nogle.cex.fragment.level2

/**
 * Created by Ricky on 2023/8/27.
 * Futures Fragment, level2 fragment
 * parent fragment is FirstFragment
 */
class FuturesFragment : BaseCurrencyFragment() {

    override fun getDataMap(dataPair: Pair<Map<String, Float>, Map<String, Float>>): Map<String, Float> = dataPair.second
}