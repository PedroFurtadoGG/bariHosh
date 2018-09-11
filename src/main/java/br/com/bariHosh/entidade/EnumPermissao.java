package br.com.bariHosh.entidade;

public enum EnumPermissao {		
	ROLE_ADMINISTRADOR("ROLE_ADMINISTRADOR"),
	ROLE_USUARIO_CAIXA("ROLE_USUARIO"),
	ROLE_USUARIO_GARCON("ROLE_USUARIO"),
	ROLE_USUARIO_VIP("ROLE_USUARIO");
	
	public String chave ;	
	
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
