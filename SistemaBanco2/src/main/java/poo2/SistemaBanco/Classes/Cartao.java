package poo2.SistemaBanco.Classes;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Cartao {
	
	@Id
	private String numCartao;
	private String datavenc;
	private String cvv;
	private double saldo;
	private double limite;
	
	public Cartao(String numCartao, String datavenc, String cvv, double saldo, double limite) {
		super();
		this.numCartao = numCartao;
		this.datavenc = datavenc;
		this.cvv = cvv;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	public Cartao(String numCartao) {
		super();
		this.numCartao = numCartao;
	}
	
	public Cartao() {
		super();
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getDatavenc() {
		return datavenc;
	}

	public void setDatavenc(String datavenc) {
		this.datavenc = datavenc;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numCartao == null) ? 0 : numCartao.hashCode());
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
		Cartao other = (Cartao) obj;
		if (numCartao == null) {
			if (other.numCartao != null)
				return false;
		} else if (!numCartao.equals(other.numCartao))
			return false;
		return true;
	}
	
}
