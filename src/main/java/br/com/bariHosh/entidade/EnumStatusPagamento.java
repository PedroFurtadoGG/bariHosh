package br.com.bariHosh.entidade;

public enum EnumStatusPagamento {
	
	EM_ABERTO("Aberto"),
	FINALIZADO("Finalizado");
	
	
	@SuppressWarnings("unused")
	private String descricao;
	
	private EnumStatusPagamento(String descricao) {
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
