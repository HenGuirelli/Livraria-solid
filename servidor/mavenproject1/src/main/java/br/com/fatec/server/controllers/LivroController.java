package br.com.fatec.server.controllers;

import br.com.fatec.model.livro.Livro;
import javax.ws.rs.Path;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("livro")
public class LivroController {
    private final br.com.fatec.controller.LivroController livroController = new br.com.fatec.controller.LivroController();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livro> getLivros(){
        return livroController.getLivros();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categoria/{categoria}")
    public List<Livro> getLivrosPorCategoria(@PathParam("categoria") String categoria){
        return livroController.getLivrosPorCategoria(categoria);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("editora/{editora}")
    public List<Livro> getLivrosPorEditora(@PathParam("editora") String editora){
        return livroController.getLivrosPorEditora(editora);
    }
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nome/{nome}")
    public List<Livro> getLivrosPorNome(@PathParam("editora") String nome){
        return livroController.getLivrosPorNome(nome);
    }
}
