package com.javateste.apigerenciarpessoas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javateste.apigerenciarpessoas.model.Pessoa;
import com.javateste.apigerenciarpessoas.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {
	
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Pessoa>> getAll () {
		return ResponseEntity.ok(pessoaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById (@Valid @PathVariable Long id) {
		return pessoaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Pessoa> postPessoa(@Valid @RequestBody Pessoa pessoa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRepository.save(pessoa));
	}
	
	@PutMapping
	public ResponseEntity<Pessoa> putPessoa(@Valid @RequestBody Pessoa pessoa) {
		return pessoaRepository.findById(pessoa.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(pessoa)))
				.orElse(ResponseEntity.notFound().build());
	}

}
