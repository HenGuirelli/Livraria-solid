package br.com.fatec.server;

import br.com.fatec.DAO.ContaDAO;
import br.com.fatec.DAO.FornecedorDAO;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.Embalagem;
import br.com.fatec.model.produto.Filme;
import br.com.fatec.model.fornecedor.Fornecedor;
import br.com.fatec.model.produto.Livro;
import br.com.fatec.model.usuario.Usuario;

@ApplicationPath("rest")
public class Startup extends ResourceConfig {

    public Startup() {
        packages("br.com.fatec.server.endpoints");
        initDAO();
    }

    private void initDAO() {
        LivroDAO livroDAO = LivroDAO.getInstance();
        for (Livro livro : ValoresIniciais.getLivros()) {
            livroDAO.add(livro);
        }

        for (Filme filme : ValoresIniciais.getFilmes()) {
            livroDAO.add(filme);
        }
        
        ContaDAO contaDAO = ContaDAO.getInstance();
        for (Usuario user : ValoresIniciais.getUsuarios()) {
            contaDAO.add(user);
        }

        FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
        for (Fornecedor fornecedor : ValoresIniciais.getFornecedores()) {
            fornecedorDAO.add(fornecedor);
        }
        
        Embalagem embalagem = Embalagem.getInstance();
        embalagem.setQuantidade(100);
    }
}
