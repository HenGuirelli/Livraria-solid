package br.com.fatec.model.carrinho;

import br.com.fatec.model.Produto.Livro;
import java.util.Objects;

public class ItemCarrinho {
    private Livro produto;
    private int quantidade = 1;

    public Livro getProduto() {
        return produto;
    }

    public void setProduto(Livro produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void add(int quantidade){
        this.quantidade += quantidade;
    }
    
    public void add(){
        this.add(1);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemCarrinho other = (ItemCarrinho) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    
    
    
    public float getValor(){
        if (this.produto == null){
            System.err.println("livro é nulo na classe ItemCarrinho");
            return 0;
        }
        return produto.getPreco() * quantidade;
    }
}
