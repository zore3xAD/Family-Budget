package com.anton.dobrogorsky.familybudget.flow.records

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anton.dobrogorsky.familybudget.R
import com.anton.dobrogorsky.familybudget.databinding.RecordsFragmentBinding
import com.anton.dobrogorsky.familybudget.flow.BaseViewBindingFragment
import org.koin.android.viewmodel.ext.android.viewModel

class RecordsFragment : BaseViewBindingFragment<RecordsFragmentBinding>() {

    companion object {
        fun newInstance() = RecordsFragment()
    }

    private val viewModel: RecordsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.records_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): RecordsFragmentBinding {
        return RecordsFragmentBinding.inflate(inflater, container, false)
    }

}