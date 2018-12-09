package br.com.bariHosh.entidade;

public enum EnumStatusCaixa {
	
	ABERTO("Aberto"),
	OCUPADO("Ocupado"),
	FECHADO("Fechado");
	
	
	@SuppressWarnings("unused")
	private String descricao;
	
	private EnumStatusCaixa(String descricao) {
		this.setDescricao(descricao);
	}
	
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
