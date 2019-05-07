package br.com.fatec.controller;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.produto.Livro;

public class CompraController {    
    public void comprar(String nomeProduto, int qtd){       
        LivroDAO daoLivro = LivroDAO.getInstance();
        Livro livro = daoLivro.getUmLivroPorNome(nomeProduto);
        livro.comprar(qtd);
    }
}
