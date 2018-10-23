package br.com.bariHosh.entidade;

public enum EnumStatus  {
	
	ATIVO("Ativo"),
	BLOQUEADO("Bloqueado");
	
	
	@SuppressWarnings("unused")
	private String descricao;
	
	private EnumStatus(String descricao) {
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
