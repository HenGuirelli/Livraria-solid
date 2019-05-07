package br.com.fatec.controller;

import br.com.fatec.DAO.FornecedorDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.fornecedor.Fornecedor;
import br.com.fatec.model.produto.Livro;
import java.util.List;

public class CompraController {    
    public void comprar(String nomeProduto, int quantidade){       
        LivroDAO daoLivro = LivroDAO.getInstance();
        Livro livro = daoLivro.getUmLivroPorNome(nomeProduto);
        
        FornecedorDAO daoFornecedor = FornecedorDAO.getInstance();
        List<Fornecedor> fornecedores = daoFornecedor.getTodosFornecedores();
        
        Fornecedor fornecedor = procurarFornecedorComProduto(nomeProduto, fornecedores);
        fornecedor.comprar(nomeProduto, quantidade);
        
        livro.comprar(quantidade);
        
        // atualiza no banco de dados
        daoLivro.atualizarQuantidade(livro, livro.getQuantidade());
    }
    
    private Fornecedor procurarFornecedorComProduto(String nomeProduto, List<Fornecedor> fornecedores){
        for(Fornecedor fornecedor : fornecedores){
            for(Livro produto : fornecedor.getEstoque()){
                if(produto.getTitulo().equals(nomeProduto)){
                    return fornecedor;
                }
            }
        }
        return null;
    }
}
