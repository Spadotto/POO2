package poo2.SistemaBanco.Classes;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Usuario {
	
	@Id
	private String cpf;
	private String senha;
	private String nome;
	private String sobrenome;
	private String dataNasc;
	private String endereco;
	private String cidade;
	private String email;
	
	@OneToOne
	private Cartao cartao;
	
	@ManyToMany
	private List<Convenios> convenios;
	
	public Usuario(String cpf, String senha, String nome, String sobrenome, String dataNasc, String endereco, String cidade, String email, Cartao cartao) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.cidade = cidade;
		this.email = email;
		this.cartao = cartao;
		this.convenios = new ArrayList<>();
	}
	
	public Usuario(String cpf, String senha, String nome, String sobrenome, String dataNasc, String endereco, String cidade, String email) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.cidade = cidade;
		this.email = email;
	}
	
	public Usuario(String cpf, String senha, String nome, Cartao cartao) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.cartao = cartao;
	}
	
	public Usuario(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
	}

	public Usuario() {
		
	}
	
	public List<Convenios> getConvenio() {
		return convenios;
	}

	public void setGames(List<Convenios> games) {
		this.convenios = games;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
