package br.com.bariHosh.entidade;

public enum EnumPermissao {
	ROLE_ADMINISTRADOR("ADMINISTRADOR"),
	ROLE_USUARIO_CAIXA("CAIXA"), 
	ROLE_USUARIO_GARCON("GARÇON"),
	ROLE_USUARIO_VIP("VIP");

	public String chave;

	EnumPermissao(String key) {
		this.chave = key;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
