package br.com.fatec.controller;

import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.Produto.Livro;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;

public class CarrinhoController {
    public void add(Cliente cliente, Livro livro){
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(livro);
        
        boolean itemExiste = cliente.getCarrinho().getItens().contains(item);
        if (itemExiste){
            int index = cliente.getCarrinho().getItens().indexOf(item);
            ItemCarrinho i = cliente.getCarrinho().getItens().get(index);
            i.add();
        }
        else
            cliente.getCarrinho().addItem(item);
    }
    
    public void remover(Cliente cliente, Livro livro){
        for (ItemCarrinho item : cliente.getCarrinho().getItens()){
            if (item.getProduto().equals(livro)){
                cliente.getCarrinho().removeItem(item);
            }
        }
    }
    
    public void remover(Cliente cliente, ItemCarrinho item){        
        for (ItemCarrinho itemCarrinho : cliente.getCarrinho().getItens()){
            if (itemCarrinho.equals(item)){
                cliente.getCarrinho().removeItem(item);
                return;
            }
        }
    }
    
    public List<ItemCarrinho> listarItens(Cliente cliente){
        return cliente.getCarrinho().getItens();
    }
    
    public void alterarQuantidade (Cliente cliente, Livro produto, int quantidade){
        for (ItemCarrinho item : cliente.getCarrinho().getItens()){
            if(item.getProduto().equals(produto)){
                item.setQuantidade(quantidade);
            }
        }
    }
}
