package com.example.jobapp.utils

sealed class UIEvent {
    data object PopBackStack : UIEvent()
    data class Navigate(val route: String) : UIEvent()
    data class ShowSnackBar(val message: String, val action: String? = null) : UIEvent()
    data class ShowToastMessage(val message: String) : UIEvent()
}