package br.com.fatec.model.fornecedor;

import br.com.fatec.model.produto.Livro;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fornecedor {

    private String nome;
    private List<Livro> estoque = new ArrayList<>();

    public Fornecedor() {
        Livro livro = new Livro();
        livro.setTitulo("Código Limpo");
        livro.setQuantidade(100);
    }

    public List<Livro> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Livro> estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void comprar(String nome, int quantidade) {
        for (Livro l : estoque) {
            if (l.getTitulo().equals(nome)) {
                if (l.getQuantidade() - quantidade > 0) {
                    l.setQuantidade(l.getQuantidade() - quantidade);
                }
            }
        }
    }
}
