package com.nogle.cex.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.nogle.cex.R
import com.nogle.cex.databinding.FragmentDBinding

/**
 * Created by Ricky on 2023/8/27.
 * this fragment have setting icon/action
 */
class FourthFragment : Fragment() {
    private lateinit var binding: FragmentDBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEvent()

    }

    private fun setEvent() {
        binding.ivSetting.setOnClickListener {
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.settingsFragment)
        }
    }
}