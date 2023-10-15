package org.example.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

    @Autowired
    private ServiceProduto serviceProduto;

    @PostMapping()
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(serviceProduto.salvarProduto(produto));

    }

    @GetMapping()
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        return ResponseEntity.ok(serviceProduto.buscarTodos());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Produto> updateProduto(@PathVariable Long id,@RequestBody Produto produto){
        if (serviceProduto.encontarPeloId(id)==null){
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        return ResponseEntity.ok(serviceProduto.salvarProduto(produto));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (serviceProduto.encontarPeloId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        serviceProduto.deletarPeloId(id);
        return ResponseEntity.noContent().build();
    }

}

