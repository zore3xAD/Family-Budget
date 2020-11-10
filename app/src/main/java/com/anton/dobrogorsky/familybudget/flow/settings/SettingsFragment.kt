package com.anton.dobrogorsky.familybudget.flow.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.anton.dobrogorsky.familybudget.databinding.SettingsFragmentBinding
import com.anton.dobrogorsky.familybudget.flow.BaseViewBindingFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SettingsFragment : BaseViewBindingFragment<SettingsFragmentBinding>() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    private val viewModel: SettingsViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SettingsFragmentBinding {
        return SettingsFragmentBinding.inflate(inflater, container, false)
    }

}