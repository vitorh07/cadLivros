package com.senai.Vitor.cadLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.Vitor.cadLivros.entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long>{

}