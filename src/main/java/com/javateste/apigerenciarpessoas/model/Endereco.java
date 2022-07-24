package com.javateste.apigerenciarpessoas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O logradouro é obrigatório!")
	private String logradouro;

	@NotNull(message = "O atributo cep é Obrigatório!")
	private String cep;
	
	@NotNull(message = "O numero é obrigatório!")
	private String numero;

	@NotNull(message = "O atributo cidade é Obrigatório!")
	private String cidade;
	
	@NotNull(message = "O atributo enderecoPrincipal é Obrigatório!")
	private boolean enderecoPrincipal;
	
	@ManyToMany
	@JoinTable(name = "pessoa_endereco",
	   joinColumns = @JoinColumn( name = "endereco_id "),
	   inverseJoinColumns = @JoinColumn( name = "pessoa_id"))
	@JsonIgnoreProperties("endereco")
	private List<Pessoa> pessoa;
	
	
	public List<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public boolean getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(boolean enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}
	
	
	
}
