package br.com.manieri.guarany.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GUA_PRECOS", primaryKeys = ["PRP_CODIGO", "PRP_TABELAPRECO", "PRP_UNIVENDA", "PRP_CODIGOEMPRESA"])
data class Preco(
    @ColumnInfo(name = "PRP_CODIGO") val codigo: String,
    @ColumnInfo(name = "PRP_TABELAPRECO") val tabelaPreco: String,
    @ColumnInfo(name = "PRP_UNIVENDA") val uniVenda: String,
    @ColumnInfo(name = "PRP_CODIGOEMPRESA") val codigoEmpresa: String,

    @ColumnInfo(name = "PRP_PRECOS") val precos: String,
    @ColumnInfo(name = "PRP_DESCPROMOCAO") val descPromocao: Double,
    @ColumnInfo(name = "PRP_DESCONTONORMAL") val descontoNormal: Double,
    @ColumnInfo(name = "PRP_DESCONTOFLEX") val descontoFlex: Double,
    @ColumnInfo(name = "PRP_ACRESCIMOMAX") val acrescimoMax: Double,
    @ColumnInfo(name = "PRP_CODIGOCOMISSAO") val codigoComissao: String,
    @ColumnInfo(name = "PRP_PERCEMB") val percEmb: Double,
    @ColumnInfo(name = "PRP_QTDEMINIMA", defaultValue = "0") val qtdeMinima: Int,
    @ColumnInfo(name = "PRP_QTDEMAXIMA", defaultValue = "999") val qtdeMaxima: Int,
    @ColumnInfo(name = "PRP_ALTERAPRECO") val alteraPreco: String,
    @ColumnInfo(name = "PRP_DESCPROMOCAO_IMPACTA_VERBA") val descPromocaoImpactaVerba: String,
    @ColumnInfo(name = "PRP_EXIBE_ETIQUETADESCONTO_PERC") val exibeEtiquetaDescontoPerc: Double,
    @ColumnInfo(name = "PRP_VALORMINVERBAAVULSA") val valorMinVerbaAvulsa: Double,
    @ColumnInfo(name = "PRP_SEGREGACAO") val segregacao: Int,
    @ColumnInfo(name = "PRP_QTDSEGRSELECAO") val qtdeSegrSelecao: Int
)
