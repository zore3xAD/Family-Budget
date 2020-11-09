package com.anton.dobrogorsky.familybudget.flow.records

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anton.dobrogorsky.familybudget.R

class RecordsFragment : Fragment() {

    companion object {
        fun newInstance() = RecordsFragment()
    }

    private lateinit var viewModel: RecordsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.records_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecordsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}