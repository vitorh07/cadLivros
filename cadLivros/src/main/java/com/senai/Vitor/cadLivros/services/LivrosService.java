package com.senai.Vitor.cadLivros.services;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.senai.Vitor.cadLivros.entities.Livros;
	import com.senai.Vitor.cadLivros.repositories.LivrosRepository;
	@Service
	public class LivrosService {

		private final LivrosRepository livrosRepository;
		
		@Autowired
		public LivrosService (LivrosRepository livrosRepository) {
			this.livrosRepository = livrosRepository;
		}
		
		public Livros saveLivros(Livros livros) {
			return livrosRepository.save(livros);
		}
		
		public Livros getLivrosById(Long id) {
			return livrosRepository.findById(id).orElse(null);
		}
		//listar todos os produtos
		public List<Livros> getAllLivros(){
			return livrosRepository.findAll();
		}
		//apagar produto
		public void deleteLivros(Long id) {
			livrosRepository.deleteById(id);
		}
		// fazendo o update do jogo com o optional
			public Livros updateLivros(Long id, Livros novoLivros) {
		        Optional<Livros> livrosOptional = livrosRepository.findById(id);
		        if (livrosOptional.isPresent()) {
		        	Livros livrosExistente = livrosOptional.get();
		           	livrosExistente.setDescricao(novoLivros.getDescricao());
		        	livrosExistente.setIsbn(novoLivros.getIsbn());          
		            return livrosRepository.save(livrosExistente); 
		        } else {
		            return null; 
		        }
		    }
	}