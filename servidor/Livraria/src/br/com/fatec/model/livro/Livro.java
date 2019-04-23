package br.com.fatec.model.livro;

import java.util.ArrayList;
import java.util.List;

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
    
    public Livro(){
        this.autores = new ArrayList<>();
        this.esgotado = false;
    }
    
    public void addAutor(Autor autor){
        this.autores.add(autor);
    }
    
    public void removerAutor(Autor autor){
        this.autores.remove(autor);
    }
    
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
