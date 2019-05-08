package br.com.fatec.model.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens;
    
    public Carrinho(){
        this.itens = new ArrayList<>();
    }
    
    public int totalItensCarrinho(){
        int qtd = 0;
        for (ItemCarrinho item : itens)
            qtd += item.getQuantidade();
        return qtd;
    }
    
    public void addItem(ItemCarrinho item){
        this.itens.add(item);
    }
    
    public void removeItem(ItemCarrinho item){
        this.itens.remove(item);
    }
    
    public float getPrecoTotal(){
        float preco = 0;
        for (ItemCarrinho item : itens)
            preco += item.getValor();
        return preco;
    }
    
    public List<ItemCarrinho> getItens(){
        return this.itens;
    }
    
    public void esvaziar(){
        this.itens = new ArrayList();
    }
}
