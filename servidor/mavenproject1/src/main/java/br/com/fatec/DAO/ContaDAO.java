package br.com.fatec.DAO;

import br.com.fatec.model.usuario.Usuario;
import java.util.List;

public class ContaDAO extends DAO<Usuario> {
    private static ContaDAO instance;
    
    private ContaDAO() {}
    
    public static ContaDAO getInstance(){
        if(instance == null){
            instance = new ContaDAO();
        }
        return instance;
    }
    
    public void add(Usuario usuario){
        super.add(usuario);
    }
    
    public void remover(Usuario usuario){
        super.remove(usuario);
    }
    
    public Usuario getUsuario(String login, String senha){
        List<Usuario> users = super.filter("login", login);
        for(Usuario user : users){
            if (user.getSenha().equals(senha))
                return user;
        }
        return null;
    }
}
