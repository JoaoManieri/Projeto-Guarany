package br.com.manieri.guarany.ui.cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.manieri.guarany.databinding.FragmentSecondBinding
import br.com.manieri.guarany.ui.cliente.configs.UpdateData
import br.com.manieri.guarany.ui.cliente.configs.configCEP
import br.com.manieri.guarany.ui.cliente.data.CliData
import br.com.manieri.guarany.ui.cliente.viewModel.ClientEditViewModel
import org.koin.android.ext.android.inject


class ClienteEnderecoFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private val cliData: CliData by inject()

    val updateData = UpdateData()
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
        updateConfig()
    }

    private fun updateConfig() {
        updateData.update(binding.cepEditText, "cep")
        updateData.update(binding.enderecoEditText, "endereco")
        updateData.update(binding.numeroEditText, "numero")
        updateData.update(binding.bairroEditText, "bairro")
        updateData.update(binding.cidadeEditText, "codigoMunicipio")
    }

    private fun editMode() {
        ClientEditViewModel.editMode.observe(viewLifecycleOwner){
            binding.cepTextField.isEnabled = it
            binding.enderecoTextField.isEnabled = it
            binding.numeroTextView.isEnabled = it
            binding.bairroTextField.isEnabled = it
            binding.cidadeTextField.isEnabled = it
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