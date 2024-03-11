package br.com.manieri.guarany.ui.produto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProdutosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Produtos em construção..."
    }
    val text: LiveData<String> = _text
}