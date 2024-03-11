package br.com.manieri.guarany.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.manieri.guarany.databinding.FragmentSecondBinding
import br.com.manieri.guarany.ui.home.configs.configCEP
import br.com.manieri.guarany.ui.home.data.CliData
import br.com.manieri.guarany.ui.home.viewModel.ClientEditViewModel
import org.koin.android.ext.android.inject


class ClienteEnderecoFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private val cliData: CliData by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
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
            binding.cepTextField.isEnabled = true
            binding.enderecoTextField.isEnabled = true
            binding.numeroTextView.isEnabled = true
            binding.bairroTextField.isEnabled = true
            binding.cidadeTextField.isEnabled = true
        }
    }
    private fun insertData() {
        binding.cepEditText.setText(cliData.cliente.cep)
        binding.enderecoEditText.setText(cliData.cliente.endereco)
        binding.numeroEditText.setText(cliData.cliente.numero)
        binding.bairroEditText.setText(cliData.cliente.bairro)
        binding.cidadeEditText.setText(cliData.cliente.codigoMunicipio)
    }

    private fun configTextFields() {
        configCEP(binding.cepEditText)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}