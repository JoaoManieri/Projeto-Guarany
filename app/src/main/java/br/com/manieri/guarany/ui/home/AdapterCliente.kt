package br.com.manieri.guarany.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.manieri.guarany.databinding.ItemCustomerBinding
import br.com.manieri.guarany.repository.dto.ClienteListView

class AdapterCliente(
    private val context: Context,
    private val listCliente: MutableList<ClienteListView>,
    private val itemClickListener: (code : String) -> Unit
) : RecyclerView.Adapter<AdapterCliente.ClienteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val itemLista = ItemCustomerBinding.inflate(LayoutInflater.from(context), parent, false)
        return ClienteViewHolder(itemLista)
    }

    override fun getItemCount() = listCliente.size

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        holder.nomeFantasia.text = listCliente[position].nomeFantasia
        holder.razaoSocial.text = listCliente[position].razaoSocial
        holder.cnpj.text = listCliente[position].cgccpf

        holder.itemView.setOnClickListener {
            itemClickListener(listCliente[position].codigoCliente)
        }
    }


    inner class ClienteViewHolder(binding: ItemCustomerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val nomeFantasia = binding.clienteNomeTextView
        val razaoSocial = binding.razaoSocialTextView
        val cnpj = binding.cnpjTextView
    }

}