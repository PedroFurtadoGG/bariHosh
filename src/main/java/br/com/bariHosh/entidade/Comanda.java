package br.com.bariHosh.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.bariHosh.negocio.ItemComandaRN;

@Entity
@Table(name = "comada")
public class Comanda implements Serializable {

	private static final long serialVersionUID = 2538579313415028690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_comanda;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")	
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	



	@OneToMany( cascade = CascadeType.ALL , mappedBy = "comanda")	
	private List<ItemComanda> itensDaComanda = new ArrayList<ItemComanda>();

	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, precision = 10, scale = 2)
	@NotNull
	private Date data;

	private float desconto;
	private float valorTotal;
	private boolean ativo = true;

	public Comanda() {
		setData(new Date());
	}
	
	public void adicionaItemComanda(ItemComanda item) {
		this.itensDaComanda.add(item);
		item.setComanda(this);

	}
	public void removeItemComanda(ItemComanda item) {
		this.itensDaComanda.remove(item);
		item.setComanda(null);

	}

	public void recalcularValorTotal() {
//		this.valorTotal=0;
//		for (ItemComanda item : this.getItensDaComanda()) {
////			float valorTotalDoItem = item.getValorTotal();
////			this.setValorTotal(this.getValorTotal().add(valorTotalDoItem));
//		}
//
////		this.setValorTotal(this.getValorTotal().subtract(this.getDesconto()));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId_comanda() {
		return id_comanda;
	}

	public void setId_comanda(Long id_comanda) {
		this.id_comanda = id_comanda;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<ItemComanda> getItensDaComanda() {
		if(this.getId_comanda()!=null) {
			this.itensDaComanda = new ItemComandaRN().listaIntemComandaPorComandaId(this.getId_comanda());
		}
		
		return this.itensDaComanda ;
	}

	public void setItensDaComanda(List<ItemComanda> itensDaComanda) {
		this.itensDaComanda = itensDaComanda;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + Float.floatToIntBits(desconto);
		result = prime * result + ((id_comanda == null) ? 0 : id_comanda.hashCode());
		result = prime * result + ((itensDaComanda == null) ? 0 : itensDaComanda.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + Float.floatToIntBits(valorTotal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comanda other = (Comanda) obj;
		if (ativo != other.ativo)
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Float.floatToIntBits(desconto) != Float.floatToIntBits(other.desconto))
			return false;
		if (id_comanda == null) {
			if (other.id_comanda != null)
				return false;
		} else if (!id_comanda.equals(other.id_comanda))
			return false;
		if (itensDaComanda == null) {
			if (other.itensDaComanda != null)
				return false;
		} else if (!itensDaComanda.equals(other.itensDaComanda))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (Float.floatToIntBits(valorTotal) != Float.floatToIntBits(other.valorTotal))
			return false;
		return true;
	}

	

	

}
