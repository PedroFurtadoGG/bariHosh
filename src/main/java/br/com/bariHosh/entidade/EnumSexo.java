package br.com.bariHosh.entidade;

public enum EnumSexo {

	M("Masculino"), F("Feminino");

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
