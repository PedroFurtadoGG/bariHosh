package br.com.bariHosh.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bariHosh.entidade.Caixa;
import br.com.bariHosh.entidade.FormaPagamento;

@ManagedBean(name = "caixaBean")
@ViewScoped
public class CaixaBean implements Serializable{

	private static final long serialVersionUID = -6414690959254535730L;
	private Caixa caixa = new Caixa();
	private FormaPagamento forma_pagamento;
	

	@SuppressWarnings("static-access")
	public FormaPagamento[] getForma_pagamento() {
		return forma_pagamento.values();
	}

	public void setForma_pagamento(FormaPagamento forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

}
