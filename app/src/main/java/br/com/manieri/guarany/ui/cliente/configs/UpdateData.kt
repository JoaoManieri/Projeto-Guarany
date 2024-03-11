package br.com.manieri.guarany.ui.cliente.configs

import android.text.Editable
import android.text.TextWatcher
import br.com.manieri.guarany.R
import br.com.manieri.guarany.ui.cliente.data.CliData
import com.google.android.material.textfield.TextInputEditText
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class UpdateData() : KoinComponent{

    val cliData: CliData by inject()

    fun update(view: TextInputEditText, key : String) {

        view.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val novoConteudo = s.toString()
                when (key) {
                    "razaoSocial" -> cliData.cliente.razaoSocial = novoConteudo
                    "cgccpf" -> cliData.cliente.cgccpf = novoConteudo
                    "endereco" -> cliData.cliente.endereco = novoConteudo
                    "numero" -> cliData.cliente.numero = novoConteudo
                    "complemento" -> cliData.cliente.complemento = novoConteudo
                    "bairro" -> cliData.cliente.bairro = novoConteudo
                    "codigoMunicipio" -> cliData.cliente.codigoMunicipio = novoConteudo
                    "telefone" -> cliData.cliente.telefone = novoConteudo
                    "cep" -> cliData.cliente.cep = novoConteudo
                    "status" -> cliData.cliente.status = novoConteudo
                    "nomeFantasia" -> cliData.cliente.nomeFantasia = novoConteudo
                    "dataCadastro" -> cliData.cliente.dataCadastro = novoConteudo
                    else -> {

                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
