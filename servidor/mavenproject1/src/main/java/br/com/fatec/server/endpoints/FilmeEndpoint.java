package br.com.fatec.server.endpoints;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.model.produto.Filme;
import br.com.fatec.model.produto.Livro;
import java.util.ArrayList;
import javax.ws.rs.Path;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("filmes")
public class FilmeEndpoint {
    private final br.com.fatec.controller.LivroController livroController = new br.com.fatec.controller.LivroController();
    
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Filme> getFilmes() {
        List<Filme> filmes = new ArrayList<>();
        for (Livro livro : livroController.getLivros()){
            if (livro instanceof Filme){
                filmes.add((Filme) livro);
            }
        }
        
        return filmes;
    }*/    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Filme> getFilmes() {
        return FilmeDAO.getInstance().getAll();
    }
}
