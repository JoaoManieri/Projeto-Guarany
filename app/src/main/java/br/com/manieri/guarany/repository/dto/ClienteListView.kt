package br.com.manieri.guarany.repository.dto

data class ClienteListView (
    val codigoCliente: String,
    val razaoSocial: String,
    val nomeFantasia: String,
    val cgccpf: String,
)