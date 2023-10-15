package org.example.repository;

import org.example.pedidos.Pedido;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


    @Repository
    public class PedidoRepository {
        private final ConcurrentHashMap<Long, Pedido> pedidos = new ConcurrentHashMap<>();
        private final AtomicLong idGenerator = new AtomicLong(0);

        public List<Pedido> findAll() {
            return new ArrayList<>(pedidos.values());
        }

        public Pedido findById(Long id) {
            return pedidos.get(id);
        }

        public Pedido save(Pedido pedido) {
            if (pedido.getId() == null) {
                pedido.setId(idGenerator.incrementAndGet());
            }
            pedidos.put(pedido.getId(), pedido);
            return pedido;
        }

        public void deleteById(Long id) {
            pedidos.remove(id);
        }
    }


