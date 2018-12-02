package br.com.bariHosh.entidade;

public enum EnumStatusComanda {
	EM_ABERTO("Aberto"),
	FINALIZADO("Fechado");
	
	
	@SuppressWarnings("unused")
	private String descricao;
	
	private EnumStatusComanda(String descricao) {
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
