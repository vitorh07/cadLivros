package com.senai.Vitor.cadLivros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.Vitor.cadLivros.entities.Livros;
import com.senai.Vitor.cadLivros.services.LivrosService;

@RestController
@RequestMapping("/livros")
public class LivrosController {
	private final LivrosService livrosService;
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}
	
	@Autowired
	public LivrosController (LivrosService livrosService) {
		this.livrosService = livrosService;
	}
	
	@PostMapping
	public Livros createProduct(@RequestBody Livros livros) {
		return livrosService.saveLivros(livros);
	}

	@GetMapping
	public List<Livros> getAllLivros(){
		return livrosService.getAllLivros();
	}
	
	@GetMapping("/{id}")
	public Livros getLivros(@PathVariable Long id) {
		return livrosService.getLivrosById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteLivros(@PathVariable Long id) {
		livrosService.deleteLivros(id);
	}
	
		
		@PutMapping("/{id}")
		public Livros updateLivros(@PathVariable Long id, @RequestBody Livros livros) {
		    return livrosService.updateLivros(id, livros);
		}
	
}
