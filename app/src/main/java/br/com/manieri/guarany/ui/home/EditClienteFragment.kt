package br.com.manieri.guarany.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import br.com.manieri.guarany.R
import br.com.manieri.guarany.databinding.FragmentEditClienteBinding
import br.com.manieri.guarany.ui.home.adapter.ClientePagerAdapter
import br.com.manieri.guarany.ui.home.viewModel.ClientEditViewModel
import br.com.manieri.guarany.ui.home.viewModel.ClienteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import java.text.FieldPosition


class EditClienteFragment(private var code: String? = null) : Fragment(), KoinComponent {

    private val clienteViewModel: ClienteViewModel by viewModel()
    private val clientEditViewModel: ClientEditViewModel by viewModel()
    private var _binding: FragmentEditClienteBinding? = null
    private var buttonStatus = 0
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

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_edicao, menu)
        super.onCreateOptionsMenu(menu, inflater)
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
        val nextSaveButton = binding.nextSaveButton
        nextSaveButton.visibility = View.VISIBLE
        ClientEditViewModel.editMode.postValue(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getClienteData()
        initializeViewPager()
    }

    private fun getClienteData() = clienteViewModel.getClienteDataByCode(code.toString())


    private fun initializeViewPager() {
        var viewPager: ViewPager2 = binding.viewPager
        val adapter = ClientePagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setButtonStatus(position)
            }
        })
    }

    fun setButtonStatus(position : Int){
        if (position == 0 ){
            binding.nextSaveButton.text = "proximo ->"
            binding.nextSaveButton.setOnClickListener {
                val viewPager = binding.viewPager
                val nextPosition = viewPager.currentItem + 1
                if (nextPosition < (viewPager.adapter?.itemCount ?: 0)) {
                    viewPager.setCurrentItem(nextPosition, true)
                }
            }
        } else {
            binding.nextSaveButton.text = "salvar alterações"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}