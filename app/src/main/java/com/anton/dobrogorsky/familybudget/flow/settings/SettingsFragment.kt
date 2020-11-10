package com.anton.dobrogorsky.familybudget.flow.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anton.dobrogorsky.familybudget.databinding.SettingsFragmentBinding

class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private var _binding: SettingsFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        viewModel.binding = binding
        viewModel.personalInfo.observe(this, { personalInfo ->
            personalInfo?.let { personal ->
                binding.editTextName.editText?.setText(personal.name)
                binding.editTextSurname.editText?.setText(personal.surname)
            }
        })

        viewModel.inPersonalInfoEdit.observe(this, {inEditing ->
            setEditEnabled(inEditing)
        })

        binding.fabEditPersonalData.setOnClickListener { v ->
            when (v.isSelected) {
                false -> viewModel.onStartEditClick()
                true -> viewModel.onSaveClick()
            }
        }
    }

    private fun setEditEnabled(isEnabled: Boolean) {
        binding.fabEditPersonalData.isSelected = isEnabled
        binding.editTextName.isEnabled = isEnabled
        binding.editTextSurname.isEnabled = isEnabled
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}