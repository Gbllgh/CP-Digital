package org.example.pedidos;


import org.example.repository.PedidoDatabaseRepository;
import org.example.repository.PedidoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicePedido {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private  PedidoDatabaseRepository pedidoDatabaseRepository;


    public List<Pedido> buscarTodosPedidos(){

        return pedidoDatabaseRepository.findAll();
    }


    public  Pedido encontarPedidoPeloId(Long id){

        return pedidoDatabaseRepository.findById(id).get();
    }

    public Pedido salvarPedido(Pedido pedido) {
        if(pedidoEValido(pedido)) {
            pedidoDatabaseRepository.save(pedido);
            return pedido;
        } else {
            throw new IllegalArgumentException("pedido invalido");
        }
    }

    private boolean pedidoEValido(Pedido pedido) {
        if (pedido == null || pedido.getEstoque() < 0 || pedido.getPreco() < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void deletarPedidoPeloId(Long id){

        pedidoDatabaseRepository.deleteById(id);
    }
}




