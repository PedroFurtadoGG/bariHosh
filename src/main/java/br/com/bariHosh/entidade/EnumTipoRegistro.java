package br.com.bariHosh.entidade;

public enum EnumTipoRegistro  {
	
	ENTRADA("Entrada"),
	SAIDA("Saida");
	
	
	
	@SuppressWarnings("unused")
	private String descricao;
	
	private EnumTipoRegistro(String descricao) {
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
