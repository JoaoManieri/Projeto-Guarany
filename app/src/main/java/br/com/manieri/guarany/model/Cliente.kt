package br.com.manieri.guarany.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable

data class Cliente(
    @PrimaryKey(autoGenerate = false)
    val codigoCliente: String = "",
    val razaoSocial: String="",
    val cgccpf: String="",
//    val inscEstadual: String,
    val endereco: String="",
    val numero: String="",
    val complemento: String="",
    val bairro: String="",
    val codigoMunicipio: String="",
    val telefone: String="",
//    val fax: String,
    val cep: String="",
    val status: String="",
    val nomeFantasia: String="",
    val dataCadastro: String="",
//    val codRegiao: String,
//    val condicaoEntrega: String,
//    val codRamo: String,
//    val codTabPreco: String,
//    val ultimaCompra: String,
//    val ultimaVisita: String,
//    val obsCredito: String,
//    val obsGeral: String,
//    val email: String,
//    val prazoMaximo: Int,
//    val codigoFormaPgto: String,
//    val formasPagamentos: String,
//    val descFidelidade: Double,
//    val bloqueado: String,
//    val altTabPreco: String,
//    val codigoCondPgto: String,
//    val financeiro: Double,
//    val prazoMinimoEnt: Int,
//    val prazoMaximoFat: Int,
//    val obrigarMultiploEmb: String,
//    val clienteVip: String,
//    val motivoBloqueio: String,
//    val tipoPessoa: String,
//    val transportadora: String,
//    val desconto: Double,
//    val tratarLimiteCred: Int,
//    val toleranciaLimiteCred: Double,
//    val empresas: String,
//    val praca: String,
//    val latitude: Double,
//    val longitude: Double,
//    val pessoa: String,
//    val enderecoEntrega: String,
//    val numeroEntrega: String,
//    val complementoEntrega: String,
//    val bairroEntrega: String,
//    val codMunicipioEntrega: String,
//    val cepEntrega: String,
//    val enderecoCobranca: String,
//    val numeroCobranca: String,
//    val complementoCobranca: String,
//    val bairroCobranca: String,
//    val codMunicipioCobranca: String,
//    val cepCobranca: String,
//    val emailSecundario: String,
//    val emailNf: String,
//    val codigoGrupoCliente: Int,
//    val percFrete: Double,
//    val empresaPadrao: String,
//    val pedidoMinimo: Double,
//    val parcelaMinima: Double,
//    val representante: String,
//    val enviado: String,
//    val financeiroIsento: String,
//    val dataFundacao: String,
//    val suframa: String,
//    val referenciaComercial1: String,
//    val referenciaComercial2: String,
//    val referenciaComercial3: String,
//    val telefoneReferenciaComercial1: String,
//    val telefoneReferenciaComercial2: String,
//    val telefoneReferenciaComercial3: String,
//    val areaComercial: Double,
//    val codigoFaixaFaturamento: String,
//    val telefoneReferenciaBancaria: String,
//    val predioProprio: String,
//    val financeiroAplicaTabela: String,
//    val possuiRede: String,
//    val numeroLojas: Int,
//    val numeroCheckouts: Int,
//    val qtdeFuncionarios: Int,
//    val limiteCredBonif: Double,
//    val regimeEspecial: String,
//    val validadeSivisa: String,
//    val validadeCrf: String,
//    val numeroSivisa: String,
//    val numeroCrf: String,
//    val margemContribuicaoMinima: Double,
//    val pagadorFretePadrao: String,
//    val tipoCalculoFrete: String,
//    val regimeTributario: String,
//    val descontoComissao: String,
//    val saldo: Double,
//    val alerta: String,
//    val tratarLimiteCredBonif: Int,
//    val percVerbaBonificada: Double,
//    val validadeSuframa: String,
//    val vrMetroCubicoFrete: Double,
//    val percentAdicionalComissao: Double,
//    val altFidelidade: String,
//    val cnae: String,
//    val pedidoMinimoEntradaFutura: Double,
//    val parcelaMinimaEntradaFutura: Double
) : Serializable