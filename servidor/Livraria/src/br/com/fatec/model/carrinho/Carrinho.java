package br.com.fatec.model.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemCarrinho> itens;
    private float precoTotal;
    
    public Carrinho(){
        this.itens = new ArrayList<>();
    }
    
    public void addItem(ItemCarrinho item){
        precoTotal += item.getValor();
        this.itens.add(item);
    }
    
    public void removeItem(ItemCarrinho item){
        precoTotal -= item.getValor();
        this.itens.remove(item);
    }
    
    public float getPrecoTotal(){
        return precoTotal;
    }
}
