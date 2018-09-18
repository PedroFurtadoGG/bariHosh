package br.com.bariHosh.entidade;

public enum FormaPagamento {

	DINHEIRO_A_VISTA("Á Vista"), CARTAO("Cartao");

	private String descricao;

	FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
