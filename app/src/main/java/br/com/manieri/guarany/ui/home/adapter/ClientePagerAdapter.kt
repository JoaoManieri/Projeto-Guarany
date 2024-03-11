package br.com.manieri.guarany.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.manieri.guarany.ui.home.ClientDadosFragment
import br.com.manieri.guarany.ui.home.ClienteEnderecoFragment

class ClientePagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager,lifecycle) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0 ){
            ClientDadosFragment()
        } else {
            ClienteEnderecoFragment()
        }
    }
}
