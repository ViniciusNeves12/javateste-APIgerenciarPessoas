package com.javateste.apigerenciarpessoas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javateste.apigerenciarpessoas.model.Endereco;
import com.javateste.apigerenciarpessoas.model.Pessoa;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	public List<Endereco> findAllByPessoaContaining(Pessoa pessoa);
}
