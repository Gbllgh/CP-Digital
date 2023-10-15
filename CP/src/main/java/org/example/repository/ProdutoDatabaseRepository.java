package org.example.repository;

import org.example.produtos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoDatabaseRepository extends JpaRepository<Produto,Long> {
}
