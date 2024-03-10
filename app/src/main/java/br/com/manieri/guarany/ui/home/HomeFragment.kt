package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.manieri.guarany.R
import br.com.manieri.guarany.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class HomeFragment : Fragment(), ClientFragmentView, KoinComponent {

    private val clienteViewModel: ClienteViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapterCliente: AdapterCliente

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initializeRecyclerView(clienteViewModel)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun initializeRecyclerView(viewModel: ClienteViewModel) {
        viewModel.postClients()
        viewModel.observerCliente.observe(viewLifecycleOwner) {
            val recyclerViewCliente = binding.listaClientesRecyclerView
            recyclerViewCliente.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewCliente.setHasFixedSize(true)
            adapterCliente = AdapterCliente(requireContext(), it) {
                val bundle = Bundle().apply {
                    putSerializable("code", it)
                }
                findNavController().navigate(R.id.action_nav_home_to_editeClienteFragment,bundle)
            }
            recyclerViewCliente.adapter = adapterCliente
        }
    }
}