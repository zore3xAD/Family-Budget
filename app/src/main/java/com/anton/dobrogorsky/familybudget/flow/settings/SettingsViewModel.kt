package com.anton.dobrogorsky.familybudget.flow.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anton.dobrogorsky.familybudget.databinding.SettingsFragmentBinding
import com.anton.dobrogorsky.familybudget.app.App
import com.anton.dobrogorsky.familybudget.model.entity.Personal
import com.anton.dobrogorsky.familybudget.repository.PersonalRepository
import kotlinx.coroutines.launch

class SettingsViewModel(private val userRepository: PersonalRepository = PersonalRepository(App.appDatabase.personalDao)) : ViewModel() {

    var binding: SettingsFragmentBinding? = null

    var personalInfo = userRepository.personalInfo

    private var _inPersonalInfoEdit = MutableLiveData<Boolean>()
    var inPersonalInfoEdit = _inPersonalInfoEdit

    init {
        loadPersonalData()
    }

    private fun loadPersonalData() {
        viewModelScope.launch {
            personalInfo = userRepository.personalInfo
        }
    }

    fun onStartEditClick() {
        _inPersonalInfoEdit.value = true
    }

    fun onSaveClick() {
        binding?.let { view ->
            if (view.editTextName.editText?.text.isNullOrEmpty() || view.editTextSurname.editText?.text.isNullOrEmpty()) {
                when {
                    view.editTextName.editText?.text.isNullOrEmpty() -> view.editTextName.editText?.error = "Could not be empty"
                    view.editTextSurname.editText?.text.isNullOrEmpty() -> view.editTextSurname.editText?.error = "Could not be empty"
                    else -> {}
                }
            } else {
                val personal = Personal(id = 1, name = view.editTextName.editText!!.text.toString(), surname = view.editTextSurname.editText!!.text.toString())
                _inPersonalInfoEdit.value = false
                if (this.personalInfo.value != null) {
                    viewModelScope.launch {
                        userRepository.update(personal)
                    }
                } else {
                    viewModelScope.launch {
                        userRepository.insert(personal)
                    }
                }
            }
        }
    }
}