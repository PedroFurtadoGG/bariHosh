package br.com.bariHosh.entidade;


public enum EnumTipoProduto  {
	
	AI("ATIVO IMOBILIZADO"),
	BN("BENEFICIAMENTO"),
	EM("EMBALAGEM"),
	EP("EPI�S"),
	GE("GARANTIA ESTENDIDA"),
	GG("GASTOS GERAIS"),
	GN("GENERICO"),
	IA("INSUMO AGRICOLA"),
	II("INSUMO INDUSTRIAIS"),
	IN("PRODUTOS INDUSTRIAIS"),
	KT("KIT"),
	MC("MATERIAL DE CONSUMO"),
	ME("MERCADORIA"),
	MM("MATERIAIS MANFRO"),
	MO("MAO DE OBRA"),
	MP("MATERIA PRIMA"),
	OI("OUTROS INSUMOS"),
	PA("PRODUTO ACABADO"),
	PI("PRODUTO INTERMEDIARIO"),
	PP("PRODUTO EM PROCESSO"),
	PV("PRODUTO VEICULO"),
	RE("Residuos"),
	SE("SERVICO"),
	SL("SELO DE CONTROLE"),
	SM("SEMENTES"),
	SP("SUBPRODUTO"),
	SV("SERVI�O");
	
	private String descricao;
	
	private EnumTipoProduto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}
}
