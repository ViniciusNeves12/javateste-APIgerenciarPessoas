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
import com.javateste.apigerenciarpessoas.model.Endereco;
import com.javateste.apigerenciarpessoas.model.Pessoa;
import com.javateste.apigerenciarpessoas.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping("/all")
	public ResponseEntity<?> getAll () {
		return ResponseEntity.ok(enderecoRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Endereco> postPessoa(@Valid @RequestBody Endereco endereco) {
		return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
	}

}
