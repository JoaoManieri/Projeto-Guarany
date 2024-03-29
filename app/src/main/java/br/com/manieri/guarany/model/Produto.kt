package br.com.manieri.guarany.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GUA_PRODUTOS", primaryKeys = ["PRO_CODIGOEMPRESA", "PRO_CODIGO"])
data class Produto(
    @ColumnInfo(name = "PRO_CODIGOEMPRESA") val proCodigoEmpresa: String,
    @ColumnInfo(name = "PRO_CODIGO") val proCodigo: String,
    @ColumnInfo(name = "PRO_CODIGOMARCA") val proCodigoMarca: String?,
    @ColumnInfo(name = "PRO_CODIGOGRUPO") val proCodigoGrupo: String?,
    @ColumnInfo(name = "PRO_DESCRICAO") val proDescricao: String,
    @ColumnInfo(name = "PRO_STATUS") val proStatus: String?,
    @ColumnInfo(name = "PRO_DUN14") val proDun14: String?,
    @ColumnInfo(name = "PRO_EAN13") val proEan13: String?,
    @ColumnInfo(name = "PRO_PESOBRUTO") val proPesoBruto: Double?,
    @ColumnInfo(name = "PRO_QTDEEMBALAGEM") val proQtdeEmbalagem: Int?,
    @ColumnInfo(name = "PRO_VOLUME") val proVolume: String?,
    @ColumnInfo(name = "PRO_OBSERVACAO") val proObservacao: String?,
    @ColumnInfo(name = "PRO_UNIDPRODUTO") val proUnidProduto: String?,
    @ColumnInfo(name = "PRO_TEMPOVALIDADE") val proTempoValidade: String?,
    @ColumnInfo(name = "PRO_PERCCOMISSAO") val proPercComissao: Double?,
    @ColumnInfo(name = "PRO_FLAGVALORFIXO") val proFlagValorFixo: String?,
    @ColumnInfo(name = "PRO_QTDEMINIMAVENDA") val proQtdeMinimaVenda: Double?,
    @ColumnInfo(name = "PRO_QTDEMULTIPLOVENDA") val proQtdeMultiploVenda: Double?,
    @ColumnInfo(name = "PRO_PRECUSTO") val proPrecoCusto: Double?,
    @ColumnInfo(name = "PRO_REFERENCIA") val proReferencia: String?,
    @ColumnInfo(name = "PRO_CODIGOFORNECEDOR") val proCodigoFornecedor: String?,
    @ColumnInfo(name = "PRO_EMBALAGENS") val proEmbalagens: String?,
    @ColumnInfo(name = "PRO_SITESTOQUE") val proSitesEstoque: Int,
    @ColumnInfo(name = "PRO_IPI") val proIpi: Double,
    @ColumnInfo(name = "PRO_MKPMINIMO") val proMkpMinimo: Double,
    @ColumnInfo(name = "PRO_RAMOSATIVIDADE") val proRamosAtividade: String,
    @ColumnInfo(name = "PRO_SEGMENTO") val proSegmento: String,
    @ColumnInfo(name = "PRO_LINHA") val proLinha: String,
    @ColumnInfo(name = "PRO_NCM") val proNcm: String,
    @ColumnInfo(name = "PRO_SEGREGACAO") val proSegregacao: Int,
    @ColumnInfo(name = "PRO_EMPRESAFAT") val proEmpresaFat: String?,
    @ColumnInfo(name = "PRO_ESTOQUEMINIMO") val proEstoqueMinimo: Double?,
    @ColumnInfo(name = "PRO_CODIGOSUBGRUPO") val proCodigoSubgrupo: String?,
    @ColumnInfo(name = "PRO_CORLEGENDANORMAL") val proCorLegendaNormal: String?,
    @ColumnInfo(name = "PRO_TIPOPEDIDOS") val proTipoPedidos: String?,
    @ColumnInfo(name = "PRO_DESEMBUTEIPI") val proDesembuteIpi: String?,
    @ColumnInfo(name = "PRO_CLA") val proCla: String?,
    @ColumnInfo(name = "PRO_TROCAPROIBIDA") val proTrocaProibida: String?,
    @ColumnInfo(name = "PRO_GIRO") val proGiro: Int?,
    @ColumnInfo(name = "PRO_RETORNO") val proRetorno: String?,
    @ColumnInfo(name = "PRO_DESPESAOPERACIONAL") val proDespesaOperacional: Double?,
    @ColumnInfo(name = "PRO_CONTRIBUICAOMINIMA") val proContribuicaoMinima: Double?,
    @ColumnInfo(name = "PRO_DESCRICAOPDF") val proDescricaoPdf: String?,
    @ColumnInfo(name = "PRO_VRAQUISICAO") val proVrAquisicao: Double?,
    @ColumnInfo(name = "PRO_DESCRICAOLONGA") val proDescricaoLonga: String?,
    @ColumnInfo(name = "PRO_FICHA_DADOS") val proFichaDados: String?,
    @ColumnInfo(name = "PRO_CODIGOCEST") val proCodigoCest: String?,
    @ColumnInfo(name = "PRO_CONTRIBUICAOIDEAL") val proContribuicaoIdeal: Double?,
    @ColumnInfo(name = "PRO_PRAZOSPERMITIDOS") val proPrazosPermitidos: String?,
    @ColumnInfo(name = "PRO_COR") val proCor: String?,
    @ColumnInfo(name = "PRO_TAMANHO") val proTamanho: String?,
    @ColumnInfo(name = "PRO_BLOQPRODSEMEST") val proBloqProdSemEst: Int,
    @ColumnInfo(name = "PRO_DATASUSPENSAOINICIAL") val proDataSuspensaoInicial: String?,
    @ColumnInfo(name = "PRO_DATASUSPENSAOFINAL") val proDataSuspensaoFinal: String?,
    @ColumnInfo(name = "PRO_QTDSEGRSELECAO") val proQtdSegrSelecao: Int?,
    @ColumnInfo(name = "PRO_RAMOSATIVIDADEEXCLUSIVO") val proRamosAtividadeExclusivo: String?,
    @ColumnInfo(name = "PRO_TIPOMEDICAMENTO") val proTipoMedicamento: String?,
    @ColumnInfo(name = "PRO_CLA_EMB") val proClaEmb: String?,
    @ColumnInfo(name = "PRO_PRECOMINIMO") val proPrecoMinimo: Double?,
    @ColumnInfo(name = "PRO_LINK") val proLink: String?
)