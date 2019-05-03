package br.com.fatec.model.carrinho;

import br.com.fatec.model.livro.Livro;
import java.util.Objects;

public class ItemCarrinho {
    private Livro livro;
    private int quantidade = 1;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
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
        hash = 41 * hash + Objects.hashCode(this.livro);
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
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        return true;
    }
    
    
    
    public float getValor(){
        if (this.livro == null){
            System.err.println("livro é nulo na classe ItemCarrinho");
            return 0;
        }
        return livro.getPreco() * quantidade;
    }
}
