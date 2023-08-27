package com.nogle.cex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.nogle.cex.CustomNavigator
import com.nogle.cex.R
import com.nogle.cex.databinding.FragmentExchangeBinding

/**
 * Created by Ricky on 2023/8/27.
 */
class FirstFragment : Fragment() {
    private var binding: FragmentExchangeBinding? = null
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExchangeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigation()
        setEvent()
    }

    private fun setNavigation() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.tab_container) as NavHostFragment
        navController = navHostFragment.findNavController()
//        context?.let {
//            val navigator = CustomNavigator(it, navHostFragment.childFragmentManager, R.id.tab_container)
//            navController.navigatorProvider.addNavigator(navigator)
//            navController.setGraph(R.navigation.nav_graph_exchange)
//        }

        navController.navigate(R.id.spotFragment)
    }

    private fun setEvent() {
        binding?.tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> navController.navigate(R.id.spotFragment)
                    1 -> navController.navigate(R.id.futuresFragment)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}