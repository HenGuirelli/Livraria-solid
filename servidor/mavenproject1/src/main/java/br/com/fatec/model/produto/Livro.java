package br.com.fatec.model.produto;

import br.com.fatec.model.usuario.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Livro extends Produto implements Negociavel {
  
    private String editora;    
    private List<Autor> autores;

    // construtor
    public Livro() {
        this.autores = new ArrayList<>();
    }

    // metodos    
    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void removerAutor(Autor autor) {
        this.autores.remove(autor);
    }
    
    public List<Autor> getAutores(){
        return autores;
    }

    public void vender(int quantidade) {
        // atualiza model
        int novaQuantidade = this.getQuantidade() - quantidade;
        this.setQuantidade(novaQuantidade);
        if (this.getQuantidade() == 0) {
            this.setEsgotado(true);
        }
    }
    
    public void comprar(int quantidade){        
        this.setQuantidade(this.getQuantidade() + quantidade);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.getTitulo());
        hash = 13 * hash + Objects.hashCode(this.getAutores());
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.getTitulo(), other.getTitulo())) {
            return false;
        }
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        return true;
    }

    // getters e setters
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
