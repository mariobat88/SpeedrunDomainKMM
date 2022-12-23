package com.codebox.speedrun.domain.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual open class BaseViewModel : ViewModel() {
    actual val scope = viewModelScope


    actual override fun onCleared() {}
}
