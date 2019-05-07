package br.com.fatec.server.endpoints;

import br.com.fatec.model.Produto.Livro;
import javax.ws.rs.Path;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("livro")
public class LivroEndpoint {
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
    public List<Livro> getLivrosPorNome(@PathParam("nome") String nome){
        return livroController.getLivrosPorNome(nome);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nome/{nome}/exato")
    public Livro getLivrosPorNomeExato(@PathParam("nome") String nome){
        try {
            return livroController.getLivrosPorNome(nome).get(0);
        }catch (Exception ex){
            return null;
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar")
    public List<Livro> buscarLivros(@QueryParam("pesquisa") String pesquisa) {        
        return livroController.buscarLivro(pesquisa);
    }
}
