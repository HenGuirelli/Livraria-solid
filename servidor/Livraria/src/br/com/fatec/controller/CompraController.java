package br.com.fatec.controller;

import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Cliente;

public class CompraController {
    public void comprar(Carrinho carrinho, Cliente cliente){
        for(ItemCarrinho itemCarrinho : carrinho.getItens()){
            this.comprar(itemCarrinho.getLivro(), cliente);
        }
        carrinho.esvaziar();
    }
    
    public void comprar(Livro livro, Cliente cliente){
        
    }
}
