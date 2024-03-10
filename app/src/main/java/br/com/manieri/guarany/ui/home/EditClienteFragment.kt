package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.manieri.guarany.R
import br.com.manieri.guarany.databinding.FragmentEditClienteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent


class EditClienteFragment (private var code : String? = null) : Fragment(), KoinComponent {

    private val clienteViewModel: ClienteViewModel by viewModel()
    private var _binding: FragmentEditClienteBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.code = arguments?.getSerializable("code") as String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditClienteBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}