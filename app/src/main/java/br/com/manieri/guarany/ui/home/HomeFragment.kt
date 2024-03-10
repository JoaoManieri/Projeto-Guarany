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

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterCliente: AdapterCliente
    private val listCliente : MutableList<ClienteListView> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cliente = mutableListOf(ClienteListView("", "Tecnomtor eletronica do brasil", "TECNOMOTOR", "443083060365"),ClienteListView("", "", "ZYZ", ""),)

        val recyclerViewCliente = binding.listaClientesRecyclerView
        recyclerViewCliente.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewCliente.setHasFixedSize(true)
        adapterCliente = AdapterCliente(requireContext(), cliente)
        recyclerViewCliente.adapter = adapterCliente
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}