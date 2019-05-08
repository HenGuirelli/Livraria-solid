package br.com.fatec.DAO;

import br.com.fatec.model.produto.Filme;
import br.com.fatec.model.produto.Livro;
import java.util.List;

public class FilmeDAO extends DAO<Filme> {

    private static FilmeDAO instance;

    private FilmeDAO() {
    }

    public static FilmeDAO getInstance() {
        if (instance == null) {
            instance = new FilmeDAO();
        }
        return instance;
    }

    public void add(Filme filme) {
        super.add(filme);
    }

    public void remover(Filme filme) {
        super.remove(filme);
    }
    
    public List<Filme> getAll(){
        return super.getAll();
    }

    public void atualizarQuantidade(Filme filme, int novaQuantidade) {
        for (Filme l : super.getAll()) {
            if (l.equals(filme)) {
                l.setQuantidade(novaQuantidade);
            }
        }
    }
}
