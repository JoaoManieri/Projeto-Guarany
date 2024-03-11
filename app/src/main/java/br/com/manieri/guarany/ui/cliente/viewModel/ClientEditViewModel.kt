package br.com.manieri.guarany.ui.cliente.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class ClientEditViewModel(application: Application
) : AndroidViewModel(application) {
    companion object {
        var editMode = MutableLiveData<Boolean>()
    }
}