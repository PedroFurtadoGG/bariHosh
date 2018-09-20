package br.com.bariHosh.entidade;

public enum EnumPermissao {
	ROLE_ADMINISTRADOR("administrador"),
	ROLE_USUARIO_CAIXA("caixa"), 
	ROLE_USUARIO_GARCON("garçon"),
	ROLE_USUARIO_VIP("usuariovip");

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
