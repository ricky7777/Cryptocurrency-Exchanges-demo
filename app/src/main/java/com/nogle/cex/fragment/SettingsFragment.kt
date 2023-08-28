package com.nogle.cex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.nogle.cex.NogleHandler
import com.nogle.cex.R
import com.nogle.cex.databinding.FragmentSettingsBinding

/**
 * Created by Ricky on 2023/8/27.
 */
class SettingsFragment : BaseFragment() {
    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        setEvent()
    }

    private fun setEvent() {
        binding.tvBack.setOnClickListener {
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.fourthFragment)
        }
    }

    private fun setView() {
        getActivityHandler(NogleHandler::class.java)?.hideBottomMenu()
    }

    override fun onStop() {
        super.onStop()
        getActivityHandler(NogleHandler::class.java)?.showBottomMenu()
    }

}