package com.javateste.apigerenciarpessoas.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull(message = "O nome é obrigatório!")
		private String nome;

		@NotNull(message = "O atributo dataNascimento é Obrigatório!")
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		private Date dataNascimento;
		
		@ManyToMany(mappedBy = "pessoa")
		@JsonIgnoreProperties("pessoa")
		private List<Endereco> endereco;
		
		public List<Endereco> getEndereco() {
			return endereco;
		}

		public void setEndereco(List<Endereco> endereco) {
			this.endereco = endereco;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

}
