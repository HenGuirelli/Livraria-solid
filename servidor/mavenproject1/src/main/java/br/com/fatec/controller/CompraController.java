package br.com.fatec.controller;

import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Cliente;

public class CompraController {
    public void comprar(Carrinho carrinho, Cliente cliente){
        for(ItemCarrinho itemCarrinho : carrinho.getItens()){
            this.comprar(itemCarrinho.getProduto(), itemCarrinho.getQuantidade(), cliente);
        }
        carrinho.esvaziar();
    }
    
    public void comprar(Livro livro, int qtd, Cliente cliente){
        //ivro.comprar(qtd);
    }
}
