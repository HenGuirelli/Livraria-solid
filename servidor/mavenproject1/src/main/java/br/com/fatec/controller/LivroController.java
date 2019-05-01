package br.com.fatec.controller;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.livro.Livro;
import java.util.List;

public class LivroController {
    public List<Livro> getLivros(){
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivros();
    }
    
    public List<Livro> getLivrosPorCategoria(String categoria){
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivroPorCategoria(categoria);
    }
    
    public List<Livro> getLivrosPorEditora(String editora){
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivroPorEditora(editora);
    }
}
