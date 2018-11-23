package br.com.bariHosh.entidade;

public enum FormaPagamento {

	DINHEIRO_VISTA("DINHEIRO"), CARTAO("CREDITO");

	public String chave;

	FormaPagamento(String key) {
		this.chave = key;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
