package org.example.repository;

import org.example.pedidos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDatabaseRepository  extends JpaRepository<Pedido, Long> {
}
