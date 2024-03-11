package br.com.manieri.guarany.ui.cliente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.manieri.guarany.databinding.FragmentFirstBinding
import br.com.manieri.guarany.ui.cliente.configs.UpdateData
import br.com.manieri.guarany.ui.cliente.configs.configCnpjCpf
import br.com.manieri.guarany.ui.cliente.configs.configTelefone
import br.com.manieri.guarany.ui.cliente.data.CliData
import br.com.manieri.guarany.ui.cliente.viewModel.ClientEditViewModel
import org.koin.android.ext.android.inject


class ClientDadosFragment : Fragment(){

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val cliData: CliData by inject()

    val updateData = UpdateData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configTextFields()
        insertData()
        editMode()
        updateConfig()
    }

    private fun updateConfig() {
        updateData.update(binding.razaoSocialEditText, "razaoSocial")
        updateData.update(binding.nomeFantasiaEditText, "nomeFantasia")
        updateData.update(binding.cnpjEditText, "cgccpf")
        updateData.update(binding.telefoneEditText, "telefone")
    }

    private fun editMode() {
        ClientEditViewModel.editMode.observe(viewLifecycleOwner){
            binding.razaoSocialTextField.isEnabled = it
            binding.nomeFantasiaTextField.isEnabled = it
            binding.telefoneTextField.isEnabled = it
            binding.cnpjTextView.isEnabled = it
        }
    }

    private fun insertData() {
        binding.razaoSocialEditText.setText(cliData.cliente.razaoSocial)
        binding.nomeFantasiaEditText.setText(cliData.cliente.nomeFantasia)
        binding.cnpjEditText.setText(cliData.cliente.cgccpf)
        binding.telefoneEditText.setText(cliData.cliente.telefone)
    }

    private fun configTextFields() {
        configTelefone(binding.telefoneEditText)
        configCnpjCpf(binding.cnpjEditText)
    }

    override fun onDestroyView() {
        ClientEditViewModel.editMode.postValue(false)
        super.onDestroyView()
        _binding = null
    }

}