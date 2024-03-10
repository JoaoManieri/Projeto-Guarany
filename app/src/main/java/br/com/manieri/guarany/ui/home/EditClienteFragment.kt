package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import br.com.manieri.guarany.databinding.FragmentEditClienteBinding
import br.com.manieri.guarany.ui.home.adapter.ClientePagerAdapter
import br.com.manieri.guarany.ui.home.data.CliData
import br.com.manieri.guarany.ui.home.viewModel.ClienteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


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
        _binding = FragmentEditClienteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewPager()
        getClienteData()
    }

    private fun getClienteData() {
        clienteViewModel.getClienteDataByCode(code.toString())
    }


    private fun initializeViewPager() {
        var viewPager: ViewPager2 = binding.viewPager
        val adapter = ClientePagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}