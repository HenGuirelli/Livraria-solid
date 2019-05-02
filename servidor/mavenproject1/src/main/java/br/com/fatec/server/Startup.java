package br.com.fatec.server;

import br.com.fatec.DAO.ContaDAO;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Usuario;
import com.sun.net.httpserver.HttpServer;

@ApplicationPath("rest")
public class Startup extends ResourceConfig {
    
    public Startup(){
        packages("br.com.fatec.server.controllers");
        initDAO();
    }
    
    private void initDAO(){
        LivroDAO livroDAO = LivroDAO.getInstance();
        for(Livro livro : ValoresIniciais.getLivros()){
            livroDAO.add(livro);
        }
        
        ContaDAO contaDAO = ContaDAO.getInstance();
        for(Usuario user : ValoresIniciais.getUsuarios()) {
            contaDAO.add(user);
        }
    }
}
