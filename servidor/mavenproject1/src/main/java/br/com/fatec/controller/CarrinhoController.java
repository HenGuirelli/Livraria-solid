package br.com.fatec.controller;

import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;

public class CarrinhoController {
    public void add(Cliente cliente, Livro livro){
        ItemCarrinho item = new ItemCarrinho();
        item.setLivro(livro);
        
        boolean itemExiste = cliente.getCarrinho().getItens().contains(item);
        System.out.println("existe: " + itemExiste);
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
            if (item.getLivro().equals(livro)){
                cliente.getCarrinho().removeItem(item);
            }
        }
    }
    
    public List<ItemCarrinho> listarItens(Cliente cliente){
        return cliente.getCarrinho().getItens();
    }
}
