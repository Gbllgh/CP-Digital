package org.example.produtos;

import org.example.repository.ProdutoDatabaseRepository;
import org.example.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduto {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoDatabaseRepository produtoDatabaseRepository;


   public List<Produto> buscarTodos(){
       return produtoDatabaseRepository.findAll();
   }


    public  Produto encontarPeloId(Long id){

       return produtoDatabaseRepository.findById(id).get();
    }

    public Produto salvarProduto(Produto produto) {
        if(produtoEValido(produto)) {
            produtoDatabaseRepository.save(produto);
            return produto;
        } else {
            throw new IllegalArgumentException("produto invalido");
        }
    }

    private boolean produtoEValido(Produto produto) {
        if (produto == null || produto.getEstoque() < 0 || produto.getPreco() < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void deletarPeloId(Long id){
       produtoDatabaseRepository.deleteById(id);
    }
}


