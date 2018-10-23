package br.com.bariHosh.entidade;



public enum EnumTipoNota {
	
	N("Normal"),
	D("Devolucao"),
	B("Beneficiamento"),
	C("Complemento");
	
	
	private String descricao;
	
	private EnumTipoNota(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}	
}
