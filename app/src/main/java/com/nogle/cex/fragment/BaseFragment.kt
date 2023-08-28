package com.nogle.cex.fragment

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Created by Ricky on 2023/8/28.
 * now base fragment have handler generic type
 */
open class BaseFragment : Fragment() {
    private var activityHandler: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityHandler = context
    }

    fun <H> getActivityHandler(type: Class<H>?): H? {
        if (type != null && type.isInstance(activityHandler)) {
            return activityHandler as H
        }

        return null
    }
}