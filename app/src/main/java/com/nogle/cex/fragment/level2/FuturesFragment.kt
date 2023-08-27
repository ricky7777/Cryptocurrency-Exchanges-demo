package com.nogle.cex.fragment.level2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nogle.cex.databinding.FragmentFuturesBinding

/**
 * Created by Ricky on 2023/8/27.
 */
class FuturesFragment : Fragment() {
    private var binding: FragmentFuturesBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFuturesBinding.inflate(inflater, container, false)
        return binding?.root
    }
}