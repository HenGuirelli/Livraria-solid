package br.com.fatec.model.livro;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.usuario.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Livro {
    private String titulo;
    private String capa;
    private String categoria;
    private String editora;
    private float preco;
    private String resumo;
    private int quantidade;
    private boolean esgotado;
    private List<Autor> autores;
    
    // construtor
    public Livro(){
        this.autores = new ArrayList<>();
        this.esgotado = false;
    }
    
    // metodos    
    public void addAutor(Autor autor){
        this.autores.add(autor);
    }
    
    public void removerAutor(Autor autor){
        this.autores.remove(autor);
    }
    
    public void vender(Cliente cliente, int quantidade){
        // atualiza model
        int novaQuantidade = this.getQuantidade() - quantidade;
        this.setQuantidade(novaQuantidade);
        if (this.quantidade == 0){
            this.setEsgotado(true);
        }
        
        // atualiza no banco de dados
        LivroDAO dao = LivroDAO.getInstance();
        dao.atualizarQuantidade(this, novaQuantidade);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.titulo);
        hash = 13 * hash + Objects.hashCode(this.autores);
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
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        return true;
    }
    
    
    
    // getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco < 0 )
            throw new RuntimeException("Preço não pode ser negativo");
        this.preco = preco;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("Quantidade não pode ser menor que 0");
        if (quantidade == 0)
            this.setEsgotado(true);
        else
            this.setEsgotado(false);
        this.quantidade = quantidade;
    }

    public boolean isEsgotado() {
        return esgotado;
    }

    private void setEsgotado(boolean esgotado) {
        this.esgotado = esgotado;
    }
}
