package com.hfad.mycountcompose.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.hfad.mycountcompose.data.App
import com.hfad.mycountcompose.data.AppDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountViewModel :ViewModel(){

    private val _uiState= MutableStateFlow(CountUiState())
    val uiState: StateFlow<CountUiState> = _uiState.asStateFlow()

    fun plus() {
        _uiState.update { currentState ->
            val count = currentState.count + currentState.step
            currentState.copy(
                count = count
            )
        }
    }

    fun minus() {
        _uiState.update { currentState ->
            val count = currentState.count - currentState.step
            currentState.copy(
                count = count
            )
        }
    }


}