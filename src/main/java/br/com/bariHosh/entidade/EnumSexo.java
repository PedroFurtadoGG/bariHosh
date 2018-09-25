package br.com.bariHosh.entidade;

public enum EnumSexo {

	MASC("masculino"), FEM("feminino");

	public String chave;

	EnumSexo(String key) {
		this.chave = key;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
