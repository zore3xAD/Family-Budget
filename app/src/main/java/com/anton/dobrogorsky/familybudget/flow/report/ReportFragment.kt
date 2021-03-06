package com.anton.dobrogorsky.familybudget.flow.report

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anton.dobrogorsky.familybudget.R
import com.anton.dobrogorsky.familybudget.databinding.ReportFragmentBinding
import com.anton.dobrogorsky.familybudget.flow.BaseViewBindingFragment
import org.koin.android.viewmodel.ext.android.viewModel

class ReportFragment : BaseViewBindingFragment<ReportFragmentBinding>() {

    companion object {
        fun newInstance() = ReportFragment()
    }

    private val viewModel: ReportViewModel by viewModel()


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ReportFragmentBinding {
        return ReportFragmentBinding.inflate(inflater, container, false)
    }

}