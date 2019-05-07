package br.com.fatec.model.produto;

import br.com.fatec.DAO.FornecedorDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.fornecedor.Fornecedor;
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
    private int quantidade = 20;
    private boolean esgotado;
    private List<Autor> autores;
    private LivroDAO dao;

    static final String PATH_IMAGEM = "resources/images/";

    // construtor
    public Livro() {
        this.autores = new ArrayList<>();
        this.esgotado = false;
        dao = LivroDAO.getInstance();
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

    public void vender(Cliente cliente, int quantidade) {
        // atualiza model
        int novaQuantidade = this.getQuantidade() - quantidade;
        this.setQuantidade(novaQuantidade);
        if (this.quantidade == 0) {
            this.setEsgotado(true);
        }

        // atualiza no banco de dados
        dao.atualizarQuantidade(this, novaQuantidade);
    }
    
    public void comprar(int quantidade) {
        FornecedorDAO daoFornecedor = FornecedorDAO.getInstance();
        List<Fornecedor> fornecedores = daoFornecedor.getTodosFornecedores();
        
        Fornecedor fornecedor = procurarFornecedorComProduto(this.getTitulo(), fornecedores);
        fornecedor.comprar(this.getTitulo(), quantidade);
        
        // atualiza no banco de dados
        this.setQuantidade(this.getQuantidade() + quantidade);
        dao.atualizarQuantidade(this, this.getQuantidade());
    }
    
    private Fornecedor procurarFornecedorComProduto(String nomeProduto, List<Fornecedor> fornecedores){
        for(Fornecedor fornecedor : fornecedores){
            for(Livro produto : fornecedor.getEstoque()){
                if(produto.getTitulo().equals(nomeProduto)){
                    return fornecedor;
                }
            }
        }
        return null;
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
        if (capa.startsWith(PATH_IMAGEM)) {
            this.capa = capa;
        } else {
            this.capa = PATH_IMAGEM + capa;
        }
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
        if (preco < 0) {
            throw new RuntimeException("Preço não pode ser negativo");
        }
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
        if (quantidade < 0) {
            throw new RuntimeException("Quantidade não pode ser menor que 0");
        }
        if (quantidade == 0) {
            this.setEsgotado(true);
        } else {
            this.setEsgotado(false);
        }
        this.quantidade = quantidade;
    }

    public boolean isEsgotado() {
        return esgotado;
    }

    private void setEsgotado(boolean esgotado) {
        this.esgotado = esgotado;
    }
}
