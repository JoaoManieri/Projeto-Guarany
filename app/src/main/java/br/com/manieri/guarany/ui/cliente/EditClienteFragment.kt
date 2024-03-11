package br.com.manieri.guarany.ui.cliente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import br.com.manieri.guarany.R
import br.com.manieri.guarany.databinding.FragmentEditClienteBinding
import br.com.manieri.guarany.ui.cliente.adapter.ClientePagerAdapter
import br.com.manieri.guarany.ui.cliente.viewModel.ClientEditViewModel
import br.com.manieri.guarany.ui.cliente.viewModel.ClienteViewModel
import br.com.manieri.guarany.util.NOVO_CLIENTE
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent


class EditClienteFragment(private var code: String? = null) : Fragment(), KoinComponent {

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
    ): View {
        setHasOptionsMenu(true)
        _binding = FragmentEditClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (code != NOVO_CLIENTE) {
            inflater.inflate(R.menu.menu_edicao, menu)
            super.onCreateOptionsMenu(menu, inflater)
        } else {
            habilitarEdicao()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                habilitarEdicao()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun habilitarEdicao() {

        binding.deletButton.visibility = View.VISIBLE
        binding.nextSaveButton.visibility = View.VISIBLE

        ClientEditViewModel.editMode.postValue(true)

        if (code == NOVO_CLIENTE) {
            binding.deletButton.text = "Calcelar"
            binding.deletButton.setOnClickListener {
                findNavController().navigate(R.id.action_editeClienteFragment_to_nav_clientes)
            }
        } else {
            binding.deletButton.setOnClickListener {
                clienteViewModel.observeDBOperation.observe(viewLifecycleOwner) {
                    Toast.makeText(requireContext(), "Sucesso!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_editeClienteFragment_to_nav_clientes)
                }
                clienteViewModel.delete()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (code != NOVO_CLIENTE) {
            getClienteData()
        }
        initializeViewPager()
    }

    private fun getClienteData() = clienteViewModel.getClienteDataByCode(code.toString())

    private fun initializeViewPager() {
        val viewPager: ViewPager2 = binding.viewPager
        val adapter = ClientePagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setButtonStatus(position)
            }
        })
    }

    fun setButtonStatus(position: Int) {
        if (position == 0) {
            binding.nextSaveButton.text = "proximo ->"
            binding.nextSaveButton.setOnClickListener {
                val viewPager = binding.viewPager
                val nextPosition = viewPager.currentItem + 1
                if (nextPosition < (viewPager.adapter?.itemCount ?: 0)) {
                    viewPager.setCurrentItem(nextPosition, true)
                }
            }
        } else {
            if (code == NOVO_CLIENTE) {
                binding.nextSaveButton.text = "criar novo cliente"
                binding.nextSaveButton.setOnClickListener {
                    clienteViewModel.observeDBOperation.observe(viewLifecycleOwner) {
                        Toast.makeText(requireContext(), "Sucesso!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_editeClienteFragment_to_nav_clientes)
                    }
                    clienteViewModel.insert()
                }
            } else {
                binding.nextSaveButton.text = "salvar alterações"
                binding.nextSaveButton.setOnClickListener {
                    clienteViewModel.observeDBOperation.observe(viewLifecycleOwner) {
                        Toast.makeText(requireContext(), "Sucesso!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_editeClienteFragment_to_nav_clientes)
                    }
                    clienteViewModel.updateClient()
                }
            }
        }
    }

    override fun onDestroyView() {
        ClientEditViewModel.editMode.postValue(false)
        super.onDestroyView()
        _binding = null
    }
}