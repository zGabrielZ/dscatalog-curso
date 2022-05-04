package com.devsuperior.dscatalog.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dscatalog.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

}
