package br.com.fatec.model.carrinho;

import br.com.fatec.model.livro.Livro;

public class ItemCarrinho {
    private Livro livro;
    private int quantidade;

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
    
    public float getValor(){
        if (this.livro == null){
            System.err.println("livro é nulo na classe ItemCarrinho");
            return 0;
        }
        return livro.getPreco() * quantidade;
    }
}
