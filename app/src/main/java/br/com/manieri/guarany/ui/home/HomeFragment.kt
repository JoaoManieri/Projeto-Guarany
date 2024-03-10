package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.manieri.guarany.databinding.FragmentHomeBinding
import br.com.manieri.guarany.repository.dto.ClienteListView

class HomeFragment : Fragment(), ClientFragmentView {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterCliente: AdapterCliente

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val clienteViewModel = ViewModelProvider(this)[ClienteViewModel::class.java]
        initializeRecyclerView(clienteViewModel)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun initializeRecyclerView(viewModel:ClienteViewModel) {
        viewModel.postClients()
        viewModel.observerCliente.observe(viewLifecycleOwner){
            val recyclerViewCliente = binding.listaClientesRecyclerView
            recyclerViewCliente.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewCliente.setHasFixedSize(true)
            adapterCliente = AdapterCliente(requireContext(), it)
            recyclerViewCliente.adapter = adapterCliente
        }
    }
}