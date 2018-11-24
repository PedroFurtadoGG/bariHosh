package br.com.bariHosh.entidade;

public enum EnumMovimentoCaixa {

	EN("ENTRADA"), SA("SA�DA");

	public String chave;

	EnumMovimentoCaixa(String key) {
		this.chave = key;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
