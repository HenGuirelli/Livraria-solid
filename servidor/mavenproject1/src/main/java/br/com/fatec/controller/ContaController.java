package br.com.fatec.controller;

import br.com.fatec.DAO.ContaDAO;
import br.com.fatec.model.usuario.Cliente;
import br.com.fatec.model.usuario.Funcionario;
import br.com.fatec.model.usuario.Usuario;

public class ContaController {
    public boolean logar(String login, String senha){
        ContaDAO dao = ContaDAO.getInstance();
        return dao.getUsuario(login, senha) != null;
    }
    
    public Usuario getUsuario(String login, String senha){
        ContaDAO dao = ContaDAO.getInstance();
        return dao.getUsuario(login, senha);
    }
    
    public void criarConta(String login, String senha, String nome){
        ContaDAO dao = ContaDAO.getInstance();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setLogin(login);
        cliente.setSenha(senha);
        
        dao.add(cliente);
    }
    
    public Cliente getCliente(String login, String senha) {
        Usuario usuario = getUsuario(login, senha);
        if (usuario instanceof Cliente){
            return (Cliente) usuario;
        }
        return null;
    }
    
    public Funcionario getFuncionario(String login, String senha){
        Usuario usuario = getUsuario(login, senha);
        if (usuario instanceof Funcionario){
            return (Funcionario) usuario;
        }
        return null;
    }
}
