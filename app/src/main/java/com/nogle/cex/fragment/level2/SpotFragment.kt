package com.nogle.cex.fragment.level2

/**
 * Created by Ricky on 2023/8/27.
 * Spot Fragment, level2 fragment
 * parent fragment is FirstFragment
 */
class SpotFragment : BaseCurrencyFragment() {
    override fun getDataMap(dataPair: Pair<Map<String, Float>, Map<String, Float>>): Map<String, Float> = dataPair.first

}