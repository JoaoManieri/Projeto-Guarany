package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.manieri.guarany.databinding.FragmentFirstBinding
import br.com.manieri.guarany.ui.home.configs.configCnpjCpf
import br.com.manieri.guarany.ui.home.configs.configTelefone
import br.com.manieri.guarany.ui.home.data.CliData
import org.koin.android.ext.android.inject


class ClientDadosFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val cliData: CliData by inject()
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
    }

    private fun configTextFields() {
        configTelefone(binding.telefoneEditText)
        configCnpjCpf(binding.cnpjEditText)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}