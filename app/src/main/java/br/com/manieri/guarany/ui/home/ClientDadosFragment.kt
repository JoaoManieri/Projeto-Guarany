package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.manieri.guarany.databinding.FragmentFirstBinding
import br.com.manieri.guarany.ui.home.configs.configCnpjCpf
import br.com.manieri.guarany.ui.home.configs.configTelefone
import br.com.manieri.guarany.ui.home.data.CliData
import br.com.manieri.guarany.ui.home.viewModel.ClientEditViewModel
import org.koin.android.ext.android.inject


class ClientDadosFragment : Fragment(){

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val cliData: CliData by inject()
    private val clientEditViewModel: ClientEditViewModel by inject()
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
    }

    private fun editMode() {
        ClientEditViewModel.editMode.observe(viewLifecycleOwner){
            binding.razaoSocialTextField.isEnabled = true
            binding.nomeFantasiaTextField.isEnabled = true
            binding.telefoneTextField.isEnabled = true
            binding.cnpjTextView.isEnabled = true
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
        binding.razaoSocialTextField.isEnabled = false
        binding.nomeFantasiaTextField.isEnabled = false
        binding.telefoneTextField.isEnabled = false
        binding.cnpjTextView.isEnabled = false
        super.onDestroyView()
        _binding = null
    }

}