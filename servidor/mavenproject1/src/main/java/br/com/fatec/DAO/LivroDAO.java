package br.com.fatec.DAO;

import br.com.fatec.model.livro.Livro;
import java.util.List;

public class LivroDAO extends DAO<Livro> {
    private static LivroDAO instance;
    
    private LivroDAO(){}
    
    public static LivroDAO getInstance(){
        if (instance == null){
            instance = new LivroDAO();
        }
        return instance;
    }
    
    public void add(Livro livro){
        super.add(livro);
    }
    
    public void remover(Livro livro) {
        super.remove(livro);
    }
    
    public List<Livro> getLivroPorNome(String nome){
        return super.filter("nome", nome);
    }
   
    public List<Livro> getLivroPorEditora(String editora){
        return super.filter("editora", editora);
    }
    
    public List<Livro> getLivroPorCategoria(String categoria){
        return super.filter("categoria", categoria);
    }
    
    public List<Livro> getLivros(){
        return super.getAll();
    }
    
    public void atualizarQuantidade(Livro livro, int novaQuantidade){
        for (Livro l : getLivros()){
            if (l.equals(livro)){
                l.setQuantidade(novaQuantidade);
            }
        }
    }
}
